package ngves.asiainfo.core.theatre.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.theatre.dao.interfaces.ITheatreInfoDAO;

public interface ITheatreInfoSrv {
	public void setTheatreInfoDAO(ITheatreInfoDAO theatreInfoDAO);
	public String getTheatreSurplusCount(String wareCode) throws Exception;
	public List<String> getWareCodeByWareType(String wareType) throws Exception;
    public  int checkTheatreInvetory(String wareCode) throws Exception;
}
