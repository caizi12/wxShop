package ngves.asiainfo.core.tuan.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.tuan.ivalues.*;

public class TuanWareRLTBean extends DataContainer implements DataContainerInterface, ITuanWareRLTValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.tuan.bo.TuanWareRLT";

	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_TuanWareRltId = "TUAN_WARE_RLT_ID";
	public final static String S_TuanId = "TUAN_ID";
	public final static String S_BindDate = "BIND_DATE";
	public final static String S_WareId = "WARE_ID";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_Discount = "DISCOUNT";
	public final static String S_WarePayType="WARE_PAY_TYPE";
	
	public TuanWareRLTBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
	}

	public void initTuanWareRltId(long value) {
		this.initProperty(S_TuanWareRltId, new Long(value));
	}

	public void setTuanWareRltId(long value) {
		this.set(S_TuanWareRltId, new Long(value));
	}

	public void setTuanWareRltIdNull() {
		this.set(S_TuanWareRltId, null);
	}

	public long getTuanWareRltId() {
		return DataType.getAsLong(this.get(S_TuanWareRltId));

	}

	public long getTuanWareRltIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanWareRltId));
	}

	public void initTuanId(long value) {
		this.initProperty(S_TuanId, new Long(value));
	}

	public void setTuanId(long value) {
		this.set(S_TuanId, new Long(value));
	}

	public void setTuanIdNull() {
		this.set(S_TuanId, null);
	}

	public long getTuanId() {
		return DataType.getAsLong(this.get(S_TuanId));

	}

	public long getTuanIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanId));
	}

	public void initBindDate(Timestamp value) {
		this.initProperty(S_BindDate, value);
	}

	public void setBindDate(Timestamp value) {
		this.set(S_BindDate, value);
	}

	public void setBindDateNull() {
		this.set(S_BindDate, null);
	}

	public Timestamp getBindDate() {
		return DataType.getAsDateTime(this.get(S_BindDate));

	}

	public Timestamp getBindDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_BindDate));
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

	public void initBakCol(String value) {
		this.initProperty(S_BakCol, value);
	}

	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakColNull() {
		this.set(S_BakCol, null);
	}

	public String getBakCol() {
		return DataType.getAsString(this.get(S_BakCol));

	}

	public String getBakColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol));
	}

	public void initDiscount(long value) {
		this.initProperty(S_Discount, new Long(value));
	}

	public void setDiscount(long value) {
		this.set(S_Discount, new Long(value));
	}

	public void setDiscountNull() {
		this.set(S_Discount, null);
	}

	public long getDiscount() {
		return DataType.getAsLong(this.get(S_Discount));

	}

	public long getDiscountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Discount));
	}

	public void initWarePayType(String value){
	     this.initProperty(S_WarePayType,value);
	 }
	 public  void setWarePayType(String value){
	    this.set(S_WarePayType,value);
	 }
	 public  void setWarePayTypeNull(){
	    this.set(S_WarePayType,null);
	 }
	 public String getWarePayType(){
	      return DataType.getAsString(this.get(S_WarePayType));
	 }
	 public String getWarePayTypeInitialValue(){
	       return DataType.getAsString(this.getOldObj(S_WarePayType));
	     }

}
