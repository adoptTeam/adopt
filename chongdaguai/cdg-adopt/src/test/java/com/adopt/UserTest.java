package com.adopt;

import com.adopt.base.BaseTest;
import com.adopt.utils.RedisHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author zhenghao
 * @description
 * @date 2017/12/8 23:07
 */

public class UserTest extends BaseTest {

	@Autowired
	private RedisHelper redisHelper;
	@Test
	public void testUser() throws Exception {
		//// User user = userService.getUser(1L);
		// System.out.println(user.getName());
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/user/getUsers");
		// mockRequest.header("token", token);
		mockRequest.param("id", "1");

		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void testgetAdoptInfoByUserId() throws Exception {
		//// User user = userService.getUser(1L);
		// System.out.println(user.getName());
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/user/getAdoptInfoByUserId");
		// mockRequest.header("token", token);
		// mockRequest.param("id", "1");

		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void applyRefund() throws Exception {
		//// User user = userService.getUser(1L);
		// System.out.println(user.getName());
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/user/applyRefund");
		// mockRequest.header("token", token);
		// mockRequest.param("id", "1");

		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void selectAdoptByAdoptSearch() throws Exception {
		//// User user = userService.getUser(1L);
		// System.out.println(user.getName());
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/user/selectAdoptByAdoptSearch");
		// mockRequest.header("token", token);
		mockRequest.param("addressName", "1");
		mockRequest.param("addressPhone", "1");
		mockRequest.param("adoptState", "40");
		mockRequest.param("nickname", "1");
		mockRequest.param("realName", "");

		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void setDefaultAddress() throws Exception {
		//// User user = userService.getUser(1L);
		// System.out.println(user.getName());
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/userAddress/setDefaultAddress");
		mockRequest.header("token", "5ec2e27f7193f44d71e0b3908b5298342fcf023b");
		mockRequest.param("userAddressId", "76");

		ResultActions resultActions = mockMvc.perform(mockRequest);
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
	}
	@Test
	public void testHelp() {
		String s = redisHelper.get("autk:5ec2e27f7193f44d71e0b3908b5298342fcf023b");
		System.out.println(s);
	}

}
