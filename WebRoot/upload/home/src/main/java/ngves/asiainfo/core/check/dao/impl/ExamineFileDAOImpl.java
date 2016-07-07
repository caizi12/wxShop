package ngves.asiainfo.core.check.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import com.ai.appframe2.common.ServiceManager;
import ngves.asiainfo.core.check.bo.QBOExamineFileBean;
import ngves.asiainfo.core.check.bo.QBOExamineFileEngine;
import ngves.asiainfo.core.check.dao.interfaces.IExamineFileDAO;
import ngves.asiainfo.core.check.ivalues.IQBOExamineFileValue;


public class ExamineFileDAOImpl implements IExamineFileDAO {

    /**
     * 保存examineFile的信息
     * @param value
     * @throws Exception
     */
    public void saveExamineFileInfo(IQBOExamineFileValue value) throws Exception {
        value.setExamineFileId(QBOExamineFileEngine.getNewId().longValue());
        QBOExamineFileEngine.save(value);
    }

    /**
     * 更新examineFile的信息
     *          具有更新和保存操作功能
     * @param value
     * @throws Exception
     */
    public void updateExamineFileInfo(IQBOExamineFileValue value) throws Exception {

        long valueId = 0L;
        if (value.isNew()) {
            valueId = QBOExamineFileEngine.getNewId().longValue();
            value.setExamineFileId(valueId);
        }
        QBOExamineFileEngine.save(value);
    }

    public void delExamineFileInfo(IQBOExamineFileValue value) throws Exception {
        QBOExamineFileBean bean = (QBOExamineFileBean)value;
        del(bean.getExamineMonth());
    }

    /**
     * sql语句执行删除操作
     * @param month
     * @throws Exception
     */
    public void del(String month ) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ServiceManager.getSession().getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("delete from EXAMINE_FILE where EXAMINE_MONTH = ? ");
            preparedStatement.setString(1,month+"");
            preparedStatement.executeUpdate();
            conn.commit();

        } catch (Exception e ) {
            e.printStackTrace();
        }  finally {
            if(preparedStatement!=null) {
                preparedStatement.close();
            }
            if(conn!=null) {
                conn.close();
            }
        }


    }
    @SuppressWarnings("unchecked")
	public IQBOExamineFileValue[] getExamineFile(String queryTime, int startNum, int endNum)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");

		HashMap parameter = new HashMap();

		if (!"".equals(queryTime)) {
			condition.append(" and " + IQBOExamineFileValue.S_ExamineMonth
					+ "=:queryTime");
			parameter.put("queryTime", queryTime);
		}

		IQBOExamineFileValue[] value = QBOExamineFileEngine
				.getBeans(null, condition.toString(), parameter, startNum,
						endNum, false);
		return value;
	}

	@SuppressWarnings("unchecked")
	public int getExamineFileInfoCount(String queryTime)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap parameter = new HashMap();

		if (!"".equals(queryTime)) {
			condition.append(" and " + IQBOExamineFileValue.S_ExamineMonth
					+ "=:queryTime");
			parameter.put("queryTime", queryTime);
		}

		return QBOExamineFileEngine.getBeansCount(condition.toString(), parameter);
	}

}
