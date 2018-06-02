package com.adopt.login.service;

import com.adopt.utils.RedisHelper;
import com.cdg.common.constant.RedisConstants;
import com.cdg.common.constant.StateConstants;
import com.cdg.common.utils.JsonUtils;
import com.cdg.common.utils.TokenUtils;
import com.cdg.common.utils.WeiXinUtils;
import com.cdg.db.user.dao.AdoptUserMapper;
import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/4 19:42
 */

@Service
public class LoginService {

    @Autowired
    private AdoptUserMapper userMapper;
    @Autowired
    private RedisHelper redisHelper;
    /**
      * @description 登录
      * @param
      * @date 20:15 2018/1/4
      * @return
      * @author zhenghao
    */
	public AdoptUser userLogin(String code) {

        //第二步：
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String strUrl = url.replace("APPID", "wx6d7afc6c790f73a6").replace("SECRET", "bf2c41bb5c8ce99b2392da4e6cfe3f4b").replace("CODE", code);
        net.sf.json.JSONObject jsonStr = WeiXinUtils.httpsRequest(strUrl, "GET", null);
        System.out.println("===========第二步==========="+jsonStr);
        //第三步：
        String userUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
        String refresh_token = jsonStr.getString("refresh_token");
        String userURLStr = userUrl.replace("APPID", "wx6d7afc6c790f73a6").replace("REFRESH_TOKEN", refresh_token);
        net.sf.json.JSONObject jsonObject = WeiXinUtils.httpsRequest(userURLStr, "GET", null);
        String accessToken = jsonObject.getString("access_token");
        String open_id = jsonObject.getString("openid");
        System.out.println("=========第三步=====openid==="+open_id+"====accesstoken="+accessToken);
        //第四步：
        String urlFor = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        String replaceUrl = urlFor.replace("ACCESS_TOKEN", accessToken).replace("OPENID", open_id);
        net.sf.json.JSONObject userInfoStr = WeiXinUtils.httpsRequest(replaceUrl, "GET", null);
        System.out.println("========第四步===userInfo==="+userInfoStr.toString());
        System.out.println("=========openid===========" + userInfoStr.getString("openid"));
        String unionid = userInfoStr.getString("unionid");
        AdoptUser oldUser = this.getUserByUnionid(unionid);
        AdoptUser newUser = new AdoptUser();
        if (oldUser == null) {
            newUser.setOpenId(userInfoStr.getString("openid"));
            String address = "";
            if (userInfoStr.getString("country") != null) {
                address += userInfoStr.getString("country");
            }
            if (userInfoStr.getString("province") != null) {
                address += userInfoStr.getString("province");
            }
            if (userInfoStr.getString("city") != null) {
                address += userInfoStr.getString("city");
            }
            newUser.setAddress(address);
            newUser.setHeadPortrait(userInfoStr.getString("headimgurl"));
            newUser.setNickname(userInfoStr.getString("nickname"));
            int sex = Integer.parseInt(userInfoStr.getString("sex"));
            newUser.setSex((byte) sex);
            newUser.setUnionId(userInfoStr.getString("unionid"));
            newUser.setCreateTime(System.currentTimeMillis());
            newUser.setUserState(StateConstants.ENABLE_STATE);
            int flag = userMapper.insertSelective(newUser);
            return newUser;
        }
        return  oldUser;
    }

    public AdoptUser getUserByUnionid(String unionid){
        AdoptUserExample example = new AdoptUserExample();
        example.createCriteria().andUnionIdEqualTo(unionid);
        List<AdoptUser> adoptUsers = userMapper.selectByExample(example);
        if (adoptUsers!=null && adoptUsers.size()>0){
            return adoptUsers.get(0);
        }
        return  null;
    }

    /**
     * 生成token
     *
     * @param userId
     * @return
     */
    public String generateToken() {
        java.lang.String tmp = UUID.randomUUID().toString().replaceAll("-", "");
        java.lang.String token = TokenUtils.getToken("chongxiaoguai", tmp, 1);
        return token;
    }


}
