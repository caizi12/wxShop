package ngves.asiainfo.core.pricechange.util;

public class WarePriceChangeConstant {
	public static final String SQL_findBuisId ="select SQE_BUSI_TYPE_ID.Nextval busi_id from dual"; 
	
	/**
	 * =====================
	 * 礼品审核相关SQL
	 * =====================
	 */
	public static final String SQL_findWarePriceRecordObjectByBuisId = 
		"select bwi.ware_id,\n" +
		"       bwi.market_price,\n" + 
		"       bwi.count_value,\n" + 
		"       decode(wi.ware_integral_value, null, -1, wi.ware_integral_value) ware_integral_value,\n" + 
		"       bwi.last_update_staff_id,\n" + 
		"       to_char(bwi.last_update_date, 'YYYY-MM-DD HH24:MI:SS') last_update_date,\n" + 
		"       bci.check_staff_id,\n" + 
		"       to_char(bci.check_time, 'YYYY-MM-DD HH24:MI:SS') check_time,\n" +
		"       decode(wi.pay_integral, null, -1, wi.pay_integral) pay_integral,\n" +
		"       decode(wi.pay_cash, null, -1, wi.pay_cash) pay_cash \n" +
		"  from busi_ware_info bwi, ware_info wi, (select bci.busi_id, bci.check_staff_id,bci.check_time from busi_check_info bci\n" + 
		"                                         where  bci.check_id = (select max(check_id)\n" + 
		"                                         from busi_check_info where busi_id=?)\n" + 
		"                                         ) bci\n" + 
		" where bwi.ware_id = wi.ware_id(+)\n" + 
		"   and bwi.busi_id = bci.busi_id(+)\n" + 
		"   and bwi.busi_id = ? ";
	public static final String SQL_isAdd = "select count(*) isAdd from busi_ware_info bwi where bwi.ware_id = (select ware_id from busi_ware_info where busi_id =? )";
	public static final String SQL_findLastBusiId = "select bwi.busi_id\n" + "  from busi_ware_info bwi\n"
			+ " where ware_id = (select ware_id from busi_ware_info where busi_id=?)\n" + "   and busi_id <> ?\n"
			+ "   and busi_id = (select max(busi_id)\n" + "                    from (select bwi.busi_id\n"
			+ "                            from busi_ware_info bwi\n"
			+ "                           where ware_id = (select ware_id from busi_ware_info where busi_id=?)\n"
			+ "                             and busi_id <> ?))";
	public static final String  SQL_findCBusiIdIdByPBusiId = "select busi_id from busi_ware_info  where busi_id_parent=?";
	
	/**
	 * =====================
	 * 礼品业务属性配置相关SQL
	 * =====================
	 */
	
	public static final String SQL_findWarePriceRecordObjectByWareId=
		"select wi.ware_id,\n" +
		"       wi.market_price,\n" + 
		"       wi.count_value,\n" + 
		"       decode(wi.ware_integral_value, null, -1, wi.ware_integral_value) ware_integral_value,\n" + 
		"       wi.last_update_staff_id,\n" + 
		"       to_char(wi.last_update_date, 'YYYY-MM-DD HH24:MI:SS') last_update_date,\n" + 
		"       '-1'as check_staff_id,\n"+
		"       ''  as check_time,\n" +
		"       decode(wi.pay_integral, null, -1, wi.pay_integral) pay_integral,\n" +
		"       decode(wi.pay_cash, null, -1, wi.pay_cash) pay_cash \n" +
		"  from ware_info wi\n" + 
		"  where wi.ware_id=? ";
	public static final String SQL_findWareIdByWareCode="select ware_id from ware_info where ware_code = ?";
	
	public static final String SQL_getWarePriceChangeId="SELECT   SEQ_WARE_PRICECHANGE.NEXTVAL AS SEQ_ID FROM DUAL";
	
	/**
	 * =====================
	 * 文件数据批量入库
	 * =====================
	 */
	public static final String SQL_ADD_DATAFROMFILE=
		"insert into ware_price_change_record(busi_id,BUSI_TYPE_ID,ware_id,BEGIN_VALUE,end_Value,OPERATE_ID,OPERATE_DATE,check_id,check_date,OPERATE_CAUSE,BUSI_DATE,busi_info_id) " +
		"values(?,?,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,sysdate,?)";
	/**
	 * 待审核标识
	 */
	public static final String WARE_CHECK_FLAG_10 = "10";
	/**
	 * 审核通过标识
	 */
	public static final String WARE_CHECK_FLAG_21 = "21";

	/**
	 * 方法执行前标识
	 */
	public static final String METHOD_BEGIN_FLAG = "0";
	/**
	 * 方法执行后标识
	 */
	public static final String METHOD_AFTER_FLAG = "1";

	/**
	 * 礼品新增标识
	 */
	public static final String WARE_ADD 	= "00";

	/**
	 * 礼品修改标识
	 */
	public static final String WARE_UPDATE  = "01";
	
	
	/**
	 * 礼品业务属性配置标识
	 */
	public static final String WARE_DESC  = "02";
	

	/**
	 * 业务标识:市场价
	 */
	public static final String BUSI_TYPE_ID_0 = "0";
	/**
	 * 业务标识:结算价
	 */
	public static final String BUSI_TYPE_ID_1 = "1";
	/**
	 * 业务标识:统一积分值
	 */
	public static final String BUSI_TYPE_ID_2 = "2";
	/**
	 * 业务标识:混合支付积分值
	 */
	public static final String BUSI_TYPE_ID_3 = "3";
	/**
	 * 业务标识:混合支付现金值
	 */
	public static final String BUSI_TYPE_ID_4 = "4";
	
	
	
	/**
	 * 礼品审核类型0:普通礼品
	 */
	public static final String WARE_CHECK_TYPE_0="0";
	
	/**
	 * 礼品审核类型1:父子礼品
	 */
	public static final String WARE_CHECK_TYPE_1="1";
	
	/**
	 * 礼品审核模块
	 */
	public static final String WARE_CHECK_MODULE = "00";
	
	/**
	 * 礼品业务属性模块
	 */
	public static final String WARE_DESC_MODULE = "02";
	
	/**
	 * 礼品积分换算规则
	 */
	public static final String WARE_BINDRULE_MODULE = "03";
	
	/**
	 * 礼品价格批量更新
	 */
	public static final String WARE_PRICE_BATCH_UPDATE_MODULE = "04";

	/**
	 * 文件存放路径
	 */
	public static final String WARE_PRICE_REOCRD_PATH = "price.change.record.path";
	/**
	 * 文件前缀
	 */
	public static final String FILE_NAME="price_change_";
	
	/**
	 * 文件后缀
	 */
	public static final String FILE_TYPE=".log";
	
	/**
	 * 生成数据文件数据拼接符号
	 */
	public static final String JOIN_TYPE=","; //  "|"拼接解析需要正则表达式

}
