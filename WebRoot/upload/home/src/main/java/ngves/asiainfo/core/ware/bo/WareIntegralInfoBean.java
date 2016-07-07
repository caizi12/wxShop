package ngves.asiainfo.core.ware.bo;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class WareIntegralInfoBean extends DataContainer implements
DataContainerInterface, IWareIntegralInfoValue {

/**
* 
*/
private static final long serialVersionUID = 1L;

private static String m_boName = "ngves.asiainfo.core.ware.bo.WareIntegralInfo";

public final static String S_Channel = "CHANNEL";
public final static String S_IntegralValue = "INTEGRAL_VALUE";
public final static String S_Convert = "CONVERT";
public final static String S_IntegralId = "INTEGRAL_ID";
public final static String S_CurPayCash = "CUR_PAY_CASH";
public final static String S_OriPayCash = "ORI_PAY_CASH";
public final static String S_MobileBrandCode = "MOBILE_BRAND_CODE";
public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
public final static String S_OriginalValue = "ORIGINAL_VALUE";
public final static String S_WareId = "WARE_ID";

public WareIntegralInfoBean() throws AIException {
super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
}

public static ObjectType getObjectTypeStatic() throws AIException {
return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
}

public void setObjectType(ObjectType value) throws AIException {
throw new AIException("");
}

public void initChannel(String value) {
this.initProperty(S_Channel, value);
}

public void setChannel(String value) {
this.set(S_Channel, value);
}

public void setChannelNull() {
this.set(S_Channel, null);
}

public String getChannel() {
return DataType.getAsString(this.get(S_Channel));

}

public String getChannelInitialValue() {
return DataType.getAsString(this.getOldObj(S_Channel));
}

public void initIntegralValue(long value) {
this.initProperty(S_IntegralValue, new Long(value));
}

public void setIntegralValue(long value) {
this.set(S_IntegralValue, new Long(value));
}

public void setIntegralValueNull() {
this.set(S_IntegralValue, null);
}

public long getIntegralValue() {
return DataType.getAsLong(this.get(S_IntegralValue));

}

public long getIntegralValueInitialValue() {
return DataType.getAsLong(this.getOldObj(S_IntegralValue));
}

public void initConvert(float value) {
this.initProperty(S_Convert, new Float(value));
}

public void setConvert(float value) {
this.set(S_Convert, new Float(value));
}

public void setConvertNull() {
this.set(S_Convert, null);
}

public float getConvert() {
return DataType.getAsFloat(this.get(S_Convert));

}

public float getConvertInitialValue() {
return DataType.getAsFloat(this.getOldObj(S_Convert));
}

public void initIntegralId(long value) {
this.initProperty(S_IntegralId, new Long(value));
}

public void setIntegralId(long value) {
this.set(S_IntegralId, new Long(value));
}

public void setIntegralIdNull() {
this.set(S_IntegralId, null);
}

public long getIntegralId() {
return DataType.getAsLong(this.get(S_IntegralId));

}

public long getIntegralIdInitialValue() {
return DataType.getAsLong(this.getOldObj(S_IntegralId));
}

public void initCurPayCash(long value) {
this.initProperty(S_CurPayCash, new Long(value));
}

public void setCurPayCash(long value) {
this.set(S_CurPayCash, new Long(value));
}

public void setCurPayCashNull() {
this.set(S_CurPayCash, null);
}

public long getCurPayCash() {
return DataType.getAsLong(this.get(S_CurPayCash));

}

public long getCurPayCashInitialValue() {
return DataType.getAsLong(this.getOldObj(S_CurPayCash));
}

public void initOriPayCash(long value) {
this.initProperty(S_OriPayCash, new Long(value));
}

public void setOriPayCash(long value) {
this.set(S_OriPayCash, new Long(value));
}

public void setOriPayCashNull() {
this.set(S_OriPayCash, null);
}

public long getOriPayCash() {
return DataType.getAsLong(this.get(S_OriPayCash));

}

public long getOriPayCashInitialValue() {
return DataType.getAsLong(this.getOldObj(S_OriPayCash));
}

public void initMobileBrandCode(String value) {
this.initProperty(S_MobileBrandCode, value);
}

public void setMobileBrandCode(String value) {
this.set(S_MobileBrandCode, value);
}

public void setMobileBrandCodeNull() {
this.set(S_MobileBrandCode, null);
}

public String getMobileBrandCode() {
return DataType.getAsString(this.get(S_MobileBrandCode));

}

public String getMobileBrandCodeInitialValue() {
return DataType.getAsString(this.getOldObj(S_MobileBrandCode));
}

public void initOriPayIntegral(long value) {
this.initProperty(S_OriPayIntegral, new Long(value));
}

public void setOriPayIntegral(long value) {
this.set(S_OriPayIntegral, new Long(value));
}

public void setOriPayIntegralNull() {
this.set(S_OriPayIntegral, null);
}

public long getOriPayIntegral() {
return DataType.getAsLong(this.get(S_OriPayIntegral));

}

public long getOriPayIntegralInitialValue() {
return DataType.getAsLong(this.getOldObj(S_OriPayIntegral));
}

public void initCurPayIntegral(long value) {
this.initProperty(S_CurPayIntegral, new Long(value));
}

public void setCurPayIntegral(long value) {
this.set(S_CurPayIntegral, new Long(value));
}

public void setCurPayIntegralNull() {
this.set(S_CurPayIntegral, null);
}

public long getCurPayIntegral() {
return DataType.getAsLong(this.get(S_CurPayIntegral));

}

public long getCurPayIntegralInitialValue() {
return DataType.getAsLong(this.getOldObj(S_CurPayIntegral));
}

public void initOriginalValue(long value) {
this.initProperty(S_OriginalValue, new Long(value));
}

public void setOriginalValue(long value) {
this.set(S_OriginalValue, new Long(value));
}

public void setOriginalValueNull() {
this.set(S_OriginalValue, null);
}

public long getOriginalValue() {
return DataType.getAsLong(this.get(S_OriginalValue));

}

public long getOriginalValueInitialValue() {
return DataType.getAsLong(this.getOldObj(S_OriginalValue));
}

public void initWareId(long value) {
this.initProperty(S_WareId, new Long(value));
}

public void setWareId(long value) {
this.set(S_WareId, new Long(value));
}

public void setWareIdNull() {
this.set(S_WareId, null);
}

public long getWareId() {
return DataType.getAsLong(this.get(S_WareId));

}

public long getWareIdInitialValue() {
return DataType.getAsLong(this.getOldObj(S_WareId));
}

public boolean isCurPayCashNull() {
if (StringUtils.isBlank(DataType.getAsString(this.get(S_CurPayCash))))
	return true;
return false;
}

public boolean isIntegralValueNull() {
if (StringUtils
		.isBlank(DataType.getAsString(this.get(S_IntegralValue))))
	return true;
return false;
}

public boolean isOriPayIntegralNull() {
if (StringUtils.isBlank(DataType
		.getAsString(this.get(S_OriPayIntegral))))
	return true;
return false;
}

public boolean isOriPayCashNull() {
if (StringUtils.isBlank(DataType.getAsString(this.get(S_OriPayCash))))
	return true;
return false;
}

public boolean isCurPayIntegralNull() {
if (StringUtils.isBlank(DataType
		.getAsString(this.get(S_CurPayIntegral))))
	return true;
return false;
}

public long getId() {
return getIntegralId();
}

public void setId(long id) {
setIntegralId(id);
}
}

