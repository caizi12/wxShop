/**
 * Copyright (c) 2012 asiainfo-linkage.com
 */
package ngves.asiainfo.core.common.util;


/**
 * Asiainfo的配送方式枚举类
 * 
 * Asiainfo的配送方式编码必须初始化，如果添加配送方式，需要进行以下两部分内容
 * 例如：新增加的配送方式为XXX_DELIVER_TYPE，AI的编码为AICODE ，HP的编码为HPCODE
 * <p>1、需要手动修改代码(DeliverTypeEnum)</p>
 * 		在该枚举类中添加XXX_DELIVER_TYPE(AICODE)
 * <p>2、需要在sys_para_data 表的 para_type_id=51 插入新的配送方式信息</p>
 * 		insert into sys_para_data values('PARA_ID','51','PARA_CODE','XXX_DELIVER_TYPE','SORT_ID','HPCODE','PARA_ATTR_2','PARA_ATTR_3','NOTE','IS_META');
 * 
 * 
 * 
 * @author liuyq7@asiainfo-linkage.com
 * @date 2012/04/01 创建该枚举类
 *
 */
public enum DeliverTypeEnum {
	
	/*
	 * 为了查看方便，这些变量名与portal中的OrderConstant编码名称保持一致
	 */

	/**
	 * 全网实物类礼品 [全网礼品，全网配送，同步方式：同步给仓储商、配送商] 积分平台编码：11
	 */
	GLO_LOGIC_WARE("11"),
	
	/**
	 * 电子密码类礼品（包含虚拟电子密码类、IKang健康服务） [全网礼品，不需要配送，同步方式：同步给礼品商] 积分平台编码：12;
	 */
	ELE_PASSWD_WARE("12"),
	
	/**
	 * 合作杂志类礼品 [全网礼品,礼品商配送，同步方式：同步给礼品商] 积分平台编码：13;
	 */
	UNI_MAG_WARE("13"),
	
	/**
	 * 合作DIY类礼品[全网礼品，礼品商配送，同步方式：同步给礼品商] 积分平台编码：14;
	 */
	UNI_DIY_WARE("14"),
	
	/**
	 * 二维码类礼品（包含卖当劳、慈铭健康服务）[全网礼品，不需要配送，同步方式：同步给礼品商或二维码] 积分平台编码：15;
	 */
	DIM_CODE_WARE("15"),
	
	/**
	 * 航空里程礼品）[全网礼品，不需要配送，同步方式：同步给礼品商] 积分平台编码：16;
	 */
	AIR_MILES_WARE("16"),
	
	/**
	 * 省自有业务类礼品[全网礼品，不需要配送，同步方式：同步给省公司] 积分平台编码：17;
	 */
	PROV_BUSINESS_WARE("17"),
	
	/**
	 * 捐赠积分[全网礼品，不需要配送，同步方式：均不同步] 积分平台编码：18;
	 */
	POINT_DONATE_WARE("18"),
	
	/**
	 * 礼品商配送（合作）类礼品[全网礼品,礼品商配送，同步方式：同步给礼品商] 积分平台编码：19;
	 */
	UNI_BEVERAGES_WARE("19"),
	
	/**
	 *  加油卡类礼品 [全网礼品，不需要配送，同步方式：同步给礼品商] 积分平台编码：20;
	 */
	GAS_CARD_WARE("20"),
	
	/**
	 * 本省物流配送[省网礼品 由省物流配送] 积分平台编码：01;
	 */
	PROV_LOGIC_WARE("01"),
	
	/**
	 * 本省营业厅取货[省网礼品] 积分平台编码：02
	 */
	PROV_BUSI_OFFICE_WARE("02"),
	
	/**
	 *  不需要配送（移动积分礼品） [该类礼品不同步到前台] 积分平台编码：98
	 */
	CHINAMOBILE_JF_WARE("98"),
	
	/**
	 * 不需要配送（浦发合作礼品）积分平台编码：99
	 */
	SPD_BANK_WARE("99")
	;
	
	//配送方式的Asiainfo编码
	private final String deliverTypeAIValue;

	//配送方式的HP编码
	private final String deliverTypeHPValue;
	
	//暂不支持显示名称
	private final String deliverTypeName;
	
	DeliverTypeEnum(String paramStr){
		this.deliverTypeAIValue = paramStr;
		//HP编码从数据库获得
		this.deliverTypeHPValue = DeliverTypeUtil.getDeliverTypeFromAiToHp(paramStr);
		//配送方式名称从数据库获得
		this.deliverTypeName = DeliverTypeUtil.getDeliverTypeNameByAiCode(paramStr);
	}
	DeliverTypeEnum(){
		this.deliverTypeAIValue = null;
		this.deliverTypeHPValue = null;
		this.deliverTypeName = null;
	}

	/**
	 * 获得该配送方式的积分平台编码
	 * @return
	 */
	public String getAIValue(){
		return this.deliverTypeAIValue;
	}
	
	/**
	 * 获得该配送方式的Hp编码
	 * @return
	 */
	public String getHPValue(){
		return this.deliverTypeHPValue;
	}
	
	/**
	 * 通过积分平台的编码，获得该配送方式的名称
	 * @return
	 */
	public String getDeliverTypeName(){
		return this.deliverTypeName;
	}
}
