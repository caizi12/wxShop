package ngves.asiainfo.core.common.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoDetailBean;
import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDetailDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;
import ngves.asiainfo.core.common.service.interfaces.IBusiInfoDetailSrv;
import ngves.asiainfo.core.tuan.exception.MgtException;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

public class BusiInfoDetailSrvImpl implements IBusiInfoDetailSrv {
    IBusiInfoDetailDAO busiInfoDetailDAO = null;

    public IBusiInfoDetailValue getBusiInfoDetail(long subBusiId) throws Exception {
        return busiInfoDetailDAO.getBusiInfoDetail(subBusiId);
    }

    public IBusiInfoDetailValue[] getBusiInfoDetails(long busiId) throws Exception {
        return busiInfoDetailDAO.getBusiInfoDetails(busiId);
    }

    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetails(String busiId, Map oldValues, Map newValues) throws Exception {
        return recordBusiInfoDetails(busiId, oldValues, newValues, null);
    }

    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetails(String busiId, Map oldValues, Map newValues, String fieldName) throws Exception {
        if (StringUtil.isBlank(busiId) || null == oldValues || null == newValues || oldValues.size() == 0
                || oldValues.size() != newValues.size())
            throw new MgtException("invalid input parameters or the arrays length is not equal.");
        List details = new ArrayList();
        Iterator iter = oldValues.entrySet().iterator();
        while (iter.hasNext()) {
            //对于横表应该够了，对于纵表呢,需要制定那个字段
            Map.Entry entry = (Map.Entry) iter.next();
            Object oldValue = entry.getValue();
            Object key = entry.getKey();
            Object newValue = newValues.get(key);
            if (null != oldValue && null != newValue) {
                List diff = compare(busiId, oldValue, newValue, fieldName);
                if (null != diff && 0 < diff.size())
                    details.addAll(diff);
            }
        }
        busiInfoDetailDAO.saveBusiInfoDetails((IBusiInfoDetailValue[]) details.toArray(new IBusiInfoDetailValue[details
                .size()]));
        return Long.parseLong(busiId);
    }

    public long recordBusiInfoDetails(String busiId, Object[] oldValues, Object[] newValues) throws Exception {
        return recordBusiInfoDetails(busiId, oldValues, newValues, null);
    }

    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetails(String busiId, Object[] oldValues, Object[] newValues, String fieldName)
            throws Exception {
        if (StringUtil.isBlank(busiId) || null == oldValues || null == newValues || oldValues.length == 0
                || oldValues.length != newValues.length)
            throw new MgtException("invalid input parameters or the arrays length is not equal.");
        try {
            Long.parseLong(busiId);
        } catch (Exception e) {
            throw new MgtException("the busiId is not a long number:" + busiId);
        }
        List details = new ArrayList();
        for (int i = 0; i < oldValues.length; i++) {
            //对于横表应该够了，对于纵表呢,需要制定那个字段
            List diff = compare(busiId, oldValues[i], newValues[i], fieldName);
            if (null != diff && 0 < diff.size())
                details.addAll(diff);
        }
        busiInfoDetailDAO.saveBusiInfoDetails((IBusiInfoDetailValue[]) details.toArray(new IBusiInfoDetailValue[details
                .size()]));
        return Long.parseLong(busiId);
    }

