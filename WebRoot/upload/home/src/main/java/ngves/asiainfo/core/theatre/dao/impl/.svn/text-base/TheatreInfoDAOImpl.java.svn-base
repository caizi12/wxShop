package ngves.asiainfo.core.theatre.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.theatre.dao.interfaces.ITheatreInfoDAO;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.util.PropertyReader;
import ngves.asiainfo.util.StringUtil;

public class TheatreInfoDAOImpl implements ITheatreInfoDAO {
	
	private static Log logger = LogFactory.getLog(TheatreInfoDAOImpl.class);
	
	private static final String HP_Theatre_Table_Name = PropertyReader.getProperty(CoreConstant.HP_THEATRE_TABLE_NAME);
	
	private static final String Theatre_Surplus_Sql = "SELECT INVENTORY FROM "+HP_Theatre_Table_Name+" WHERE ITEMID = ?";

	public String getTheatreSurplusCount(String wareCode) throws Exception {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = ServiceManager.getSession().getConnection();

            preparedStatement = conn.prepareStatement(Theatre_Surplus_Sql);
            preparedStatement.setString(1,wareCode);

            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                // 获取查询出来的数据
               result = rs.getInt(1);
            }
            logger.info("call getTheatreSurplusCount("+wareCode+") theatreInventory = "+result);
        } catch (Exception e ) {
        	logger.error("SELECT INVENTORY FROM "+HP_Theatre_Table_Name+" WHERE ITEMID = "+wareCode+" is exception.....", e);
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

        return result+"";
	}

	public List<String> getWareCodeByWareType(String wareType) throws Exception {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = null;
        if(StringUtil.isBlank(wareType)){
        	sql = "SELECT WIP.WARE_CODE FROM WARE_INFO_PORTAL WIP WHERE WIP.WARE_TYPE is null AND WIP.WARE_STATUS="+WareConstant.SYS_CORE_WARE_STATUS_ONLINE;
        }else{
        	sql = "SELECT WIP.WARE_CODE FROM WARE_INFO_PORTAL WIP WHERE WIP.WARE_TYPE = "+wareType+" AND WIP.WARE_STATUS="+WareConstant.SYS_CORE_WARE_STATUS_ONLINE;
        }
        
        List<String> wareCodeList = new ArrayList<String>();
        
        try {
            conn = ServiceManager.getSession().getConnection();

            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                // 获取查询出来的数据添加到集合里
               wareCodeList.add(rs.getString(1));
            }
            logger.info("call getWareCodeByWareType("+wareType+") wareCodeCount = "+wareCodeList.size());
        } catch (Exception e ) {
             logger.error("SELECT WIP.WARE_CODE FROM WARE_INFO_PORTAL... is exception.....", e);
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

		
		return wareCodeList;
	}

}
