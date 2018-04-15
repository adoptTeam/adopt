package com.adopt;

import com.adopt.base.BaseTest;
import com.adopt.littlepet.service.CommentService;
import com.adopt.littlepet.service.LittlePetService;
import com.cdg.common.model.ResultList;
import com.cdg.db.enhance.model.AdoptCommentAndReply;
import com.cdg.db.pet.model.AdoptLittlePet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/4 14:21
 */

public class LittlePetTest extends BaseTest {
    @Autowired
    private LittlePetService littlePetService;

    @Autowired
    private CommentService commentService;

    @Test
    public void getLittlePetList() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/littlePet/getLittlePetList");
        mockRequest.param("content", "想");
        ResultActions resultActions = mockMvc.perform(mockRequest);
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void littlePetTest() {
        ResultList resultList = littlePetService.getLittlePetList("主人", null);
        AdoptLittlePet pet = new AdoptLittlePet();
        pet.setName("测试狗");
        pet.setSex((byte) 1);
        boolean flag = littlePetService.addPetInfo(pet);

        System.out.println("查询结果为：" + flag);
    }

    @Test
    public void getCommentTest(){
        Long petId=1l;
        List<AdoptCommentAndReply> list=commentService.getAllCommentsByPetId(petId);
        System.out.println(list);
    }

    @Test
    public void addRecordBrowseTest(){
        Long petId=1L;
        Long userId=1L;
        littlePetService.addRecordBrowse(userId,petId);
    }
    @Test
    public void addRecordCollectionTest(){
        Long petId=1L;
        Long userId=1L;
        littlePetService.addRecordCollection(userId,petId);
    }
    @Test
    public void delRecordCollectionTest(){
        Long petId=1L;
        Long userId=1L;
//        littlePetService.delRecordCollection(userId,petId);
        boolean petAdopted = littlePetService.isPetAdopted(16L);
        System.out.println(petAdopted);
    }

}