    @SuppressWarnings("unchecked")
    private List compare(String busiId, Object oldObj, Object newObj, String fieldValueName) throws Exception {
        List values = new ArrayList();

        Class beforeClass = oldObj.getClass();
        Class afterClass = newObj.getClass();
        Field[] fields = beforeClass.getDeclaredFields();
        String tableName = "";
        tableName = beforeClass.getName();
        if (null != tableName) {
            if (tableName.lastIndexOf('.') >= 0) {
                tableName = tableName.substring(tableName.lastIndexOf('.') + 1);
            }
            if (tableName.lastIndexOf("Bean") >= 0) {
                tableName = tableName.substring(0, tableName.lastIndexOf("Bean"));
            }
        }
        StringBuffer pkFieldNames = new StringBuffer();
        StringBuffer pkFieldValues = new StringBuffer();
        if (null != fieldValueName && fieldValueName.length() >= 2) {
            if (fieldValueName.indexOf(CoreConstant.BUSI_DETAIL_SPLIT) >= 0) {
                String[] splits = fieldValueName.split(CoreConstant.BUSI_DETAIL_SPLIT);
                if (null != splits) {
                    for (int i = 0; i < splits.length; i++) {
                        pkFieldNames.append(getPKFieldName(splits[i], beforeClass, oldObj)).append("/");
                        pkFieldValues.append(getPKFieldValue(splits[i], beforeClass, oldObj)).append("/");
                    }
                    pkFieldNames.deleteCharAt(pkFieldNames.length() - 1);
                    pkFieldValues.deleteCharAt(pkFieldValues.length() - 1);
                }
            } else {
                pkFieldValues.append(getPKFieldValue(fieldValueName, beforeClass, oldObj));
                pkFieldNames.append(getPKFieldName(fieldValueName, beforeClass, oldObj));
            }
        }
        if (null != fields) {
			for (int i = 0; i < fields.length; i++) {

				//if (!fields[i].getName().equals("S_AwardLevelId")) {
					try {
						String fieldName = fields[i].getName();

						if (fieldName.indexOf("S_") >= 0) {
							Object obj = fields[i].get(oldObj);
							// 判断新对象是否有
							String mthName = fieldName.substring(fieldName.indexOf("S_") + 2);
							mthName = "get" + mthName;
							Method mthd1 = beforeClass.getDeclaredMethod(mthName, (Class[]) null);
							Method mthd2 = afterClass.getDeclaredMethod(mthName, (Class[]) null);
							if (null != mthd1 && null != mthd2) {
								// 开始两个都获取值
								Object oldValue = mthd1.invoke(oldObj, (Object[]) null);
								Object newValue = mthd2.invoke(newObj, (Object[]) null);
								if (null != oldValue && null != newValue) {
									String oldProp = oldValue.toString();
									String newProp = newValue.toString();
									if (oldValue instanceof Timestamp) {
										oldProp = DateTimeUtil.timeStampToString((Timestamp) oldValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (newValue instanceof Timestamp) {
										newProp = DateTimeUtil.timeStampToString((Timestamp) newValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (!oldProp.equals(newProp)) {
										// 属性值不等
										IBusiInfoDetailValue value = new BusiInfoDetailBean();
										if (null != obj)
											fieldName = obj.toString();
										value.setFieldName(fieldName);
										value.setBeforeValue(oldProp);
										value.setAfterValue(newProp);
										value.setBusiTable(tableName);
										value.setBusiId(Long.parseLong(busiId));
										value.setMainFldName(pkFieldNames.toString());
										value.setMainFldValue(pkFieldValues.toString());
										value.setStsToNew();
										values.add(value);
									}
								}
							}
						}
					} catch (Exception e) {
						// e.printStackTrace();
						// 此处全部是访问类属性或者方法发生地异常，不进行处理
					}

				//}// end if
			}

		}

        return values;
    }

    @SuppressWarnings("unchecked")
    private String getPKFieldValue(String fieldValueName, Class beforeClass, Object oldObj) throws Exception {
        String fieldValue = null;
        try {
            String fldName = null;
            if (fieldValueName.indexOf("S_") >= 0)
                fldName = "get" + fieldValueName.substring(fieldValueName.indexOf("S_") + 2);
            else
                fldName = "get" + ("" + (fieldValueName.charAt(0))).toUpperCase() + fieldValueName.substring(1);
            Method tmpMthd = beforeClass.getDeclaredMethod(fldName, (Class[]) null);
            if (null != tmpMthd) {
                Object obj = tmpMthd.invoke(oldObj, (Object[]) null);
                if (null != obj)
                    fieldValue = obj.toString();
            }
        } catch (Exception e) {
            //不做任何处理
        }
        return fieldValue;
    }

    @SuppressWarnings("unchecked")
    private String getPKFieldName(String fieldName, Class beforeClass, Object oldObj) throws Exception {
        String fieldValue = null;
        try {
            String fldName = fieldName;
            if (fieldName.indexOf("S_") < 0)
                fldName = "S_" + fieldName;
            Field fld = beforeClass.getDeclaredField(fldName);
            if (null != fld) {
                fieldValue = fld.get(oldObj).toString();
            }
        } catch (Exception e) {
            //不做任何处理
        }
        return fieldValue;
    }

    public long saveBusiInfoDetail(IBusiInfoDetailValue busiInfoDetail) throws Exception {
        return busiInfoDetailDAO.saveBusiInfoDetail(busiInfoDetail);
    }

    public void saveBusiInfoDetails(IBusiInfoDetailValue[] busiInfoDetails) throws Exception {
        busiInfoDetailDAO.saveBusiInfoDetails(busiInfoDetails);
    }

    public void setBusiInfoDetailDAO(IBusiInfoDetailDAO busiInfoDetailDAO) throws Exception {
        this.busiInfoDetailDAO = busiInfoDetailDAO;
    }

    //li new
    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetailsForAwardLevel(String busiId, Object[] oldValues, Object[] newValues, String fieldName)
    throws Exception {
        if (StringUtil.isBlank(busiId) || null == oldValues || null == newValues || oldValues.length == 0
                || oldValues.length != newValues.length)
            throw new MgtException("invalid input parameters or the arrays length is not equal.");
        try {
            Long.parseLong(busiId);
        } catch (Exception e) {
            throw new MgtException("the busiId is not a long number:" + busiId);
        }
        List details = new ArrayList();
        for (int i = 0; i < oldValues.length; i++) {
            //对于横表应该够了，对于纵表呢,需要制定那个字段
            List diff = compareForAwardLevelInfo(busiId, oldValues[i], newValues[i], fieldName);
            if (null != diff && 0 < diff.size())
                details.addAll(diff);
        }
        busiInfoDetailDAO.saveBusiInfoDetails((IBusiInfoDetailValue[]) details.toArray(new IBusiInfoDetailValue[details
                .size()]));
        return Long.parseLong(busiId);
    	
    }
    
    @SuppressWarnings("unchecked")
    private List compareForAwardLevelInfo(String busiId, Object oldObj, Object newObj, String fieldValueName) throws Exception {
        List values = new ArrayList();

        Class beforeClass = oldObj.getClass();
        Class afterClass = newObj.getClass();
        Field[] fields = beforeClass.getDeclaredFields();
        String tableName = "";
        tableName = beforeClass.getName();
        if (null != tableName) {
            if (tableName.lastIndexOf('.') >= 0) {
                tableName = tableName.substring(tableName.lastIndexOf('.') + 1);
            }
            if (tableName.lastIndexOf("Bean") >= 0) {
                tableName = tableName.substring(0, tableName.lastIndexOf("Bean"));
            }
        }
        StringBuffer pkFieldNames = new StringBuffer();
        StringBuffer pkFieldValues = new StringBuffer();
        if (null != fieldValueName && fieldValueName.length() >= 2) {
            if (fieldValueName.indexOf(CoreConstant.BUSI_DETAIL_SPLIT) >= 0) {
                String[] splits = fieldValueName.split(CoreConstant.BUSI_DETAIL_SPLIT);
                if (null != splits) {
                    for (int i = 0; i < splits.length; i++) {
                        pkFieldNames.append(getPKFieldName(splits[i], beforeClass, oldObj)).append("/");
                        pkFieldValues.append(getPKFieldValue(splits[i], beforeClass, oldObj)).append("/");
                    }
                    pkFieldNames.deleteCharAt(pkFieldNames.length() - 1);
                    pkFieldValues.deleteCharAt(pkFieldValues.length() - 1);
                }
            } else {
                pkFieldValues.append(getPKFieldValue(fieldValueName, beforeClass, oldObj));
                pkFieldNames.append(getPKFieldName(fieldValueName, beforeClass, oldObj));
            }
        }
        if (null != fields) {
			for (int i = 0; i < fields.length; i++) {

				if (!fields[i].getName().equals("S_AwardLevelId")) {
					try {
						String fieldName = fields[i].getName();

						if (fieldName.indexOf("S_") >= 0) {
							Object obj = fields[i].get(oldObj);
							// 判断新对象是否有
							String mthName = fieldName.substring(fieldName.indexOf("S_") + 2);
							mthName = "get" + mthName;
							Method mthd1 = beforeClass.getDeclaredMethod(mthName, (Class[]) null);
							Method mthd2 = afterClass.getDeclaredMethod(mthName, (Class[]) null);
							if (null != mthd1 && null != mthd2) {
								// 开始两个都获取值
								Object oldValue = mthd1.invoke(oldObj, (Object[]) null);
								Object newValue = mthd2.invoke(newObj, (Object[]) null);
								if (null != oldValue && null != newValue) {
									String oldProp = oldValue.toString();
									String newProp = newValue.toString();
									if (oldValue instanceof Timestamp) {
										oldProp = DateTimeUtil.timeStampToString((Timestamp) oldValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (newValue instanceof Timestamp) {
										newProp = DateTimeUtil.timeStampToString((Timestamp) newValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (!oldProp.equals(newProp)) {
										// 属性值不等
										IBusiInfoDetailValue value = new BusiInfoDetailBean();
										if (null != obj)
											fieldName = obj.toString();
										value.setFieldName(fieldName);
										value.setBeforeValue(oldProp);
										value.setAfterValue(newProp);
										value.setBusiTable(tableName);
										value.setBusiId(Long.parseLong(busiId));
										value.setMainFldName(pkFieldNames.toString());
										value.setMainFldValue(pkFieldValues.toString());
										value.setStsToNew();
										values.add(value);
									}
								}
							}
						}
					} catch (Exception e) {
						// e.printStackTrace();
						// 此处全部是访问类属性或者方法发生地异常，不进行处理
					}

				}// end if
			}

		}

        return values;
    }
    
    
    //li new 
    
    //hu
    @SuppressWarnings("unchecked")
    public boolean compareIValue(Object oldObj, Object newObj, String fieldValueName) throws Exception {
        boolean isDifferent = false;
        Class beforeClass = oldObj.getClass();
        Class afterClass = newObj.getClass();
        Field[] fields = beforeClass.getDeclaredFields();
        String tableName = "";
        tableName = beforeClass.getName();
        if (null != tableName) {
            if (tableName.lastIndexOf('.') >= 0) {
                tableName = tableName.substring(tableName.lastIndexOf('.') + 1);
            }
            if (tableName.lastIndexOf("Bean") >= 0) {
                tableName = tableName.substring(0, tableName.lastIndexOf("Bean"));
            }
        }
        StringBuffer pkFieldNames = new StringBuffer();
        StringBuffer pkFieldValues = new StringBuffer();
        if (null != fieldValueName && fieldValueName.length() >= 2) {
            if (fieldValueName.indexOf(CoreConstant.BUSI_DETAIL_SPLIT) >= 0) {
                String[] splits = fieldValueName.split(CoreConstant.BUSI_DETAIL_SPLIT);
                if (null != splits) {
                    for (int i = 0; i < splits.length; i++) {
                        pkFieldNames.append(getPKFieldName(splits[i], beforeClass, oldObj)).append("/");
                        pkFieldValues.append(getPKFieldValue(splits[i], beforeClass, oldObj)).append("/");
                    }
                    pkFieldNames.deleteCharAt(pkFieldNames.length() - 1);
                    pkFieldValues.deleteCharAt(pkFieldValues.length() - 1);
                }
            } else {
                pkFieldValues.append(getPKFieldValue(fieldValueName, beforeClass, oldObj));
                pkFieldNames.append(getPKFieldName(fieldValueName, beforeClass, oldObj));
            }
        }
        if (null != fields) {
			for (int i = 0; i < fields.length; i++) {
				try {
					String fieldName = fields[i].getName();

					if (fieldName.indexOf("S_") >= 0) {
						// 判断新对象是否有
						String mthName = fieldName.substring(fieldName
								.indexOf("S_") + 2);
						mthName = "get" + mthName;
						Method mthd1 = beforeClass.getDeclaredMethod(mthName,
								(Class[]) null);
						Method mthd2 = afterClass.getDeclaredMethod(mthName,
								(Class[]) null);
						if (null != mthd1 && null != mthd2) {
							// 开始两个都获取值
							Object oldValue = mthd1.invoke(oldObj,
									(Object[]) null);
							Object newValue = mthd2.invoke(newObj,
									(Object[]) null);
							if (null != oldValue && null != newValue) {
								String oldProp = oldValue.toString();
								String newProp = newValue.toString();
								if (oldValue instanceof Timestamp) {
									oldProp = DateTimeUtil.timeStampToString(
											(Timestamp) oldValue,
											CommnConstant.DATETIME_JAVA_FORMAT);
								}
								if (newValue instanceof Timestamp) {
									newProp = DateTimeUtil.timeStampToString(
											(Timestamp) newValue,
											CommnConstant.DATETIME_JAVA_FORMAT);
								}
								if (!oldProp.equals(newProp)) {
									isDifferent = true;
								}
							}
						}
					}
				} catch (Exception e) {
					// e.printStackTrace();
					// 此处全部是访问类属性或者方法发生地异常，不进行处理
				}
			}

		}

        return isDifferent;
    }
    
    @SuppressWarnings("unchecked")
	public boolean compareValueIgnoreAwardLevelId(Object oldObj, Object newObj, String fieldValueName) throws Exception {
		boolean isDifferent = false;
		Class beforeClass = oldObj.getClass();
		Class afterClass = newObj.getClass();
		Field[] fields = beforeClass.getDeclaredFields();
		String tableName = "";
		tableName = beforeClass.getName();
		if (null != tableName) {
			if (tableName.lastIndexOf('.') >= 0) {
				tableName = tableName.substring(tableName.lastIndexOf('.') + 1);
			}
			if (tableName.lastIndexOf("Bean") >= 0) {
				tableName = tableName.substring(0, tableName.lastIndexOf("Bean"));
			}
		}
		StringBuffer pkFieldNames = new StringBuffer();
		StringBuffer pkFieldValues = new StringBuffer();
		if (null != fieldValueName && fieldValueName.length() >= 2) {
			if (fieldValueName.indexOf(CoreConstant.BUSI_DETAIL_SPLIT) >= 0) {
				String[] splits = fieldValueName.split(CoreConstant.BUSI_DETAIL_SPLIT);
				if (null != splits) {
					for (int i = 0; i < splits.length; i++) {
						pkFieldNames.append(getPKFieldName(splits[i], beforeClass, oldObj)).append("/");
						pkFieldValues.append(getPKFieldValue(splits[i], beforeClass, oldObj)).append("/");
					}
					pkFieldNames.deleteCharAt(pkFieldNames.length() - 1);
					pkFieldValues.deleteCharAt(pkFieldValues.length() - 1);
				}
			} else {
				pkFieldValues.append(getPKFieldValue(fieldValueName, beforeClass, oldObj));
				pkFieldNames.append(getPKFieldName(fieldValueName, beforeClass, oldObj));
			}
		}
		if (null != fields) {
			for (int i = 0; i < fields.length; i++) {
				try {
					String fieldName = fields[i].getName();

					if (fieldName.indexOf("S_") >= 0) {
						// 判断新对象是否有
						if (!fields[i].getName().equals("S_AwardLevelId")) {
							String mthName = fieldName.substring(fieldName.indexOf("S_") + 2);
							mthName = "get" + mthName;
							Method mthd1 = beforeClass.getDeclaredMethod(mthName, (Class[]) null);
							Method mthd2 = afterClass.getDeclaredMethod(mthName, (Class[]) null);
							if (null != mthd1 && null != mthd2) {
								// 开始两个都获取值
								Object oldValue = mthd1.invoke(oldObj, (Object[]) null);
								Object newValue = mthd2.invoke(newObj, (Object[]) null);
								if (null != oldValue && null != newValue) {
									String oldProp = oldValue.toString();
									String newProp = newValue.toString();
									if (oldValue instanceof Timestamp) {
										oldProp = DateTimeUtil.timeStampToString((Timestamp) oldValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (newValue instanceof Timestamp) {
										newProp = DateTimeUtil.timeStampToString((Timestamp) newValue,
												CommnConstant.DATETIME_JAVA_FORMAT);
									}
									if (!oldProp.equals(newProp)) {
										isDifferent = true;
									}
								}
							}
						}
					}
				} catch (Exception e) {
					// e.printStackTrace();
					// 此处全部是访问类属性或者方法发生地异常，不进行处理
				}
			}

		}

		return isDifferent;
	}
    
    
}