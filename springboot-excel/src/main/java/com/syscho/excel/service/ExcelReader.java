package com.syscho.excel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelReader {

	@SuppressWarnings("deprecation")
	private void getColumnHeaders(List<String> columnNames, Row currentRow) {
		for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {

			if (currentRow.getCell(k).getCellTypeEnum() == CellType.STRING) {
				columnNames.add(currentRow.getCell(k).getStringCellValue());
			} else if (currentRow.getCell(k).getCellTypeEnum() == CellType.NUMERIC) {
				columnNames.add(String.valueOf(currentRow.getCell(k).getNumericCellValue()));
			}

		}
	}

	@SuppressWarnings("deprecation")
	private void readSheetData(List<Map<Object, Object>> columnData, List<String> columnNames, Sheet sheet) {
		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {

			Map<Object, Object> jsonObject = new HashMap<>();
			Row currentRow = iterator.next();

			if (currentRow.getRowNum() == 0) {
				getColumnHeaders(columnNames, currentRow);
			} else {

				for (int j = 0; j < columnNames.size(); j++) {

					if (currentRow.getCell(0) == null) {
						break;
					}

					Cell cell = currentRow.getCell(j);
					if (cell != null) {

						switch (cell.getCellType()) {

						case Cell.CELL_TYPE_STRING:
							jsonObject.put(columnNames.get(j), cell.getStringCellValue());
							break;

						case Cell.CELL_TYPE_NUMERIC:
							jsonObject.put(columnNames.get(j), cell.getNumericCellValue());
							break;

						case Cell.CELL_TYPE_BOOLEAN:
							jsonObject.put(columnNames.get(j), cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_BLANK:
							jsonObject.put(columnNames.get(j), "");

						}
					}

				}
				columnData.add(jsonObject);

			}
		}
	}

	public List<Map<Object, Object>> readExcelX(InputStream inputStream) {

		List<Map<Object, Object>> columnData = new ArrayList<>();
		List<String> columnNames = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			readSheetData(columnData, columnNames, sheet);
			workbook.close();
		} catch (IOException exp) {
			exp.printStackTrace();
		}
		return columnData;

	}

	public List<Map<Object, Object>> readExcel(InputStream inputStream) {

		List<Map<Object, Object>> columnData = new ArrayList<>();
		List<String> columnNames = new ArrayList<>();
		try {

			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			readSheetData(columnData, columnNames, sheet);
			workbook.close();
		} catch (IOException exp) {
			exp.printStackTrace();
		}
		return columnData;

	}

}
