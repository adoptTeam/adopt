package com.cdg.common.utils;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;

/** 
  * @description json 转换工具类 
  * @param  
  * @date 1:09 2018/2/9
  * @return  
  * @author zhenghao
*/
public final class JsonUtils {

    public static ObjectMapper mapper = new ObjectMapper();
    static {
        // 序列化时null字段不输出
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将json字符串反序列号成对象
     * 
     * @param <T>
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * 
     * @param json
     * @param valueTypeRef
     * @return
     * @return: T
     */
    public static <T> T readValue(String json, TypeReference<T> valueTypeRef) {
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * 将对象序列号json字符串
     * 
     * @param obj
     * @return
     */
    public static String writeValue(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
        }

        return null;
    }
}
