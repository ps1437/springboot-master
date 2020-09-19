package com.syscho.excel.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.syscho.excel.service.ExcelReader;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ExcelController {

	private ExcelReader excelReader;

	private final String EXCEL_XLSX = "xlsx";
	private final String EXCEL_XLS = "xls";

	public ExcelController(ExcelReader excelReader) {
		this.excelReader = excelReader;
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful"),
			@ApiResponse(responseCode = "500", description = "Internal Server error"),
			@ApiResponse(responseCode = "404", description = "The API could not be found") })

	@PostMapping(value = "/excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> readExcel(@RequestPart("file") MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();

		List<Map<Object, Object>> response = null;

		if (originalFilename.contains(EXCEL_XLS)) {

			if (originalFilename.endsWith(EXCEL_XLSX)) {
				response = excelReader.readExcelX(file.getInputStream());
			} else if (originalFilename.endsWith(EXCEL_XLS)) {
				response = excelReader.readExcel(file.getInputStream());
			}
			return ResponseEntity.ok(response);
		}

		return ResponseEntity.badRequest().body("Please select excel file { xlsx or xls } ");

	}

}

















