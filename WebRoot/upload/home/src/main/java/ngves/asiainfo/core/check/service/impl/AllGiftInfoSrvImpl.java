package ngves.asiainfo.core.check.service.impl;


import ngves.asiainfo.core.check.dao.impl.AllGiftInfoDAOImpl;
import ngves.asiainfo.core.check.dao.interfaces.IAllGiftInfoDAO;
import ngves.asiainfo.core.check.ivalues.IAllGiftInfoValue;
import ngves.asiainfo.core.check.service.interfaces.IAllGiftInfoSrv;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class AllGiftInfoSrvImpl implements IAllGiftInfoSrv{

    //test数据
    private IAllGiftInfoDAO allGiftInfoDAO = new AllGiftInfoDAOImpl();

    public void setAllGiftInfoDAO(IAllGiftInfoDAO allGiftInfoDAO) throws  Exception{
        this.allGiftInfoDAO = allGiftInfoDAO;
    }

    public IAllGiftInfoValue[] queryAllGiftInfo(String startTime, String endTime) throws Exception {

        StringBuffer sql = new StringBuffer("1=1");
        Map map = new HashMap();

       	if (!"".equals(startTime)) {
			sql.append(" and " + IAllGiftInfoValue.S_StartTime
					+ "=:startTime");
			map.put("startTime", startTime);
		}

        if (!"".equals(endTime)) {
             sql.append(" and " + IAllGiftInfoValue.S_EndTime
                     + "=:endTime");
             map.put("endTime", endTime);
        }

        return allGiftInfoDAO.queryAllGiftInfo(sql.toString(),map);
    }

    public IAllGiftInfoValue[] queryAllGiftInfo(String bigKindName,String startTime,String endTime) throws Exception {

         IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfo(bigKindName,startTime,endTime)  ;

         return value;
    }

    /**
     * 根据礼品名称查询大类对应记录集合，并根据总的兑换金额。
     * @param bigKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[]  queryAllGiftInfoBySortAllWaFee(String bigKindName,String startTime,String endTime) throws Exception{
    	IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoBySortAllWaFee(bigKindName,startTime,endTime)  ;

        return value;
    }
    
    /**
     * 通过小类取得对应的小类下的记录
     * @param smlKindName
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoBySMlKindName(String smlKindName,String startTime,String endTime) throws Exception{
    	
    	 IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoBySmlKindName(smlKindName,startTime,endTime)  ;
    	 
         return value;
    }


    /**
     * 通过大类获得该大类下的所有小类
     * @param bigKindName
     * @param startTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByBigKindName(String bigKindName,String startTime,String endTime) throws Exception{
    	IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoByBigKindName(bigKindName,startTime,endTime)  ;
   	 
        return value;
    }
    
    /**
     * 兑换量过低-sheet0
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByFeeDCWAMount(String feeDC,String startTime,String endTime ) throws Exception {
        IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoByFeeDCWAMount(feeDC,startTime,endTime)  ;
    	return value;
    }

    /**
     * 通过价格档次取得对应的档次下的记录
     * @param feeDC
     * @return
     * @throws Exception
     */
    public IAllGiftInfoValue[] queryAllGiftInfoByFeeDC(String feeDC,String startTime,String endTime) throws Exception{
    	IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoByFeeDC(feeDC,startTime,endTime)  ;
    	return value;
    }
    
    public IAllGiftInfoValue[] queryAllProposalOfflineGift(String startTime,String endTime) throws Exception{
    	IAllGiftInfoValue[] value = (IAllGiftInfoValue[])allGiftInfoDAO.queryAllProposalOfflineGift(startTime,endTime) ;
    	return value;
    }


    /**
     * 投诉率过高
     */
    public IAllGiftInfoValue[] queryAllProposalOfflineGiftByAllegeRate(String startTime,String endTime) throws Exception{
        return (IAllGiftInfoValue[])allGiftInfoDAO.queryAllProposalOfflineGiftByAllegeRate(startTime,endTime);
    }

    public IAllGiftInfoValue[]  queryAllGiftInfoRsRate(String bigKindName,String startTime,String endTime) throws Exception{

       return (IAllGiftInfoValue[])allGiftInfoDAO.queryAllGiftInfoRsRate(bigKindName,startTime,endTime);
    }
}
