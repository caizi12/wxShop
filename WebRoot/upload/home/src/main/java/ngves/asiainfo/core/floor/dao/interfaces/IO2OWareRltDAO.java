package ngves.asiainfo.core.floor.dao.interfaces;

import ngves.asiainfo.core.floor.ivalues.IO2OWareRltValue;

public interface IO2OWareRltDAO {
   public IO2OWareRltValue[] queryO2OWareRltById(String o2oId) throws Exception;
   public void saveO2OWareRlt(IO2OWareRltValue o2oWareRltValue) throws Exception;
   public void deleteO2OWareRlt(IO2OWareRltValue o2oWareRltValue) throws Exception;
   public void deleteO2OWareRlt(Long o2owareRltId) throws Exception;
}
