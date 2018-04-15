package com.cdg.common.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @Author:whp
 * @Description:
 * @Date:2017/12/15 22:59
 */
public class MyX509TrustManager implements X509TrustManager{
    /**
      * @description  检查客户端证书
      * @param
      * @date 19:48 2018/1/4
      * @return
      * @author zhenghao
    */
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    /**
      * @description  检查服务器端证书
      * @param
      * @date 19:49 2018/1/4
      * @return
      * @author zhenghao
    */
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    /**
      * @description 返回受信任的X509证书数组
      * @param
      * @date 19:49 2018/1/4
      * @return
      * @author zhenghao
    */
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
