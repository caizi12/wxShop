package ngves.asiainfo.core.ware.dao.interfaces;

import static org.junit.Assert.fail;

import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;

import org.junit.Test;

import com.ai.appframe2.service.ServiceFactory;

public class IWareInfoDAOTest {
	
	IWareInfoDAO dao = (IWareInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.wareInfoDAO");

	@Test
	public void testGetWareProvDeliverFee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllWareInfoPortal() {
		try {
			IWareInfoPortalValue[] values = dao.getAllWareInfoPortal();
			for (IWareInfoPortalValue value : values) {
				System.out.println(value.getBakCol3());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
