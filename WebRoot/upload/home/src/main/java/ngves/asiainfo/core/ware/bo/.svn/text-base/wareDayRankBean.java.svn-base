package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.IwareDayRankValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class wareDayRankBean extends DataContainer implements DataContainerInterface, IwareDayRankValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.wareDayRank";

	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_ExchangeDay = "EXCHANGE_DAY";
	public final static String S_ExchangeCount = "EXCHANGE_COUNT";
	public final static String S_WareId = "WARE_ID";
	public final static String S_WareDayRankId = "WARE_DAY_RANK_ID";
	public final static String S_ExchangeChannel = "EXCHANGE_CHANNEL";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public wareDayRankBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWareBrandId(long value) {
		this.initProperty(S_WareBrandId, new Long(value));
	}

	public void setWareBrandId(long value) {
		this.set(S_WareBrandId, new Long(value));
	}

	public void setWareBrandIdNull() {
		this.set(S_WareBrandId, null);
	}

	public long getWareBrandId() {
		return DataType.getAsLong(this.get(S_WareBrandId));

	}

	public long getWareBrandIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareBrandId));
	}

	public void initExchangeDay(Timestamp value) {
		this.initProperty(S_ExchangeDay, value);
	}

	public void setExchangeDay(Timestamp value) {
		this.set(S_ExchangeDay, value);
	}

	public void setExchangeDayNull() {
		this.set(S_ExchangeDay, null);
	}

	public Timestamp getExchangeDay() {
		return DataType.getAsDateTime(this.get(S_ExchangeDay));

	}

	public Timestamp getExchangeDayInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_ExchangeDay));
	}

	public void initExchangeCount(long value) {
		this.initProperty(S_ExchangeCount, new Long(value));
	}

	public void setExchangeCount(long value) {
		this.set(S_ExchangeCount, new Long(value));
	}

	public void setExchangeCountNull() {
		this.set(S_ExchangeCount, null);
	}

	public long getExchangeCount() {
		return DataType.getAsLong(this.get(S_ExchangeCount));

	}

	public long getExchangeCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ExchangeCount));
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

	public void initWareDayRankId(long value) {
		this.initProperty(S_WareDayRankId, new Long(value));
	}

	public void setWareDayRankId(long value) {
		this.set(S_WareDayRankId, new Long(value));
	}

	public void setWareDayRankIdNull() {
		this.set(S_WareDayRankId, null);
	}

	public long getWareDayRankId() {
		return DataType.getAsLong(this.get(S_WareDayRankId));

	}

	public long getWareDayRankIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareDayRankId));
	}

	public void initExchangeChannel(String value) {
		this.initProperty(S_ExchangeChannel, value);
	}

	public void setExchangeChannel(String value) {
		this.set(S_ExchangeChannel, value);
	}

	public void setExchangeChannelNull() {
		this.set(S_ExchangeChannel, null);
	}

	public String getExchangeChannel() {
		return DataType.getAsString(this.get(S_ExchangeChannel));

	}

	public String getExchangeChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExchangeChannel));
	}

}
