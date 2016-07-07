package ngves.asiainfo.core.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiAllegeReplySendBean;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeReplySendValue;
import ngves.asiainfo.core.csvc.service.interfaces.ICrmAllegeSendSrv;
import ngves.asiainfo.core.csvc.util.CsvcUtil;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;


public class AllegeInfo {
    private static Log logger = LogFactory.getLog(AllegeInfo.class);

    /**
     * 更新投诉单异常订单状态完成
     */
    private static final String UPDATE_ALLEGE_INFO_EXP_OVER = "UPDATE ALLEGE_INFO SET ALLEGE_STATUS='107',STATUS_TIME=SYSDATE,EXGBACK_OVER_TIME=SYSDATE WHERE ALLEGE_STATUS='103' AND EXGBACK_ORDER_ID=?";

    /**
     * 更新投诉单异常订单为101待客服处理
     */
    private static final String UPDATE_ALLEGE_INFO_EXP_CANCEL = "UPDATE ALLEGE_INFO SET ALLEGE_STATUS='101',STATUS_TIME=SYSDATE,EXGBACK_OVER_TIME=SYSDATE WHERE ALLEGE_STATUS='103' AND EXGBACK_ORDER_ID=?";

    /**
     * 根据投诉单异常订单的allege_id找到该订单
     */
    private static final String SELECT_ALLGE_INFO_EXP_BY_ALLEGE_ID = "SELECT INDICTSEQ, DEAL_DESC, USER_LEVEL, USER_BRAND, COM_TYPE_ID, RESP_OP_ID, ALLEGE_KIND_ID FROM ALLEGE_INFO WHERE EXGBACK_ORDER_ID = ?";
    
    /**
     * 根据投诉单allege_kind_id找到服务请求编码版本号
     */
    private static final String SELECT_VERSION_CODE_BY_ALLEGE_KIND_ID = "SELECT VERSION_CODE FROM ALLEGE_KIND WHERE ALLEGE_KIND_ID = ?";
    

    private AllegeInfo() {
        // 不进行实例化
    }

