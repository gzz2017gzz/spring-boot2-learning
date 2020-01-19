package com.gzz;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())//
				.andExpect(content().string(equalTo("Hello World"))).andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
	@Test
	public void addUser() throws Exception {
		User user= new User();
		user.setAge(19);
		user.setId(1);
		user.setName("张三");
		mvc.perform(MockMvcRequestBuilders.get("/test/add").accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk())//
				.andExpect(content().string(equalTo("1"))).andDo(MockMvcResultHandlers.print()).andReturn();
	}
	/**
	 * 1、mockMvc.perform执行一个请求。 
	 * 2、MockMvcRequestBuilders.get("XXXXX")构造一个请求。
	 * 3、ResultActions.andExpect添加执行完成后的断言。
	 * 4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情,比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
	 * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
	 */
}
