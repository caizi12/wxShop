package ngves.asiainfo.core.system.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.system.bo.NavigationInfoEngine;
import ngves.asiainfo.core.system.dao.interfaces.INavigationInfoDAO;
import ngves.asiainfo.core.system.ivalues.INavigationInfoValue;

/**
 * 导航页签数据处理
 * @author shenfl
 *
 */
public class NavigationInfoDAOImpl implements INavigationInfoDAO {

    public void deleteNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {
        navigationInfo.delete();
        NavigationInfoEngine.save(navigationInfo);
    }

    public INavigationInfoValue queryNavigationInfoValueById(Long navigationInfoId) throws Exception {
        return NavigationInfoEngine.getBean(navigationInfoId);
    }

    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param, int startIndex, int endIndex)
            throws Exception {
        return NavigationInfoEngine.getBeans(null, condition, param, startIndex, endIndex, false);
    }

    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param) throws Exception {
        return NavigationInfoEngine.getBeans(condition, param);
    }

    public void saveNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {
        navigationInfo.setNavId(NavigationInfoEngine.getNewId().longValue());
        NavigationInfoEngine.save(navigationInfo);
    }

    public void updateNavigationInfo(INavigationInfoValue navigationInfo) throws Exception {
       
        long navigationInfoId = 0L;
        if (navigationInfo.isNew()) {
            navigationInfoId = NavigationInfoEngine.getNewId().longValue();
            navigationInfo.setNavId(navigationInfoId);
        }
        NavigationInfoEngine.save(navigationInfo);
    }

}
