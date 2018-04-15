package com.adopt;

import com.adopt.base.BaseTest;
import org.junit.Test;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/3 19:55
 */

public class SystemTest extends BaseTest {

    @Test
    public void testUser() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/system/getAddress");
        mockRequest.param("type", "1");
        mockRequest.param("par", "河北");
        ResultActions resultActions  = mockMvc.perform(mockRequest);
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void testGetPet() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/system/getPet1");
        mockRequest.param("content", "小");
        //mockRequest.param("par", "河北");
        ResultActions resultActions  = mockMvc.perform(mockRequest);
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
    }
}
