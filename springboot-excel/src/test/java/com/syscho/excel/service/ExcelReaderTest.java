package com.syscho.excel.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.syscho.excel.service.ExcelReader;

@ExtendWith(SpringExtension.class)
public class ExcelReaderTest {

	@Test
	public void testShouldReadExcelFileVersion2003() {

		ExcelReader excelReader = new ExcelReader();
		List<Map<Object, Object>> data = excelReader.readExcel(this.getClass().getResourceAsStream("/test-2003.xls"));
		assertNotNull(data);

	}

	@Test
	public void testShouldReadExcelFileVersion2007() {

		ExcelReader excelReader = new ExcelReader();
		List<Map<Object, Object>> data = excelReader.readExcelX(this.getClass().getResourceAsStream("/test.xlsx"));
		assertNotNull(data);

	}
}
