package test;

import org.junit.Test;

public class ProdutTest {
//	   private static ApplicationContext AC = new FileSystemXmlApplicationContext(  
//       "E:/workspace/wxShop/WebRoot/WEB-INF/spring/applicationContext.xml"); 
	   
	   @Test
	   public void test(){
//		   ProductInfoSrv srv=(ProductInfoSrv)   AC.getBean("productInfoSrv");
//		   Map paraMap=new HashMap();
//			paraMap.put("productId", 100000);
//			paraMap.put("attrKind", "01");
//		List liset=   srv.queryProductAttrInfo(paraMap);
		System.out.print(String.format("%03d",10));
		
		System.out.print(new Double(-0.11) instanceof Double);
	   }
}
