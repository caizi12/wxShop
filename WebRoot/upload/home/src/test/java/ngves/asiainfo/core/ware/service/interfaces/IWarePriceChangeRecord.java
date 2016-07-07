package ngves.asiainfo.core.ware.service.interfaces;

import static org.junit.Assert.fail;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareInfoChildValue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.test.AppFrameJUnit4ClassRunner;

@RunWith(AppFrameJUnit4ClassRunner.class)
public class IWarePriceChangeRecord {
	
	private IWarePCInfoSrv service = (IWarePCInfoSrv)ServiceFactory.getService("ngves.asiainfo.core.WarePCInfoService");

	@Test
	public void testQueryAllWareInfoChild() {
		try {
			IQBOAllWareInfoChildValue[] values = service.queryAllWareInfoChild(null,null, null, null, null, null, null, null, null, null, null, 0, 99);
			System.out.println("----------"+values.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryAllWareInfoChildCount() {
		fail("Not yet implemented");
	}

}
