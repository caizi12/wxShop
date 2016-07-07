package ngves.asiainfo.core.common.util;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ai.appframe2.common.AIDataBase;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.AIResult;
import com.ai.appframe2.common.DBGridInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.GenFieldTypeSet;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.listdatasource.CashedObject;
import com.ai.appframe2.listdatasource.CashedObjectFactory;
import com.ai.appframe2.set.AIResultFactory;
import com.ai.appframe2.set.FieldTypeDB;
import com.ai.appframe2.set.FieldTypeSetDB;
import com.ai.appframe2.set.FieldTypeSetDBFactory;
import com.ai.appframe2.set.GenFieldTypeSetImpl;
import com.ai.appframe2.set.ListDataSourceField;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.appframe2.web.tag.DBGridInterfaceManager;

/**
 * 此Action可以使不想输出的Table的COL不输出到Excel中
 */
public class ExcelByColUtil extends BaseAction {

	public void toExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String notIncludeCol = request.getParameter("notIncludeCol");
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes(), "utf-8");
		long pk = Long.parseLong(request.getParameter("pk"));

		DBGridInterface grid = DBGridInterfaceManager.findDBGridInterface(pk);

		String includeColStr = "";

		for (int i = 0; i < grid.getCols(1).length; i++) {
			if (notIncludeCol.indexOf(grid.getCols(1)[i]) == -1) {
				includeColStr += grid.getCols(1)[i] + ";";
			}
		}

		String[] includeCol = includeColStr.split(";");

		String setName = grid.getSetname();
		GenFieldTypeSet genFieldTypeSet = SessionManager.getSetFactory().getGenFieldTypeSet(setName);
		if (genFieldTypeSet == null) {
			throw new AIException("没有查找到set配置文件：" + setName + " 请检查配置路径");
		}

		AIDataBase[] container = (AIDataBase[]) grid.getDBGridDataModel().getGridData(-1, -1);

		response.addHeader("Content-Disposition", "attachment; filename=" + filename + ".xls");
		response.setContentType("application/ms-excel");

		ServletOutputStream out = response.getOutputStream();

		genFieldTypeSet.getRowSetAsExcel(out, grid, AIResultFactory.getInstance(container), includeCol, null);

	}
	
	public void toExcelByPageNo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String notIncludeCol = request.getParameter("notIncludeCol");
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes(), "utf-8");
		long pk = Long.parseLong(request.getParameter("pk"));
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		int endIndex = Integer.parseInt(request.getParameter("endIndex"));

		DBGridInterface grid = DBGridInterfaceManager.findDBGridInterface(pk);

		String includeColStr = "";

		for (int i = 0; i < grid.getCols(1).length; i++) {
			if (notIncludeCol.indexOf(grid.getCols(1)[i]) == -1) {
				includeColStr += grid.getCols(1)[i] + ";";
			}
		}

		String[] includeCol = includeColStr.split(";");

		String setName = grid.getSetname();
		GenFieldTypeSet genFieldTypeSet = SessionManager.getSetFactory().getGenFieldTypeSet(setName);
		if (genFieldTypeSet == null) {
			throw new AIException("没有查找到set配置文件：" + setName + " 请检查配置路径");
		}

		AIDataBase[] container = (AIDataBase[]) grid.getDBGridDataModel().getGridData(startIndex, endIndex);

		response.addHeader("Content-Disposition", "attachment; filename=" + filename + ".xls");
		response.setContentType("application/ms-excel");

		ServletOutputStream out = response.getOutputStream();

		genFieldTypeSet.getRowSetAsExcel(out, grid, AIResultFactory.getInstance(container), includeCol, null);

	}

	public void toExcelIncludeHideCol(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String notIncludeCol = request.getParameter("notIncludeCol");
		String includeHideCol = request.getParameter("includeHideCol");
		String filename = request.getParameter("filename");
		filename = new String(filename.getBytes(), "utf-8");
		long pk = Long.parseLong(request.getParameter("pk"));

		DBGridInterface grid = DBGridInterfaceManager.findDBGridInterface(pk);

		String includeColStr = "";

		for (int i = 0; i < grid.getCols(0).length; i++) {
			if (notIncludeCol.indexOf(grid.getCols(0)[i]) == -1) {
				includeColStr += grid.getCols(0)[i] + ";";
			}
		}
		//includeColStr += includeHideCol + ";";

		String[] includeCol = includeColStr.split(";");

		String setName = grid.getSetname();

		AIDataBase[] container = (AIDataBase[]) grid.getDBGridDataModel().getGridData(-1, -1);

		response.addHeader("Content-Disposition", "attachment; filename=" + filename + ".xls");
		response.setContentType("application/ms-excel");

		ServletOutputStream out = response.getOutputStream();

		this.getRowSetAsExcel1(out, grid, AIResultFactory.getInstance(container), includeCol, null, includeHideCol
				.split(";"), setName);

	}

	public void getRowSetAsExcel1(OutputStream aOutputStream, DBGridInterface aGridInterface, AIResult aDataList,
			String[] attrNames, HashMap<Object,Object> title_map, String[] attrHideNames, String setName) throws Exception {
		GenFieldTypeSetImpl genFieldTypeSet = new GenFieldTypeSetImpl(setName);
		if (genFieldTypeSet == null) {
			throw new AIException("没有查找到set配置文件：" + setName + " 请检查配置路径");
		}
		FieldTypeSetDB fieldTypeSet = FieldTypeSetDBFactory.getFieldTypeSet(setName, true);
		if (fieldTypeSet == null) {
			OutputStreamWriter writer = new OutputStreamWriter(aOutputStream, "encoding");
			writer.write("错误信息:FieldTypeSet为空；请检查Set的名称是否正确");
			return;
		}
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("sheet1");
		short currentRow = 0;
		short currentCol = 0;
		FieldTypeDB[] cols = (FieldTypeDB[]) null;
		ArrayList<Object> showColsArray = new ArrayList<Object>();
		if ((attrNames == null) || (attrNames.length == 0)) {
			ArrayList<Object> a = new ArrayList<Object>();
			for (int i = 0; i < fieldTypeSet.getFieldCount(); ++i) {
				a.add(new Integer(i));
			}
			while (a.size() > 0) {
				int point = 0;
				for (int i = 1; i < a.size(); ++i) {
					FieldTypeDB tmpField = fieldTypeSet.getField(((Integer) a.get(i)).intValue());
					FieldTypeDB tmpFieldPoint = fieldTypeSet.getField(((Integer) a.get(point)).intValue());
					if (tmpField.getDisplaySeq() < tmpFieldPoint.getDisplaySeq())
						point = i;
				}
				FieldTypeDB tmpFieldPoint = fieldTypeSet.getField(((Integer) a.get(point)).intValue());
				a.remove(point);
				if (tmpFieldPoint.getDisplaySeq() >= 0)
					showColsArray.add(tmpFieldPoint);
			}
		} else {
			String[] hideFieldArray = aGridInterface.getCols(2);
			for (int i = 0; i < attrNames.length; ++i) {
				FieldTypeDB tmpcol = fieldTypeSet.getField(attrNames[i]);
				if (tmpcol == null) {
					throw new AIException("[ERROR]GenFieldTypeSetImpl:getFieldTypeDB by attrNames " + attrNames[i]
							+ " return null");
				}
//				if (attrHideNames != null
//						&& attrHideNames.length != 0
//						&& (com.ai.appframe2.util.StringUtils.indexOfArray(attrHideNames, tmpcol.getName()
//								.toUpperCase()) >= 0)) {
//					showColsArray.add(tmpcol);
//					continue;
//				}
				if ((hideFieldArray != null)
						&& (hideFieldArray.length != 0)
						&& (com.ai.appframe2.util.StringUtils.indexOfArray(hideFieldArray, tmpcol.getName()
								.toUpperCase()) >= 0))
					continue;
				showColsArray.add(tmpcol);
			}
		}
       
		//隐藏的列倒出来对应存放位置
		for(int i=0;i<attrHideNames.length;i++){
			String[]   str=attrHideNames[i].split(",");			
			showColsArray.add(Integer.parseInt(str[0]), fieldTypeSet.getField(str[1]));
		}
		cols = (FieldTypeDB[]) showColsArray.toArray(new FieldTypeDB[0]);

		String[] totalNames = aGridInterface.getColTotals();
		BigDecimal[] totalValues = new BigDecimal[totalNames.length];
		int[] isTotals = new int[showColsArray.size()];

		for (int i = 0; i < showColsArray.size(); ++i) {
			boolean isFind = false;
			for (int j = 0; j < totalNames.length; ++j) {
				if (((FieldTypeDB) showColsArray.get(i)).getName().equalsIgnoreCase(totalNames[j])) {
					isTotals[i] = j;
					totalValues[j] = new BigDecimal(0.0D);
					isFind = true;
					break;
				}
			}
			if (!(isFind)) {
				isTotals[i] = -1;
			}
		}
		StringWriter tmpWriter = new StringWriter();
		genFieldTypeSet.getFieldTypeSetString(tmpWriter, attrNames, aGridInterface, false);
		genFieldTypeSet.getHeaderString(tmpWriter);
		tmpWriter.close();
		tmpWriter = null;

		HashMap<Object,Object> colTotalTags = new HashMap<Object,Object>();
		for (int i = 0; i < showColsArray.size(); ++i) {
			String column_name = ((FieldTypeDB) showColsArray.get(i)).getName();
			if (isTotals[i] >= 0)
				colTotalTags.put(column_name, "true");
			else {
				colTotalTags.put(((FieldTypeDB) showColsArray.get(i)).getName(), "false");
			}
			currentRow = 0;
			currentCol = (short) i;
			String aValue = null;

			if (title_map != null) {
				aValue = (String) title_map.get(column_name);
			}
			if (aValue == null) {
				aValue = aGridInterface.getColTitle(column_name);
				if (aValue == null) {
					aValue = ((FieldTypeDB) showColsArray.get(i)).getTitle();
				}
			}
			sheet = genFieldTypeSet.setValueByRowCol(sheet, currentRow, currentCol, aValue);
		}
		if (aDataList == null) {
			return;
		}
		CashedObject[] tmpListDataSource = new CashedObject[cols.length];
		for (int i = 0; i < cols.length; ++i) {
			FieldTypeDB tmpFieldType = cols[i];
			tmpListDataSource[i] = null;
			if ((tmpFieldType.getListDataSource() == null) || (tmpFieldType.getListDataSource().getType() != 0))
				continue;
			ListDataSourceField list = (ListDataSourceField) genFieldTypeSet.m_Field_Ds.get(tmpFieldType.getName());
			if ((list == null) || (list.m_object instanceof CashedObjectFactory.SelfCashRowSet))
				continue;
			tmpListDataSource[i] = list.m_object;
		}

		int sheetNumber = 1;
		int dataRowCount = 0;
		while (aDataList.next()) {
			++dataRowCount;
			currentRow = (short) (currentRow + 1);
			if (currentRow >= 60001) {
				++sheetNumber;
				sheet = workBook.createSheet("sheet" + sheetNumber);
				currentRow = 1;

				for (int i = 0; i < showColsArray.size(); ++i) {
					String aValue = ((FieldTypeDB) showColsArray.get(i)).getTitle();
					sheet = genFieldTypeSet.setValueByRowCol(sheet, (short) 0, (short) i, aValue);
				}
			}
			for (int j = 0; j < cols.length; ++j) {
				FieldTypeDB tmpField = cols[j];
				String tmpBOAttrName = tmpField.getBOAttrName();
				if ((tmpBOAttrName == null) || (tmpBOAttrName.trim().equals(""))) {
					tmpBOAttrName = tmpField.getName();
				}
				String sIDValue = "";
				String sDisValue = "";
				Object idObj = aDataList.getObject(tmpBOAttrName);

				if (idObj != null) {
					sIDValue = GenFieldTypeSetImpl.transFieldTypeValueToString(idObj, tmpField);
					if ((j < isTotals.length) && (isTotals[j] >= 0)) {
						totalValues[isTotals[j]] = totalValues[isTotals[j]].add(new BigDecimal(sIDValue));
					}
				}
				if ((tmpField.getBODisplayAttrName() != null) && (!(tmpField.getBODisplayAttrName().trim().equals("")))) {
					Object aDisObj = aDataList.getDispalyAttr(tmpBOAttrName, tmpField.getBODisplayAttrName());
					if (aDisObj == null)
						aDisObj = aDataList.getObject(tmpField.getBODisplayAttrName());
					if (aDisObj != null)
						sDisValue = DataType.transferToString(aDisObj, tmpField.getDataType().getName());
				} else if (tmpListDataSource[j] != null) {
					Object o = tmpListDataSource[j].getTextById(sIDValue);
					if (o != null)
						sDisValue = o.toString();
					else {
						sDisValue = " ";
					}
				}

				String aValue = "";
				if ((sDisValue != null) && (!(sDisValue.equals(""))) && (sIDValue != null) && (!(sIDValue.equals("")))) {
					aValue = sDisValue;
				} else if ((sIDValue != null) && (!(sIDValue.equals("")))) {
					aValue = sIDValue;
				}

				currentCol = (short) j;
				sheet = genFieldTypeSet.setValueByRowCol(sheet, currentRow, currentCol, aValue);
			}
		}

		if (totalNames.length > 0) {
			currentRow = (short) (currentRow + 1);
			for (int i = 0; i < cols.length; ++i) {
				String aValue = "";
				if (isTotals[i] >= 0) {
					String tmpDataType = cols[i].getDataType().getJavaDataType();
					if ((tmpDataType.equalsIgnoreCase("Integer")) || (tmpDataType.equalsIgnoreCase("Long"))) {
						aValue = Long.toString(totalValues[isTotals[i]].longValue());
					} else {
						aValue = totalValues[isTotals[i]].toString();
					}
				} else if (i == 0) {
					aValue = "合计";
				}
				currentCol = (short) i;
				sheet = genFieldTypeSet.setValueByRowCol(sheet, currentRow, currentCol, aValue);
			}
		}
		workBook.write(aOutputStream);
	}
}
