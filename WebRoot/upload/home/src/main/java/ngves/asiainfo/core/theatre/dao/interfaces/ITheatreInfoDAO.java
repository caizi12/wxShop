package ngves.asiainfo.core.theatre.dao.interfaces;

import java.util.List;

public interface ITheatreInfoDAO {
	public String getTheatreSurplusCount(String wareCode) throws Exception;
	public List<String> getWareCodeByWareType(String wareType) throws Exception;
}
