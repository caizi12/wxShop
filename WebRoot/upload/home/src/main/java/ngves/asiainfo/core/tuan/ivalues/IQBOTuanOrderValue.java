package ngves.asiainfo.core.tuan.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IQBOTuanOrderValue extends DataStructInterface {

	public final static String S_Name = "NAME";
	public final static String S_TuanId = "TUAN_ID";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_Bmobile = "BMOBILE";
	public final static String S_MzoneValue = "MZONE_VALUE";
	public final static String S_MobileNumber = "MOBILE_NUMBER";
	public final static String S_WareId = "WARE_ID";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_GotoneValue = "GOTONE_VALUE";
	public final static String S_OrderId = "ORDER_ID";
	public final static String S_IntegralValue = "INTEGRAL_VALUE";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_EasyownValue = "EASYOWN_VALUE";
	public final static String S_CustomerBrand = "CUSTOMER_BRAND";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_PartnerName = "PARTNER_NAME";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_OrderSumcash = "ORDERSUMCASH";
	

	public String getName();

	public long getTuanId();

	public String getWareName();

	public String getBmobile();

	public long getMzoneValue();

	public String getMobileNumber();

	public long getWareId();

	public String getBakCol();

	public long getGotoneValue();

	public String getOrderId();

	public String getIntegralValue();

	public Timestamp getCreateDate();

	public long getEasyownValue();

	public String getCustomerBrand();

	public String getProvinceCode();

	public String getPartnerName();

	public String getWareCode();

	public String getOrderSumcash();
	

	public void setName(String value);

	public void setTuanId(long value);

	public void setWareName(String value);

	public void setBmobile(String value);

	public void setMzoneValue(long value);

	public void setMobileNumber(String value);

	public void setWareId(long value);

	public void setBakCol(String value);

	public void setGotoneValue(long value);

	public void setOrderId(String value);

	public void setIntegralValue(String value);

	public void setCreateDate(Timestamp value);

	public void setEasyownValue(long value);

	public void setCustomerBrand(String value);

	public void setProvinceCode(String value);

	public void setPartnerName(String value);

	public void setWareCode(String value);

	public void setOrderSumcash(String value);

}
