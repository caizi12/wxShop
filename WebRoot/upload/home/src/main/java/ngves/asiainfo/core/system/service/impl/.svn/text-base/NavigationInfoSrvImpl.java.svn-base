package ngves.asiainfo.core.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.bo.NavigationInfoEngine;
import ngves.asiainfo.core.system.dao.interfaces.INavigationInfoDAO;
import ngves.asiainfo.core.system.ivalues.INavigationInfoValue;
import ngves.asiainfo.core.system.service.interfaces.INavigationInfoSrv;
import ngves.asiainfo.util.StringUtil;

/**
 * 导航标签业务逻辑处理
 * @author shenfl
 *
 */
public class NavigationInfoSrvImpl implements INavigationInfoSrv {

    public static final String NAVIAGTION_INFO_MODIFIY = "修改";
    public static final String NAVIAGTION_INFO_DEL = "删除";

    private INavigationInfoDAO navigationInfoDAO = null;

    public void setNavigationInfoDAO(INavigationInfoDAO navigationInfoDAO) {
        
        this.navigationInfoDAO = navigationInfoDAO;
    }

    
    public void deleteNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {
        navigationInfoDAO.deleteNavigationInfo(navigationInfo);

    }

    public void deleteNavigationInfos(INavigationInfoValue[] navigationInfos) throws Exception {
        long recordCount = navigationInfos.length;
        for (int i = 0; i < recordCount; i++) {
            navigationInfoDAO.deleteNavigationInfo(navigationInfos[i]);
        }
    }

    /**
     * 批量删除
     * @param navIdes       
     * @return
     */
    public void deleteNavigationInfos(String[] navIds) throws Exception{
        
        INavigationInfoValue navigationInfo = null;
        for(int i = 0;i<navIds.length;i++) {
            //取得当前导航标识的对象
          navigationInfo = this.navigationInfoDAO.queryNavigationInfoValueById(new Long(navIds[i]));
          this.navigationInfoDAO.deleteNavigationInfo(navigationInfo);
        }
    }
    
    public INavigationInfoValue queryNavigationInfoValueById(Long navigationInfoId) throws Exception {
        return  this.navigationInfoDAO.queryNavigationInfoValueById(navigationInfoId);
    }

    /**
     * 导航标签查询-支持模糊查询
     * @param navDesc       导航描述
     * @param startRowIndex
     * @param endRowIndex
     * @return
     */
    public INavigationInfoValue[] findAllNavInfosByNavDesc(String navDesc, int startIndex, int endIndex)
            throws Exception {

        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtil.isBlank(navDesc)) {
            navDesc = navDesc.trim();
            sql.append(INavigationInfoValue.S_NavDesc).append(" LIKE :").append(INavigationInfoValue.S_NavDesc).append(
                    " ");
            params.put(INavigationInfoValue.S_NavDesc, "%" + navDesc + "%");
        }
        sql.append(" ORDER BY  ").append(INavigationInfoValue.S_SortId);
        //取得查询记录
        INavigationInfoValue[] navigationInfos = queryNavigationInfoValues(sql.toString(), params, startIndex, endIndex);
        //活动操作设置
        StringBuffer sb = null;
        for (INavigationInfoValue navInfo : navigationInfos) {
            sb = new StringBuffer();
            sb.append(String.format(SystemSrvConstant.MODIFY_NAVIGATION_INFO_LINK, navInfo.getNavId())).append(" ")
                    .append(String.format(SystemSrvConstant.DELETE_NAVIGATION_INFO_LINK, navInfo.getNavId()));
            navInfo.setBakCol(sb.toString());
            sb = null;
        }
        return navigationInfos;
    }

    /**
     * 取得导航标签记录
     * @param nagDesc
     * @return
     */
    public int countByNavDesc(String navDesc) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtil.isBlank(navDesc)) {
            navDesc = navDesc.trim();
            sql.append(INavigationInfoValue.S_NavDesc).append(" like '%").append(INavigationInfoValue.S_NavDesc).append("%'");
            params.put(INavigationInfoValue.S_NavDesc, navDesc);
        }

        return NavigationInfoEngine.getBeansCount(sql.toString(), params);
    }
    
    /**
     * 取得导航标签记录
     * @param nagDesc
     * @return
     */
    public int countByNavDescEqual(String navDesc) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtil.isBlank(navDesc)) {
            navDesc = navDesc.trim();
            sql.append(INavigationInfoValue.S_NavDesc).append("=:").append(INavigationInfoValue.S_NavDesc);
            params.put(INavigationInfoValue.S_NavDesc, navDesc);
        }

        return NavigationInfoEngine.getBeansCount(sql.toString(), params);
    }

    //查询条件-查询参数
    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param) throws Exception {

        return this.navigationInfoDAO.queryNavigationInfoValues(condition, param);
    }

    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param, int startIndex, int endIndex)
            throws Exception {

        return this.navigationInfoDAO.queryNavigationInfoValues(condition, param, startIndex, endIndex);
    }

    public void saveNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {
        this.navigationInfoDAO.saveNavigationInfo(navigationInfo);

    }

    public void updateNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {

        this.navigationInfoDAO.updateNavigationInfo(navigationInfo);
    }
}
