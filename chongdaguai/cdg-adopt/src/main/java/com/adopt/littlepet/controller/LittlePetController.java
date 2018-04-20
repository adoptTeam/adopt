package com.adopt.littlepet.controller;

import com.adopt.common.service.CommonService;
import com.adopt.littlepet.model.LittlePetViewModel;
import com.adopt.littlepet.service.CommentService;
import com.adopt.littlepet.service.LittlePetService;
import com.adopt.util.DownImage;
import com.adopt.util.WaterMarkUtils;
import com.cdg.common.exception.ToUserException;
import com.cdg.common.model.ResultList;
import com.cdg.common.utils.DateUtils;
import com.cdg.common.utils.OSSUploadUtil;
import com.cdg.common.utils.ServletUtils;
import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.plugin.Page;
import com.cdg.db.user.model.AdoptRecord;
import com.cdg.db.user.model.AdoptUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 * @author huayu
 * @date 2018/4/18 下午2:15
 */
@Api(value = "小乖模块")
@Controller
@RequestMapping("/littlePet")
public class LittlePetController {
    @Autowired
    private LittlePetService littlePetService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/toPetView", method = {RequestMethod.POST, RequestMethod.GET})
    public String toPetView() {
        return "petInfo";
    }
    /**
     * 添加宠物
     * @param request
     * @param res
     */
    @RequestMapping(value = "/addPet", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "添加宠物", notes = "添加宠物", httpMethod = "POST")
    public void addPetInfo(HttpServletRequest request, HttpServletResponse res) {
        AdoptLittlePet pet = getAdoptLittlePetFromRequest(request);
        if (pet.getPetId() == null) {
            ServletUtils.toJson(false, request, res);
        }
        boolean flag = littlePetService.addPetInfo(pet);
        ServletUtils.toJson(flag, request, res);
    }