    /**
     * 根据异常订单标识将与其关联的投诉单更新状态和FINISH_FLAG 此处不再抛出异常，不管是否更新成功，只进行记录
     *
     * @param conn
     * @param expId
     * @throws Exception
     */
    public static void updateAllegeInfoExpOver(Connection conn, String expId) {
        if (StringUtil.isBlank(expId)) {
            logger.error("Update allege info Illegal arguments! expId=" + expId);
        }
        PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement(UPDATE_ALLEGE_INFO_EXP_OVER);
            psmt.setString(1, expId);
            int count = psmt.executeUpdate();
            if (count <= 0) {
                logger.error("Update allege info affected 0 rows! expId=" + expId);
            } else {
                logger.info("Update allege info affected " + count + " rows! expId=" + expId);
                //如果该异常单的indictseq字段不为空，则向一级客服发送“回复投诉单”的请求
                sendAllegeReplyIfNecessary(conn, expId);
            }
            psmt.close();
        } catch (Exception e) {
            logger.error("update user exchange record table stock in flag ," + " expId=" + expId, e);
        } finally {
            // 关闭数据库连接
            try {
                if (null != psmt)
                    psmt.close();
            } catch (Exception e) {
                logger.error("can not close preparestatement!", e);
            }
        }
    }

    /**
     * 发送投诉回复给一级客服(前提是该异常单有indictseq字段)
     *
     * @param conn
     * @param expOrderId
     * @throws Exception
     */
    private static void sendAllegeReplyIfNecessary(Connection conn, String expOrderId) throws Exception {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        IBusiAllegeReplySendValue replySendValue = null;
        try {
            psmt = conn.prepareStatement(SELECT_ALLGE_INFO_EXP_BY_ALLEGE_ID);
            psmt.setString(1, expOrderId);
            rs = psmt.executeQuery();
            logger.info("[close_exp] fetch_allege_info_by_expId: " + expOrderId);
            if (!rs.next()) {
                logger.error("[close_exp] no record found: select allege info by expId:" + expOrderId);
            } else {
                String indictSeq = rs.getString("INDICTSEQ");
                String dealDesc = rs.getString("DEAL_DESC");
                String userLevel = rs.getString("USER_LEVEL");
                String userBrand = rs.getString("USER_BRAND");
                String comTypeId = rs.getString("COM_TYPE_ID");
                String respOpId = rs.getString("RESP_OP_ID");
                String allegeKindId = rs.getString("ALLEGE_KIND_ID");
                String satisfaction = "01"; //默认为满意
//                String dutyReason = "03"; //03 - 集团客户部
                
                //根据服务请求编码获取对应版本的责任原因
                String dutyReason = queryDutyReasonByAllegeKindId(conn, allegeKindId);
                
                String dutyCauseGrade = "02"; //02 省级
                
                logger.info("[close_exp] allege_info: expId:" + expOrderId + " indictseq:" + indictSeq + "" );
                if(!StringUtil.isBlank(indictSeq)){
                	 replySendValue = buildAllegeReply(indictSeq, dealDesc, userLevel, userBrand, comTypeId, respOpId, satisfaction, dutyReason, dutyCauseGrade);
                     if (replySendValue != null) {
                        ICrmAllegeSendSrv service = (ICrmAllegeSendSrv) ServiceFactory
                                .getService(CoreSrvContstant.SERVICE_CRM_ALLEGE_SEND);
                            logger.info("[close_exp] sendingAllegeReply...");
                            service.allegeReply(replySendValue);
                            logger.info("[close_exp] SendAllgeReply is finished");
                    }
                }
            }
            psmt.close();
        } catch (Exception e) {
            logger.error("[close_exp] Update allege info error ," + " expId=" + expOrderId, e);
        } finally {
            // 关闭数据库连接
            try {
                if (null != psmt)
                    psmt.close();
            } catch (Exception e) {
                logger.error("can not close preparestatement!", e);
            }
        }


    }
    
    /**
     * 根据服务请求编码获取对应版本的责任原因
     * @param conn
     * @param allegeKindId
     * @return
     */
    public static String queryDutyReasonByAllegeKindId(Connection conn, String allegeKindId) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String dutyReason = "";
		try {
			psmt = conn.prepareStatement(SELECT_VERSION_CODE_BY_ALLEGE_KIND_ID);
			psmt.setString(1, allegeKindId);
			rs = psmt.executeQuery();
			logger.info("[query_dutyreason] " + SELECT_VERSION_CODE_BY_ALLEGE_KIND_ID);
			logger.info("[query_dutyreason] allegeKindId = " + allegeKindId);
			if (!rs.next()) {
				logger.error("[query_dutyreason] no record found: select verison_code by allegeKindId:" + allegeKindId);
			} else {
				String versionCode = rs.getString("VERSION_CODE");
				logger.info("[query_dutyreason] versionCode = "+versionCode);
				if ("10".equals(versionCode)) {
					dutyReason = "100109"; //V3.0 合作商原因
				} else {
					dutyReason = "0112"; //V2.0 合作商原因
				}
			}
			psmt.close();
		} catch (SQLException e) {
			logger.error("[query_dutyreason] Query dutyReason error ," + " allegeKindId=" + allegeKindId, e);
		} finally {
            // 关闭数据库连接
            try {
                if (null != psmt)
                    psmt.close();
            } catch (Exception e) {
                logger.error("can not close preparestatement!", e);
            }
        }
		return dutyReason;
	}

    public static IBusiAllegeReplySendValue buildAllegeReply(String indictSeq, String dealDesc, String userLevel, String userBrand, String comTypeId, String respOpId, String satisfaction, String dutyReason, String dutyCauseGrade) throws Exception {
        IBusiAllegeReplySendValue ret = new BusiAllegeReplySendBean();
        //投诉工单编号
        ret.setIndictseq(indictSeq);
        //用户满意度
        ret.setSatisfaction(satisfaction);
        //投诉处理结果:简单明确的描述处理意见
        ret.setIndictrslt(dealDesc);
        //用户级别:见附录
        ret.setSubslevel(CsvcUtil.getUserLevelFromNgvesToCsvc(userLevel));
        //用户品牌:见附录
        ret.setSubsbrand(CsvcUtil.getBrandCodeFromNgvesToCsvc(userBrand));
        //回单部门:“编码-描述”形式
        ret.setHandlingdept(comTypeId);
        //回单人:“编码-描述”形式
        ret.setHandlingstaff(respOpId + "");
        //回单人联系电话
//        ISysStaffValue staff = csvcAllegeInfoDAO.getSysStaffValue(respOpId + "");
//        ret.setStaffcontactphone(staff == null ? "" : staff.getBillId());
        ret.setStaffcontactphone("");   //TODO: 从sys_staff表中取
        //回单时间:yyyy-MM-dd HH:mm:ss，工单回单时间
        ret.setReplytime(DateTimeUtil.getDefaultSysDate());
        //责任原因:详见“责任原因”编码表
        //省客服在界面上选择，传入到这里
        ret.setDutyreason(dutyReason);

        //责任原因级别：一级客服改造V3.0版新增字段
        ret.setDutycausegrade(dutyCauseGrade);
        
        return ret;
    }
    
    public static void updateAllegeInfoExpCancel(Connection conn, String expId) {
        if (StringUtil.isBlank(expId)) {
            logger.error("Update allege info Illegal arguments! expId=" + expId);
        }
        PreparedStatement psmt = null;
        try {
            psmt = conn.prepareStatement(UPDATE_ALLEGE_INFO_EXP_CANCEL);
            psmt.setString(1, expId);
            int count = psmt.executeUpdate();
            if (count <= 0) {
                logger.error("Update allege info affected 0 rows! expId=" + expId);
            } else {
                logger.info("Update allege info affected " + count + " rows! expId=" + expId);
            }
            psmt.close();
        } catch (Exception e) {
            logger.error("Update allege info error ," + " expId=" + expId, e);
        } finally {
            // 关闭数据库连接
            try {
                if (null != psmt)
                    psmt.close();
            } catch (Exception e) {
                logger.error("can not close preparestatement!", e);
            }
        }
    }
}
