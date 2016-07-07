package ngves.asiainfo.core.tuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.tuan.bo.JfinterOrdersInfoBean;
import ngves.asiainfo.core.tuan.bo.JfinterOrdersInfoEngine;
import ngves.asiainfo.core.tuan.bo.QBOPreOrdersInfoEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.IPreOrderInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.IJfinterOrdersInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOPreOrdersInfoValue;
import ngves.asiainfo.util.PropertyReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

/**
 *  用于展现团兑活动订单信息和做团兑订单统计实现
 *  需要修改PRE_ORDER_INFO为HP的数据库表方可进行操作
 */
public class PreOrderInfoDAOImpl implements IPreOrderInfoDAO{

    private static Log logger = LogFactory.getLog(PreOrderInfoDAOImpl.class);


    private static  final String  SUM_ITEM_COUNTS_SQL = "SELECT SUM(ITEMCOUNT)  FROM  " +
            PropertyReader.getProperty(CoreConstant.PRE_ORDER_INFO_FROM_HP) +
            "  WHERE  ACTIONID=?  AND ORDTYPE = ?  AND  ORDSTATUS in('P00','P01','P03')  ";

    private static  final String  SUM_ITEM_COUNTS_BY_MOBILE_SQL = "SELECT SUM(ITEMCOUNT) FROM " +
             PropertyReader.getProperty(CoreConstant.PRE_ORDER_INFO_FROM_HP) +
            " WHERE ACTIONID=? AND ORDTYPE = ?  AND MOBILE = ? AND  ORDSTATUS in('P00','P01','P03') " ;

    private static final String PRE_ORDERS_INFO_SQL = " select substr(t.actionid, 3, 15) actionid, sum(itemcount) itemcount "
													  +" from  "+PropertyReader.getProperty(CoreConstant.PRE_ORDER_INFO_FROM_HP)+" t "
													  +" where t.ordstatus in ('P00', 'P01', 'P03') "
													  +"  and t.ordtype = '02' "
													  +" group by t.actionid ";
    /**
     *
     * @param tuanId
     * @param ordType
     * @return
     * @throws Exception
     */
    public int getSumItemCounts(Long tuanId, String ordType) throws Exception {

        if(tuanId==0){
            logger.error("select HP TABLE Pre_Orders_Info Illegal arguments when call getSumItemCounts! tuanId=" + tuanId);
        }

        logger.info("PropertyReader.getProperty(CoreConstant.PRE_ORDERS_INFO_FROM_HP) = " + PropertyReader.getProperty(CoreConstant.PRE_ORDER_INFO_FROM_HP));
        // 获取数据库连接
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = ServiceManager.getSession().getConnection();

            preparedStatement = conn.prepareStatement(SUM_ITEM_COUNTS_SQL);
            preparedStatement.setString(1,ordType+tuanId+"");
            preparedStatement.setString(2, ordType);

            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                // 获取查询出来的数据
               result = rs.getInt(1);
            }

            logger.info("call getSumItemCounts result = "+result);
        } catch (Exception e ) {
             logger.error("SELECT SUM(ITEMCOUNT) FROM PRE_ORDERS_INFO WHERE ACTIONID=?  AND ORDTYPE = ? ordStatus in('P01','P00','P03') is exception.....", e);
        } finally {

            if(rs!=null){
                rs.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(conn!=null) {
                conn.close();
            }
        }

        return result;
    }

    public int getSumItemCountsByMobile(Long tuanId, String ordtype, String mobile) throws Exception {
        if(tuanId==0){
            logger.error("select HP TABLE Pre_Order_Info Illegal arguments when call getSumItemCountsByMobile! tuanId=" + tuanId);
        }
        logger.info("PropertyReader.getProperty(CoreConstant.PRE_ORDERS_INFO_FROM_HP) = " + PropertyReader.getProperty(CoreConstant.PRE_ORDER_INFO_FROM_HP));
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int result = 0;
        try {
             conn = ServiceManager.getSession().getConnection();
             preparedStatement = conn.prepareStatement(SUM_ITEM_COUNTS_BY_MOBILE_SQL) ;

             preparedStatement.setString(1, ordtype + tuanId);
             preparedStatement.setString(2, ordtype);
             preparedStatement.setString(3,mobile);
             rs = preparedStatement.executeQuery();

             if(rs.next()) {
                result = rs.getInt(1);
             }
             logger.info("call getSumItemCountsByMobile result = "+result);
        } catch ( Exception e ) {
           logger.error("SELECT SUM(ITEMCOUNT) FROM PRE_ORDERS_INFO WHERE ACTIONID=? AND ORDTYPE = ?  AND MOBILE = ? and ordStatus in('P01','P00','P03') is exception.....", e);
        } finally {

            if(rs!=null){
                rs.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(conn!=null) {
                conn.close();
            }
        }

        return result;
    }
    
    public IQBOPreOrdersInfoValue[] getPreOrdersInfos() throws Exception {
		return QBOPreOrdersInfoEngine.getBeansFromSql(PRE_ORDERS_INFO_SQL, null);
	}

	public IJfinterOrdersInfoValue[] getJfinterOrdersInfos() throws Exception {
		return JfinterOrdersInfoEngine.getBeans(null, null);
	}

	public void saveJfinterOrdersInfo(IJfinterOrdersInfoValue[] jfValue) throws Exception {
		JfinterOrdersInfoEngine.save(jfValue);
	}

	public void saveToJfinterOrdersInfo(IQBOPreOrdersInfoValue[] preValue) throws Exception {

		if (preValue != null && preValue.length > 0) {
			IJfinterOrdersInfoValue[] jfValues = new JfinterOrdersInfoBean[preValue.length];
			for (int i = 0; i < preValue.length; i++) {
				jfValues[i] = new JfinterOrdersInfoBean();
				jfValues[i].setJfinterOrdersInfoId(JfinterOrdersInfoEngine.getNewId().longValue());
				jfValues[i].setTuanId(Long.valueOf(preValue[i].getActionid()));
				jfValues[i].setItemCount(preValue[i].getItemcount());
			}
			//批量保存
			JfinterOrdersInfoEngine.save(jfValues);
		}
	}
}
