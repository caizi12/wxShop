package cn.myshop.app.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.myshop.app.service.TestService;
import cn.myshop.platform.common.base.BaseDaoTemplate;

@Service("testService")
public class TestServiceImpl extends BaseDaoTemplate implements TestService {

	public String getOrderId() { 

		List listOrder = getIbatisTemplate().queryForList("queryOrder");
		System.out.println("条数:" + listOrder.size());

		List<Map> list = (List) getJdbcTemplate().queryForList(" select * from order_t ");
		Map<String, String> map = (Map<String, String>) list.get(0);
		System.out.println("编号" + map.get("orderid"));
		return map.get("orderid");
	}
	
	public int updateCart(){
		String sql="update goods_old_ta set userid='2012' where cartid='201105180037'";
		return getJdbcTemplate().update(sql);
		//return ibatisTemplate.update("updateGood");
	}
	
	public int delCart(){
		String sql="delete from goods_old_t where goodsid='2012041800894'";
		return getJdbcTemplate().update(sql);
		//return ibatisTemplate.delete("delGood");
	}
	
	public int insertCart(){
		String sql="insert goods_old_t(goodsid,goodsname) value('2012041800896','测试1081')";
 	 return getJdbcTemplate().update(sql); 
//		ibatisTemplate.insert("insertGood");
	//	return 1;
	}

	public int[] delAndUpdate()  {
		int a = delCart();
		int c = 0;//insertCart();
		int b = 0;//testDao.updateCart();
		int[] count = new int[] { a, c, b };
		return count;
	}

	 

}
