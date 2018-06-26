package com.adopt.util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: fengyao
 * @date: 2018-04-16
 * @ver: 1.0
 * @desc: 下载图片
 */
public class DownImage {
    public void saveToFile(String destUrl, String localUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream(localUrl);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DownImage dw = new DownImage();
        dw.saveToFile("http://chognxiaoguaidev.oss-cn-beijing.aliyuncs.com/dev/7BF6435CBB64422D9386260EE99FC3A3.png", "E:\\li.gif");
    }
}