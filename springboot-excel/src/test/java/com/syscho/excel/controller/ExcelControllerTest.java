package com.syscho.excel.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.syscho.excel.controller.ExcelController;
import com.syscho.excel.service.ExcelReader;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ExcelController.class)
public class ExcelControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@MockBean
	private ExcelReader excelReader;

	@Test
	public void testShouldSendMultiPartRequestForExcel2003() throws Exception {

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file","test-2003.xls",
				MediaType.MULTIPART_FORM_DATA_VALUE,
				this.getClass().getResourceAsStream("/test-2003.xls"));

		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(multipart("/excel").file(mockMultipartFile)).andExpect(status().isOk());

	}

	@Test
	public void testShouldSendMultiPartRequestForExcel2007() throws Exception {

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file","test.xlsx",
				MediaType.MULTIPART_FORM_DATA_VALUE,
				this.getClass().getResourceAsStream("/test.xlsx"));

		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(multipart("/excel").file(mockMultipartFile)).andExpect(status().isOk());

	}

	@Test
	public void testShouldReturnBadRequest() throws Exception {

		MockMultipartFile mockMultipartFile = new MockMultipartFile("file","dummyText",
				MediaType.MULTIPART_FORM_DATA_VALUE,
				this.getClass().getResourceAsStream("/test.xlsx"));

		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(multipart("/excel").file(mockMultipartFile)).andExpect(status().isBadRequest());

	}

	

}












