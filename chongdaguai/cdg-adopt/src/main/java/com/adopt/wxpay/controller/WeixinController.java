package com.adopt.wxpay.controller;

import com.adopt.common.controller.BaseController;
import com.adopt.common.service.CommonService;
import com.adopt.user.service.UserService;
import com.adopt.wxpay.service.CashInfoService;
import com.cdg.common.enums.AdoptStateEnum;
import com.cdg.common.utils.DateUtils;
import com.cdg.common.utils.ServletUtils;
import com.cdg.common.wxpayutils.*;
import com.cdg.db.cash.model.AdoptCashInfo;
import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserAdopt;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import io.swagger.annotations.ApiOperation;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @Author:whp
 * @Description: 微信H5生成二维码支付
 * @Date:2017/12/14 23:15
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends BaseController{
    @Autowired
    private CashInfoService cashInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    private static String weixinSign;
    /**
     *
     * @Author whp
     * @Description 支付完成回调地址
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/Notify")
    public void Notify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //读取参数
//        InputStream inputStream;
//        StringBuffer sb = new StringBuffer();
//        inputStream = request.getInputStream();
//        String s;
//        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//        while ((s = in.readLine()) != null) {
//            sb.append(s);
//        }
//        in.close();
//        inputStream.close();
//        //解析xml成map
//        Map<String, String> m = new HashMap<String, String>();
//        try {
//            m = XMLUtil.doXMLParse(sb.toString());
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        }
//        System.out.println("====支付回调xml文件=="+sb.toString());
//        //过滤空 设置 TreeMap
//        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
//        Iterator it = m.keySet().iterator();
//        while (it.hasNext()) {
//            String parameter = (String) it.next();
//            String parameterValue = m.get(parameter);
//            String v = "";
//            if (null != parameterValue) {
//                v = parameterValue.trim();
//            }
//            packageParams.put(parameter, v);
//        }
//        // 账号信息
//        String key = PayConfigUtil.API_KEY; //key
//        //判断签名是否正确
//        if (PayCommonUtil.isTenpaySign("UTF-8", packageParams, key)) {
//            String resXml = "";
//            if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
//                // 这里是支付成功
//                System.out.println("获取的userid："+packageParams.get("nonce_str"));
//                Long userId = Long.parseLong((String)packageParams.get("nonce_str"));
//                System.out.println("======支付成功获得token========"+userId);
//                //缴费成功后保存资金状态
//
//                AdoptUserAdopt adoptInfo=userService.getOrderByUserId(userId);
//                byte amountState=0;
//                String description="缴纳体验承诺金";
//                cashInfoService.insert(adoptInfo.getAdoptId(),amountState,description,"");
//                Boolean result = userService.updateStatus(adoptInfo.getAdoptId(),
//                        AdoptStateEnum.PAYED.getValue(),AdoptStateEnum.INIT.getValue());
//                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
//                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
//                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
//            } else {
//                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
//                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//            }
//            BufferedOutputStream out = new BufferedOutputStream(
//                    response.getOutputStream());
//            out.write(resXml.getBytes());
//            out.flush();
//            out.close();
//        } else {
//            System.out.println("通知签名验证失败");
//        }
    }

    /**
     * @Author whp
     * @Description 微信支付调用接口
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/pay")
    public void pay(HttpServletResponse response) throws ServletException, IOException { //HttpServletRequest request,
        try {
//            String redisToken = request.getParameter("weixinToken");//request.getHeader("tokens");
//            AdoptUser user=commonService.getUserInfo(redisToken);
//            Long userId=user.getUserId();
            String text = weixinPay("1","oo776v--l8XSNnRb6fF3Uuc7tFsM");//getWexinReturn();
            System.out.println(text);
            //根据url来生成生成二维码
            int width = 300;
            int height = 300;
            //二维码的图片格式
            String format = "gif";
            Hashtable hints = new Hashtable();
            //内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix  bitMatrix;
            try {
                bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE, width, height, hints);
                MatrixToImageWriter.writeToStream(bitMatrix, format, response.getOutputStream());
            } catch (WriterException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    /**
     * @Author whp
     * @Description 微信支付访问后台
     * @return
     * @throws Exception
     */
    public static String weixinPay(String userId,String openId) throws Exception {
        // 账号信息
        String appid = PayConfigUtil.appid;  // appid
        String mch_id = PayConfigUtil.MCH_ID; // 商业号
        String key = PayConfigUtil.API_KEY; // key
        String order_price = "30000"; // 价格   注意：价格的单位是分
        //获取发起ip
        String spbill_create_ip = PayConfigUtil.CREATE_IP;
        //回调接口
        String notify_url = PayConfigUtil.NOTIFY_URL;
        String trade_type = "JSAPI";//"NATIVE";
        String orderId =  DateUtils.dateTime2String(new Date());
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("device_info", "WEB");
        packageParams.put("nonce_str", userId);//userId
        packageParams.put("body", "宠小乖支付");
        packageParams.put("out_trade_no",orderId);
        packageParams.put("total_fee", order_price);
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("trade_type", trade_type);
        packageParams.put("notify_url", notify_url);
        packageParams.put("openid",openId);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, key);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, requestXML);
        System.out.println(resXml);
        Map map = XMLUtil.doXMLParse(resXml);
        String prepay_id = (String) map.get("prepay_id"); //code_url
        return prepay_id;
    }
    @ApiOperation(value = "领养体验金",notes = "登录")
    @RequestMapping("/getPersonCashInfo")
    public void getPersonCashInfo(HttpServletRequest req, HttpServletResponse res){
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        AdoptUserAdopt adoptInfo=userService.getOrderByUserId(user.getUserId());
        List<AdoptCashInfo> adoptCashInfos=cashInfoService.getPersonCashInfoByAdoptId(adoptInfo.getAdoptId());
        ServletUtils.toJson(adoptCashInfos, req, res);
    }

    @RequestMapping("/jsApiPay")
    @CrossOrigin
    public void weixinJsApiPay(HttpServletRequest request,HttpServletResponse response){
        try{
//            String redisToken = request.getParameter("weixinToken");//request.getHeader("tokens");
            String redisToken = request.getHeader("weixinToken");
            System.out.println("========weixinJsApiPay:redistoken========="+redisToken);
            AdoptUser user=commonService.getUserInfo(redisToken);
            System.out.println("========weixinJsApiPay:user-openId========="+user.getOpenId());
            WeiXinJSPayModel weiXinJSPayModel=new WeiXinJSPayModel();
            weiXinJSPayModel.setAppid(PayConfigUtil.appid);
            String timeStamp=(System.currentTimeMillis()/1000)+"";
            weiXinJSPayModel.setTimestamp(timeStamp);
            weiXinJSPayModel.setNoceStr("adsfas12112112qw");

            String prepayId=weixinPay(user.getUserId().toString(),user.getOpenId());
            weiXinJSPayModel.setPrepay_id("prepay_id="+prepayId);

            //组装map用于生成sign
            SortedMap<Object, Object> map = new TreeMap<Object, Object>();
            map.put("appId", PayConfigUtil.appid);
            map.put("timeStamp", timeStamp);
            map.put("nonceStr", "adsfas12112112qw");
            map.put("package", "prepay_id="+prepayId);
            map.put("signType", "MD5");
            String sign=PayCommonUtil.createSign("UTF-8", map, PayConfigUtil.API_KEY);
            weiXinJSPayModel.setSign(sign);
            System.out.println("========jsApiPay:sign============"+sign);
            ServletUtils.toJson(weiXinJSPayModel,request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping("/alterCashInfo")
    public void alterCashInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redisToken = request.getHeader("weixinToken");//request.getHeader("tokens");
        AdoptUser user=commonService.getUserInfo(redisToken);
        //缴费成功后保存资金状态
        AdoptUserAdopt adoptInfo=userService.getOrderByUserId(user.getUserId());
        byte amountState=0;
        String description="缴纳体验承诺金";
        cashInfoService.insert(adoptInfo.getAdoptId(),amountState,description,"");
        Boolean result = userService.updateStatus(adoptInfo.getAdoptId(),
                AdoptStateEnum.PAYED.getValue(),AdoptStateEnum.INIT.getValue());
        ServletUtils.toJson(result,request,response);
    }
}