    /**
     * 更新宠物信息, 根据页面信息进行更新
     * @param request
     * @param res
     */
    @RequestMapping(value = "/updatePetAllInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "更新宠物信息", notes = "更新宠物信息", httpMethod = "POST")
    public void updatePetInfoAllInfo(HttpServletRequest request, HttpServletResponse res) {
        AdoptLittlePet pet = getAdoptLittlePetFromRequest(request);
        if (pet.getPetId() == null) {
            ServletUtils.toJson(false, request, res);
        }
        Boolean flag = littlePetService.updatePetInfo(pet);
        ServletUtils.toJson(flag, request, res);
    }
    /**
     * 更新宠物信息, 更新部分信息
     * @param request
     * @param res
     */
    @RequestMapping(value = "/updatePetPartInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "更新宠物信息,更新部分信息", notes = "更新宠物信息,更新部分信息", httpMethod = "POST")
    public void updatePetInfoPartInfo(HttpServletRequest request, HttpServletResponse res) {
        AdoptLittlePet pet = getAdoptLittlePetFromRequest(request);
        if (pet.getPetId() == null) {
            ServletUtils.toJson(false, request, res);
        }
        Boolean flag = littlePetService.updatePetPartInfo(pet);
        ServletUtils.toJson(flag, request, res);
    }


    @RequestMapping(value = "/updatePetPhotoInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "添加宠物图片", notes = "添加宠物图片", httpMethod = "POST")
    public String updatePetPhotoInfo(HttpServletRequest request, HttpServletResponse res) {
        String pet_Id = request.getParameter("photoPetId");
        if (StringUtils.isBlank(pet_Id)) {
            ServletUtils.toJson(false, request, res);
        }
        Long petId = Long.valueOf(pet_Id);
        AdoptLittlePet petOld = littlePetService.queryPetInfoByPetId(petId);
        if (petOld == null) {
            ServletUtils.toJson(false, request, res);
        }
        String headPhoto = petOld.getHeadPortraits();
        AdoptLittlePet pet = new AdoptLittlePet();
        pet.setPetId(petId);
        String photoUrl = uploadImgsToOss(request);
        if (StringUtils.isBlank(photoUrl)) {
            ServletUtils.toJson(false, request, res);
        }
        if (StringUtils.isBlank(headPhoto)) {
            pet.setHeadPortraits(photoUrl);
        } else {
            pet.setHeadPortraits(headPhoto + ";" + photoUrl);
        }
        Boolean flag = littlePetService.updatePetPartInfo(pet);
        return "redirect:http://adopt.chongxiaoguai.com/managePage/pet.html";
    }

    /**
     * 内部方法，oss保存图片
     * @param request
     * @return
     */
    private String uploadImgsToOss(HttpServletRequest request) {
        String fileUrlOld = null;
        String fileUrlTarget = null;
        File newFile = null;
        InputStream input = null;

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            // 取得上传文件
            MultipartFile file = multipartRequest.getFile("myfiles");
            if (file == null) {
                return null;
            }
            // 取得当前上传文件的文件名称
            String fileName = file.getOriginalFilename();
            input = file.getInputStream();
            // 如果名称不为空,说明该文件存在，否则说明该文件不存在
            if (!StringUtils.isBlank(fileName) && fileName.contains(".")) {
                String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length()).substring(1);
                fileUrlOld = OSSUploadUtil.uploadFileInput(input, fileType);
                String path = Thread.currentThread().getContextClassLoader().getResource("watermark/water.png").getPath();
                path = path.substring(0, path.lastIndexOf("watermark/water.png")) + fileName;
                new DownImage().saveToFile(fileUrlOld, path);
                newFile = new File(path);
                WaterMarkUtils.resize(path, 640, 360, true);
                WaterMarkUtils.pressImage(newFile, fileType, -1, -1, 0.6f);
                fileUrlTarget = OSSUploadUtil.uploadFile(newFile, fileType);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Oss保存错误");
        } finally {
            OSSUploadUtil.deleteFile(fileUrlOld);
            if (newFile != null) {
                newFile.delete();
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileUrlTarget;
    }
    /**
     * 删除宠物信息
     * @param request
     * @param res
     */
    @RequestMapping(value = "/delPet", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "删除宠物信息", notes = "删除宠物信息", httpMethod = "POST")
    public void delPetInfo(HttpServletRequest request, HttpServletResponse res) {
        Long petId = Long.valueOf(getFileValueFromHttpRequest(request, "petId"));
        if (petId == null) {
            ServletUtils.toJson(false, request, res);
        }
        Boolean flag = littlePetService.delPetInfo(petId);
        ServletUtils.toJson(flag, request, res);
    }
    /**
     * 根据主键查询宠物信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/queryPetInfoByPetId", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "根据主键查询宠物信息", notes = "根据主键查询宠物信息", httpMethod = "POST")
    @ResponseBody
    @CrossOrigin
    public void queryPetInfoByPetId(HttpServletRequest req, HttpServletResponse res) {
        Long petId = Long.valueOf(getFileValueFromHttpRequest(req, "petId"));
        if (petId == null) {
            petId = 1l;
        }
        AdoptLittlePet adoptLittlePet = littlePetService.queryPetInfoByPetId(petId);
        LittlePetViewModel petViewModel = new LittlePetViewModel(adoptLittlePet);
        ServletUtils.toJson(petViewModel, req, res);
    }

    /**
     * 根据主键查询宠物信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/queryPetAdoptState", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "根据主键查询宠物领养信息", notes = "根据主键查询宠物领养信息", httpMethod = "POST")
    @ResponseBody
    @CrossOrigin
    public void queryPetAdoptState(HttpServletRequest req, HttpServletResponse res) {
        Long petId = Long.valueOf(getFileValueFromHttpRequest(req, "petId"));
        boolean flag = littlePetService.isPetAdopted(petId);
        ServletUtils.toJson(flag, req, res);
    }

    /**
     * 通过宠物id获取宠物信息
     * @param req
     * @param res
     * @param petId
     */
    @RequestMapping("/getPetInfoByPetId")
    @CrossOrigin
    public void getPetInfoByPetId(HttpServletRequest req, HttpServletResponse res, Long petId) {
        AdoptLittlePet adoptLittlePet = littlePetService.queryPetInfoByPetId(petId);
        LittlePetViewModel petViewModel = new LittlePetViewModel(adoptLittlePet);
        ServletUtils.toJson(petViewModel, req, res);
    }
    /**
     * 根据条件查询宠物信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/queryPetInfoByCondition", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "根据条件查询宠物信息", notes = "根据条件查询宠物信息", httpMethod = "POST")
    public void queryPetInfoByCondition(HttpServletRequest req, HttpServletResponse res) {
        AdoptLittlePet pet = getAdoptLittlePetFromRequest(req);
        List<AdoptLittlePet> adoptLittlePets = littlePetService.queryPetInfoByCondition(pet);
        ServletUtils.toJson(adoptLittlePets, req, res);
    }
    /**
     * 获得小乖列表
     * @param req
     * @param res
     * @param content
     * @param page
     */
    @RequestMapping(value = "/getLittlePetList", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "获得小乖列表", notes = "获得小乖列表", httpMethod = "POST")
    public void getLittlePetList(HttpServletRequest req, HttpServletResponse res, String content, Page page) {
        ResultList littlePetList = littlePetService.getLittlePetList(content, page);
        ServletUtils.toJson(littlePetList, req, res);
    }
    /**
     * 获得小乖列表
     * @param req
     * @param res
     * @param content
     */
    @RequestMapping(value = "/selectLittlePetList", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    public void selectLittlePetList(HttpServletRequest req, HttpServletResponse res, String content) {
        ResultList littlePetList = littlePetService.selectLittlePetList(content);
        ServletUtils.toJson(littlePetList, req, res);
    }
    /**
     * 内部方法，从http请求中获取指定字段的值
     * @param request
     * @param file
     * @return
     */
    private String getFileValueFromHttpRequest(HttpServletRequest request, String file) {
        if (request == null || StringUtils.isEmpty(file)) {
            return "";
        }
        return request.getParameter(file);
    }
    /**
     * 内部方法，从http请求中获得AdoptLittlePet实体
     * @param request
     * @return
     */
    private AdoptLittlePet getAdoptLittlePetFromRequest(HttpServletRequest request) {
        AdoptLittlePet pet = new AdoptLittlePet();
        String petId = request.getParameter("petId");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String breed = request.getParameter("breed");
        String weight = request.getParameter("weight");
        String birthControl = request.getParameter("birthControl");
        String location = request.getParameter("location");
        String vaccineTime = request.getParameter("vaccineTime");
        String petTell = request.getParameter("petTell");
        String comment = request.getParameter("comment");
        String headPortraits = request.getParameter("headPortraits");
        String browseCount = request.getParameter("browseCount");
        String petState = request.getParameter("petState");
        String createTime = request.getParameter("createTime");
        String updateTime = request.getParameter("updateTime");
        if (!StringUtils.isEmpty(petId)) {
            pet.setPetId(Long.valueOf(petId));
        }
        if (!StringUtils.isEmpty(name)) {
            pet.setName(name);
        }
        if (!StringUtils.isEmpty(sex)) {
            pet.setSex(Byte.valueOf(sex));
        }
        if (!StringUtils.isEmpty(birthday)) {
            long date = str2Date2Long(birthday);
            pet.setBirthday(date);
        }
        if (!StringUtils.isEmpty(breed)) {
            pet.setBreed(breed);
        }
        if (!StringUtils.isEmpty(weight)) {
            pet.setWeight(Integer.valueOf(weight));
        }
        if (!StringUtils.isEmpty(birthControl)) {
            pet.setBirthControl(Byte.valueOf(birthControl));
        }
        if (!StringUtils.isEmpty(location)) {
            pet.setLocation(location);
        }
        if (!StringUtils.isEmpty(vaccineTime)) {
            long date = str2Date2Long(vaccineTime);
            pet.setVaccineTime(date);
        }
        if (!StringUtils.isEmpty(petTell)) {
            pet.setPetTell(petTell);
        }
        if (!StringUtils.isEmpty(comment)) {
            pet.setComment(comment);
        }
        if (!StringUtils.isEmpty(headPortraits)) {
            pet.setHeadPortraits(headPortraits);
        }
        if (!StringUtils.isEmpty(browseCount)) {
            pet.setBrowseCount(Integer.valueOf(browseCount));
        }
        if (!StringUtils.isEmpty(petState)) {
            pet.setPetState(Byte.valueOf(petState));
        }
        if (!StringUtils.isEmpty(createTime)) {
            long date = str2Date2Long(createTime);
            pet.setCreateTime(date);
        }
        if (!StringUtils.isEmpty(updateTime)) {
            long date = str2Date2Long(updateTime);
            pet.setUpdateTime(date);
        }
        return pet;
    }
    /**
     * 获取收藏状态
     * @param req
     * @param res
     */
    @RequestMapping(value = "/getRecordState", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "获取收藏状态", notes = "获取收藏状态", httpMethod = "POST")
    public void getRecordState(HttpServletRequest req, HttpServletResponse res) {
        String id = getFileValueFromHttpRequest(req, "petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long uId = user.getUserId();

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(String.valueOf(uId))) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        Long userId = Long.valueOf(uId);
        AdoptRecord adoptRecord = littlePetService.getRecordState(userId, petId);
        ServletUtils.toJson(adoptRecord, req, res);
    }
    /**
     * 添加浏览记录
     * @param req
     * @param res
     */
    @RequestMapping(value = "/addRecordBrowse", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "添加浏览记录", notes = "添加浏览记录", httpMethod = "POST")
    public void addRecordBrowse(HttpServletRequest req, HttpServletResponse res) {
        String id = getFileValueFromHttpRequest(req, "petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long uId = user.getUserId();

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(String.valueOf(uId))) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        Long userId = Long.valueOf(uId);
        littlePetService.addRecordBrowse(userId, petId);
    }
    /**
     * 添加收藏记录
     * @param req
     * @param res
     */
    @RequestMapping(value = "/addRecordCollection", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "添加收藏记录", notes = "添加收藏记录", httpMethod = "POST")
    public void addRecordCollection(HttpServletRequest req, HttpServletResponse res) {
        String id = getFileValueFromHttpRequest(req, "petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long uId = user.getUserId();

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(String.valueOf(uId))) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        Long userId = Long.valueOf(uId);
        littlePetService.addRecordCollection(userId, petId);
    }
    /**
     * 删除收藏记录
     * @param req
     * @param res
     */
    @RequestMapping(value = "/delRecordCollection", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "删除收藏览记录", notes = "删除收藏览记录", httpMethod = "POST")
    public void delRecordCollection(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long uId = user.getUserId();
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(String.valueOf(uId))) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        Long userId = Long.valueOf(uId);
        boolean flag = littlePetService.delRecordCollection(userId, petId);
        ServletUtils.toJson(flag, req, res);
    }
    /**
     *  获取领养协议的三方信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/getAdoptionAgreementInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "获取领养协议的三方信息", notes = "获取领养协议的三方信息", httpMethod = "POST")
    public void getAdoptionAgreementInfo(HttpServletRequest req, HttpServletResponse res) {
        String id = getFileValueFromHttpRequest(req, "petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long uId = user.getUserId();

        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(String.valueOf(uId))) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        Long userId = Long.valueOf(uId);
        AdoptUser userInfo = userService.getUserInfoByUserId(userId);
        AdoptLittlePet pet = littlePetService.queryPetInfoByPetId(petId);
        Map<String, Object> map = new TreeMap<>();
        map.put("userInfo", userInfo);
        map.put("petInfo", pet);
        ServletUtils.toJson(map, req, res);
    }
    /**
     * 模糊查询小乖信息，模糊条件：petId\name\breed\sex\petState
     * @param req
     * @param res
     */
    @RequestMapping(value = "/getPetInfoByStrLike", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin
    @ApiOperation(value = "模糊查询小乖信息，模糊条件：petId\\name\\breed\\sex\\petState\\location", notes = "模糊查询小乖信息，模糊条件：petId\\name\\breed\\sex\\petState\\location", httpMethod = "POST")
    public void getPetInfoByStrLike(HttpServletRequest req, HttpServletResponse res) {
        String strLike = getFileValueFromHttpRequest(req, "condition");
        List<AdoptLittlePet> petList = littlePetService.getPetInfoByStrLike(strLike);
        List<LittlePetViewModel> pets = new ArrayList<>();
        for (AdoptLittlePet item : petList) {
            LittlePetViewModel petViewModel = new LittlePetViewModel(item);
            pets.add(petViewModel);
        }
        ServletUtils.toJson(pets, req, res);
    }
    /**
     * 添加评论
     * @param req
     * @param res
     */
    @RequestMapping(value = "/addViewLog", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "添加浏览记录", notes = "添加浏览记录", httpMethod = "POST")
    public void addViewLog(HttpServletRequest req, HttpServletResponse res) {
        String petId = req.getParameter("petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long userId = user.getUserId();
        if (StringUtils.isBlank(petId) || StringUtils.isBlank(String.valueOf(userId))) {
            ServletUtils.toJson(false, req, res);
        }
        addRecord(Long.valueOf(petId), userId, Byte.valueOf("0"));
    }
    /**
     * 添加评论
     * @param req
     * @param res
     */
    @RequestMapping(value = "/addCollectionLog", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "添加收藏记录", notes = "添加收藏记录", httpMethod = "POST")
    public void addCollectionLog(HttpServletRequest req, HttpServletResponse res) {
        String petId = req.getParameter("petId");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long userId = user.getUserId();
        if (StringUtils.isBlank(petId) || StringUtils.isBlank(String.valueOf(userId))) {
            ServletUtils.toJson(false, req, res);
        }
        boolean flag = addRecord(Long.valueOf(petId), userId, Byte.valueOf("1"));
        ServletUtils.toJson(flag, req, res);
    }
    /**
     * 添加浏览/收藏记录
     * @param petId
     * @param userId
     * @param recordType
     * @return
     */
    private boolean addRecord(Long petId, Long userId, byte recordType) {
        AdoptRecord record = new AdoptRecord();
        record.setUserId(userId);
        record.setPetId(petId);
        record.setRecordType(recordType);
        record.setCreateTime(System.currentTimeMillis());
        record.setUpdateTime(System.currentTimeMillis());
        return commentService.addRecord(record);
    }

    /**
     * 获取收养信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/getAdoptAgreementInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @CrossOrigin
    @ApiOperation(value = "获取三方协议信息", notes = "获取三方协议信息", httpMethod = "POST")
    public void getAdoptAgreementInfo(HttpServletRequest req, HttpServletResponse res) {
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if (user == null) {
            throw new ToUserException("无效token信息");
        }
        long userId = user.getUserId();
        String petId = req.getParameter("petId");
        if (StringUtils.isBlank(String.valueOf(petId)) || StringUtils.isBlank(petId)) {
            throw new ToUserException("无效小乖id信息");
        }
        HashMap<String, Object> result = littlePetService.getAdoptAgreementInfo(Long.valueOf(petId), Long.valueOf(userId));
        ServletUtils.toJson(result, req, res);
    }
    /**
     * String2Date2long
     * @param strDate
     * @return
     */
    private static long str2Date2Long(String strDate) {
        Date date = DateUtils.string2Date(strDate);
        return date.getTime();
    }


    public static void main(String[] args) {
        str2Date2Long("2017-09-08");
    }
}
