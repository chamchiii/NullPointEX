package com.javaclass.basic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javassem.controller.TestController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ControllerTest {

	private WebApplicationContext context;
	
	private MockMvc mockMvc;		//***** Mock : 모조품
	
	@Autowired
	TestController testController;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
	}
	
	@Test
	public void testBoard() throws Exception {
		mockMvc.perform(get("/test.do"))
					.andDo(print())
					.andExpect(status().isOk());
	}
	
	@Test
	public void testBoard2() throws Exception{
		mockMvc.perform(get("/test2.do").param("name", "이동원"))	//호출할때 값 넘겨주고
		.andDo(print())												//파일이름 찍어주고
		.andExpect(status().isOk())									//
		.andExpect(model().attributeExists("message"))	
		.andExpect(model().attributeExists("message", "이동원님 오늘도 졸려"))
		.andExpect(view().name("happyPage"));						//
		
	}
	
}
