package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class BusiSettlePublishInfoBean extends DataContainer implements DataContainerInterface,
        IBusiSettlePublishInfoValue {

    /**
       * 
       */
    private static final long serialVersionUID = 1L;

    private static String m_boName = "ngves.asiainfo.core.common.bo.BusiSettlePublishInfo";

    public final static String S_Settleid = "SETTLEID";
    public final static String S_Rflag = "RFLAG";
    public final static String S_Note = "NOTE";
    public final static String S_Hpoprtime = "HPOPRTIME";
    public final static String S_BakCol2 = "BAK_COL2";
    public final static String S_Rmsg = "RMSG";
    public final static String S_Hpoprid = "HPOPRID";
    public final static String S_BakCol1 = "BAK_COL1";
    public final static String S_Aioprid = "AIOPRID";
    public final static String S_Settlemonth = "SETTLEMONTH";
    public final static String S_SeqId = "SEQ_ID";
    public final static String S_Aioprtime = "AIOPRTIME";

    public BusiSettlePublishInfoBean() throws AIException {
        super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }

    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("error");
    }

    public void initSettleid(String value) {
        this.initProperty(S_Settleid, value);
    }

    public void setSettleid(String value) {
        this.set(S_Settleid, value);
    }

    public void setSettleidNull() {
        this.set(S_Settleid, null);
    }

    public String getSettleid() {
        return DataType.getAsString(this.get(S_Settleid));

    }

    public String getSettleidInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Settleid));
    }

    public void initRflag(String value) {
        this.initProperty(S_Rflag, value);
    }

    public void setRflag(String value) {
        this.set(S_Rflag, value);
    }

    public void setRflagNull() {
        this.set(S_Rflag, null);
    }

    public String getRflag() {
        return DataType.getAsString(this.get(S_Rflag));

    }

    public String getRflagInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Rflag));
    }

    public void initNote(String value) {
        this.initProperty(S_Note, value);
    }

    public void setNote(String value) {
        this.set(S_Note, value);
    }

    public void setNoteNull() {
        this.set(S_Note, null);
    }

    public String getNote() {
        return DataType.getAsString(this.get(S_Note));

    }

    public String getNoteInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Note));
    }

    public void initHpoprtime(String value) {
        this.initProperty(S_Hpoprtime, value);
    }

    public void setHpoprtime(String value) {
        this.set(S_Hpoprtime, value);
    }

    public void setHpoprtimeNull() {
        this.set(S_Hpoprtime, null);
    }

    public String getHpoprtime() {
        return DataType.getAsString(this.get(S_Hpoprtime));

    }

    public String getHpoprtimeInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Hpoprtime));
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

    public void initRmsg(String value) {
        this.initProperty(S_Rmsg, value);
    }

    public void setRmsg(String value) {
        this.set(S_Rmsg, value);
    }

    public void setRmsgNull() {
        this.set(S_Rmsg, null);
    }

    public String getRmsg() {
        return DataType.getAsString(this.get(S_Rmsg));

    }

    public String getRmsgInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Rmsg));
    }

    public void initHpoprid(String value) {
        this.initProperty(S_Hpoprid, value);
    }

    public void setHpoprid(String value) {
        this.set(S_Hpoprid, value);
    }

    public void setHpopridNull() {
        this.set(S_Hpoprid, null);
    }

    public String getHpoprid() {
        return DataType.getAsString(this.get(S_Hpoprid));

    }

    public String getHpopridInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Hpoprid));
    }

    public void initBakCol1(String value) {
        this.initProperty(S_BakCol1, value);
    }

    public void setBakCol1(String value) {
        this.set(S_BakCol1, value);
    }

    public void setBakCol1Null() {
        this.set(S_BakCol1, null);
    }

    public String getBakCol1() {
        return DataType.getAsString(this.get(S_BakCol1));

    }

    public String getBakCol1InitialValue() {
        return DataType.getAsString(this.getOldObj(S_BakCol1));
    }

    public void initAioprid(String value) {
        this.initProperty(S_Aioprid, value);
    }

    public void setAioprid(String value) {
        this.set(S_Aioprid, value);
    }

    public void setAiopridNull() {
        this.set(S_Aioprid, null);
    }

    public String getAioprid() {
        return DataType.getAsString(this.get(S_Aioprid));

    }

    public String getAiopridInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Aioprid));
    }

    public void initSettlemonth(String value) {
        this.initProperty(S_Settlemonth, value);
    }

    public void setSettlemonth(String value) {
        this.set(S_Settlemonth, value);
    }

    public void setSettlemonthNull() {
        this.set(S_Settlemonth, null);
    }

    public String getSettlemonth() {
        return DataType.getAsString(this.get(S_Settlemonth));

    }

    public String getSettlemonthInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Settlemonth));
    }

    public void initSeqId(long value) {
        this.initProperty(S_SeqId, new Long(value));
    }

    public void setSeqId(long value) {
        this.set(S_SeqId, new Long(value));
    }

    public void setSeqIdNull() {
        this.set(S_SeqId, null);
    }

    public long getSeqId() {
        return DataType.getAsLong(this.get(S_SeqId));

    }

    public long getSeqIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_SeqId));
    }

    public void initAioprtime(String value) {
        this.initProperty(S_Aioprtime, value);
    }

    public void setAioprtime(String value) {
        this.set(S_Aioprtime, value);
    }

    public void setAioprtimeNull() {
        this.set(S_Aioprtime, null);
    }

    public String getAioprtime() {
        return DataType.getAsString(this.get(S_Aioprtime));

    }

    public String getAioprtimeInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Aioprtime));
    }

}
