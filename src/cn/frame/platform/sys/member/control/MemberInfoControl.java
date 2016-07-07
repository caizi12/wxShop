package cn.frame.platform.sys.member.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.constant.MemberConstant;
import cn.frame.platform.common.util.MD5Encoder;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.common.util.img.ImgUtil;
import cn.frame.platform.common.util.properties.PropertiesUtil;
import cn.frame.platform.entitys.MemberInfo;
import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.sys.dict.service.SysDictSrv;
import cn.frame.platform.sys.member.service.MemberInfoSrv;
import cn.frame.platform.sys.weixin.WeixinConstant;

@Controller
@RequestMapping("/sys")
public class MemberInfoControl extends HttpServlet {

	private static Logger log = Logger.getLogger(MemberInfoControl.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberInfoSrv memberInfoSrv;

	@Autowired
	private SysDictSrv sysDictSrv;

	/**
	 * 新增用户及重置密码时的默认密码
	 */
	public static final String defaultPassword = "666888";

	@SuppressWarnings("unchecked")
	@RequestMapping("/mngMemberInfo_page")
	public ModelAndView userPage(MemberInfo memberInfo) {

		Map<String, String> paramMap = new HashMap<String, String>();
		Map map = new HashMap();
		paramMap.put("dictTypeValue", "userStatus");
		map.put("status", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "memberType");
		map.put("memberType", sysDictSrv.querySysDictByDictValue(paramMap));

		return new ModelAndView("sys/member/mng_member_info", "dictMap", map);
	}

	@RequestMapping("/queryMemberInfo")
	@ResponseBody
	public DataGridModel queryMemberInfoList(DataGridModel dataGrid, HttpServletRequest request) {

		RequestParmConvert.intropectToDataGrid(request, dataGrid);
		return memberInfoSrv.queryMemberInfoData(dataGrid);
	}

	@RequestMapping("/getMemberInfo")
	@ResponseBody
	public ModelAndView getMemberInfo(MemberInfo memberInfo, @RequestParam("viewType")
	String viewType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewType", viewType);
		if (!"add".equals(viewType)) {
			map.put("memberInfo", memberInfoSrv.getMemberInfo(memberInfo));
		}
		return new ModelAndView("sys/member/member_info", "dataMap", map);
	}

	@RequestMapping("/addMemberInfo_page")
	public ModelAndView addMemberInfoPage() {
		return new ModelAndView("sys/member/add_sys_user");
	}

	@RequestMapping("/addMemberInfo")
	@ResponseBody
	public Map<String, String> addMemberInfo(MemberInfo memberInfo) {
		Map<String, String> msg = new HashMap<String, String>();
		try {
			memberInfo.setPassword(MD5Encoder.getMD5(memberInfo.getPassword()));
			memberInfoSrv.addMemberInfo(memberInfo);
			msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
		} catch (Exception e) {
			msg.put("msg", PropertiesUtil.getMessValue("sys_save_error"));
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/viewMemberInfo_page")
	public ModelAndView memberInfoViewPage() throws ServletException, IOException {
		return new ModelAndView("sys/member/member_info");
	}

	@SuppressWarnings("finally")
	@RequestMapping("/updateMemberInfo")
	@ResponseBody
	public Map<String, String> updateMemberInfo(MemberInfo memberInfo, @RequestParam("viewType")
	String viewType) {
		Map<String, String> msg = new HashMap<String, String>();
		boolean result = false;
		try {
			// 后台新增用户密码与手机号一致
			if ("add".equals(viewType)) {
				memberInfo.setPassword(MD5Encoder.getMD5(defaultPassword));
				result = memberInfoSrv.addMemberInfo(memberInfo);
			} else if ("update".equals(viewType)) {
				if (memberInfoSrv.updateMemberInfo(memberInfo) > 0) {
					result = true;
				}
				;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result) {
				msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
				msg.put("result", "true");
			} else {
				msg.put("msg", PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result", "false");
			}
			return msg;
		}
	}

	/**
	 * 重置用户密码 重置后的密码与手机号一致
	 * 
	 * @param memberInfo
	 * @param viewType
	 * @return
	 */
	@SuppressWarnings( { "finally", "unchecked" })
	@RequestMapping("/resetPassword")
	@ResponseBody
	public Map<String, String> resetMemberPassword(@RequestParam("memberIds")
	String memberIds) {
		Map<String, String> msg = new HashMap<String, String>();
		boolean result = false;
		try {
			String newPassword = MD5Encoder.getMD5(defaultPassword);
			// 后台新增用户密码与手机号一致
			if (StringUtils.isNotBlank(memberIds)) {
				MemberInfo member = null;
				List<MemberInfo> list = new ArrayList();
				for (String memberId : memberIds.split(",")) {
					member = new MemberInfo();
					member.setMemberId(Integer.parseInt(memberId));
					member.setUpdateTime(new Date());
					member.setPassword(newPassword);
					list.add(member);
				}
				memberInfoSrv.resetMemberInfoPasswor(list);
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result) {
				msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
				msg.put("result", "true");
			} else {
				msg.put("msg", PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result", "false");
			}
			return msg;
		}
	}

	@RequestMapping("/batchDelMemberInfo")
	@ResponseBody
	public Map<String, String> batchDelMemberInfo(@RequestParam("memberId")
	List<String> memberId) {
		Map<String, String> msg = new HashMap<String, String>();
		try {
			memberInfoSrv.batchDelMemberInfo(memberId);
			msg.put("result", "true");
			msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		} catch (Exception e) {
			msg.put("result", "false");
			msg.put("msg", PropertiesUtil.getMessValue("sys_del_error"));
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/updateMemberToDelStatus")
	@ResponseBody
	public Map<String, String> updateMemberToDelStatus(@RequestParam("memberId")
	List<String> memberId) {
		Map<String, String> msg = new HashMap<String, String>();
		try {
			memberInfoSrv.updateMemberToDelStatus(memberId);
			msg.put("result", "true");
			msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		} catch (Exception e) {
			msg.put("result", "false");
			msg.put("msg", PropertiesUtil.getMessValue("sys_del_error"));
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/changeMemberInfoPass")
	@ResponseBody
	public Map<String, Object> changeUserPassword(HttpServletRequest request, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = null;
		boolean result = false;
		try {

			String newPwd = request.getParameter("newPwd");
			String newPwd2 = request.getParameter("newPwd2");
			if (newPwd == null || !newPwd.equals(newPwd2)) {
				msg = "新密码输入有误，请重新输入！";
			}

			MemberInfo memberInfo = new MemberInfo();
			memberInfo = memberInfoSrv.getMemberInfo(memberInfo);
			if (!memberInfo.getPassword().equals(MD5Encoder.getMD5(request.getParameter("oldPwd")))) {
				msg = "原密码输入不正确，请重新输入！";
			}

			memberInfo.setPassword(MD5Encoder.getMD5(newPwd));
			if (msg == null && memberInfoSrv.changeMemberInfoPwd(memberInfo) == 1) {
				result = true;
				msg = "修改密码成功！";
			}
		} catch (Exception e) {
			msg = "系统异常，修改密码失败，请联系管理员！";
			e.printStackTrace();
		}
		map.put("msg", msg);
		map.put("result", result);
		return map;
	}

	@RequestMapping("/checkMemberMobileNo")
	@ResponseBody
	public String checkUserName(HttpServletRequest request) {
		Map<String, Object> map = RequestParmConvert.intropectToMap(request);
		try {
			int countUser = memberInfoSrv.queryCountMemberInfo(map);
			if (countUser == 0) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception e) {
			map.put("msg", "系统异常请稍后再试！");
			map.put("result", false);
		}
		return "";
	}

	/**
	 * 下载二维码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/downloadQrCodeImg")
	public void downloadQrCodeImg(HttpServletRequest request, MemberInfo memberInfo, HttpServletResponse response) {
		Map<String, Object> map = RequestParmConvert.intropectToMap(request);
		try {
			memberInfo = memberInfoSrv.getMemberInfo(memberInfo);
			String qrCodeFileName = memberInfo.getQrCodeImg();
			if (memberInfo == null || StringUtils.isBlank(qrCodeFileName)) {
				qrCodeFileName = MemberInfoControl.getQrCodeImgFromWeixin(String.valueOf(memberInfo.getMemberId()),request);
						
				if (StringUtils.isNotBlank(qrCodeFileName)) {
					memberInfo.setQrCodeImg(qrCodeFileName);
					memberInfoSrv.updateMemberQrImg(memberInfo);
				}
			}
			
			
			if(StringUtils.isNotBlank(qrCodeFileName)){
				String filePath = request.getSession().getServletContext().getRealPath("/")+ MemberConstant.MEMBER_QR_CODE_DOWNLOAD_URL;
				MemberInfoControl.printFile(response,filePath+qrCodeFileName,new String(("二维码_"+memberInfo.getMemberId()+".jpg").getBytes("utf-8"),"iso-8859-1"));
			}

		} catch (Exception e) {
			map.put("msg", "系统异常请稍后再试！");
			map.put("result", false);
		}
	 
	}

	/**
	 * 输出文件进行下载
	 * 
	 * @param response
	 * @param filePath
	 * @param fileName
	 */
	public static void printFile(HttpServletResponse response, String filePath, String fileName) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			File file = new File(filePath);
			InputStream inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			inputStream.close();
		}catch(Exception e) {
			log.error("printFile error", e);
		}
	}

	/**
	 * 下载微信二维码到本地
	 * @param memberId
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getQrCodeImgFromWeixin(String memberId, HttpServletRequest request) {
		try {
			String access_token = WeiXinOauth2Token.getWeixinAccessToken();
			if (StringUtils.isNotBlank(access_token)) {

				HttpsRequest httpsRequest = new HttpsRequest();
				String returnJson = httpsRequest.sendPost(WeixinConstant.QM_CODE_URL + access_token,
						WeixinConstant.QM_PARAM_DATA.replace("SCENE_STR", WeixinConstant.EVENT_KEY_SCAN_QR_REGISTER
								+ memberId));
				Map<String, String> qrMap = objectMapper.readValue(returnJson, Map.class);
				String qrTicket = qrMap.get("ticket");
				String rootPath = request.getSession().getServletContext().getRealPath("/")
						+ MemberConstant.MEMBER_QR_CODE_DOWNLOAD_URL;
				return ImgUtil.downloadImgFromUrl(WeixinConstant.QR_CODE_DOWNLOAD_URL+qrTicket, rootPath);
			}
		} catch (Exception e) {
			log.error("getQrCodeImgFromWeixin error", e);
			return null;
		}
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}
}
