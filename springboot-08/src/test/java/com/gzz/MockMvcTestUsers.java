package com.gzz ;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.sys.users.Users;
import com.gzz.sys.users.UsersCond;

import lombok.extern.slf4j.Slf4j;
/**
 * @类说明 [users]测试工具，将本类移到maven测试目录中或测试完成之后删除
 * @author 高振中
 * @date 2019-01-12 22:40:08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class MockMvcTestUsers {
 
	@Autowired
	private MockMvc mvc;
	/**
	 * @方法说明 测试 新增[users]记录,根据数据类型修改每个字段的值
	 */
 	//@Test
	public void save() throws Exception {
 		Users users = Users.builder()
 		//.id("gaozz") // 设置【id】的值
 		//.name("gaozz") // 设置【name】的值
 		//.age("gaozz") // 设置【age】的值
 		.build();
		log.info(doRequest("/users/save", users));
	}
	/**
	 * @方法说明 测试 查询[users]列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryList() throws Exception {
		UsersCond cond = UsersCond.builder()
 		//.id("gaozz")  // 设置查询条件【id】的值
 		//.name("gaozz")  // 设置查询条件【name】的值
 		//.age("gaozz")  // 设置查询条件【age】的值
		.build();
		log.info(doRequest("/users/queryList", cond));
	}
	/**
	 * @方法说明 测试 查询[users]分页列表,条件可以为空,可直接运行
	 */
	@Test
	public void queryPage() throws Exception {
		UsersCond cond = UsersCond.builder()
 		//.id("gaozz")  // 设置查询条件【id】的值
 		//.name("gaozz")  // 设置查询条件【name】的值
 		//.age("gaozz")  // 设置查询条件【age】的值
		.build();
		cond.setPage(0); //当前页
		cond.setSize(10); //页大小
		log.info(doRequest("/users/queryPage", cond));
	}
	
	private <T> String doRequest(String url, T t) throws Exception {// restController专用测试方法
		return mvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(t))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
	}
}