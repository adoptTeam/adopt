package com.cdg.common.utils;

import com.cdg.common.exception.TpErrorCodeGeneral;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * servletUtils
 *
 * @author zhenghao
 * @date 2017/10/23
 */
public class ServletUtils {

    public static void writeString(String str, HttpServletRequest req, HttpServletResponse res) {
        initResponse(res);
        PrintWriter out;
        try {
            out = res.getWriter();
            out.write(str);
            out.flush();
            out.close();
        } catch (IOException e) {

        }
    }

    public static void mapToJson(Map<String, ?> map, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjTojson(map);
        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void listMapToJson(List<?> list, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjTojson(list);
        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void strToJson(String dataStr, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjAndStrTojson(dataStr);
        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void jsonStrToJson(String dataStr, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = "{\"code\":\"" + TpErrorCodeGeneral.RESULT_CODE_OK + "\",\"msg\":\"ok\"";

        if (dataStr != null) {
            jsonStr += ",\"data\":" + dataStr;
        }

        jsonStr += "}";

        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void toJson(HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjTojson();
        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void toJson(String key, Object value, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjTojson(key, value);
        ServletUtils.writeString(jsonStr, req, res);
    }

    public static void toJson(Object value, HttpServletRequest req, HttpServletResponse res) {
        String jsonStr = resultObjTojson(value);
        ServletUtils.writeString(jsonStr, req, res);
    }

    private static void initResponse(HttpServletResponse res) {
        res.setContentType("application/json;charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Request-Method", "POST");
        res.setHeader("Access-Control-Request-Headers", "token");
    }

    public static String resultObjTojson(Map<String, ?> map) {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code", TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            g.writeObjectFieldStart("data");
            // 遍历map
            writeTreeMap(g, map);

            g.writeEndObject();
            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ObjectMapper 是线程安全的，可以共享，但共享的结果是效率比较低（内部应该还是有竞争冲突）
     * 使用空间换取时间，为没有引用对象创建一个副本。
     */
    private static ThreadLocal localMapper = new ThreadLocal();
    private static ObjectMapper getMapper() {
        ObjectMapper mapper = (ObjectMapper) localMapper.get();
        if (mapper == null) {
            mapper = new ObjectMapper();
            localMapper.set(mapper);
        }
        /*
         * 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化 //Include.Include.ALWAYS 默认
		 * //Include.NON_DEFAULT 属性为默认值不序列化 //Include.NON_EMPTY 属性为 空（""） 或者为
		 * NULL 都不序列化 //Include.NON_NULL 属性为NULL 不序列化
		 */
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        localMapper.remove();
        return mapper;
    }
    private static void writeTreeMap(JsonGenerator g, Map<String, ?> map) throws JsonGenerationException, IOException {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = map.get(key);
            if (value instanceof String) {
                g.writeFieldName(key);
                g.writeString((String) value);
            } else if (value instanceof Map) {
                Map<String, ?> subMap = (Map<String, ?>) value;
                g.writeObjectFieldStart(key);
                writeTreeMap(g, subMap);
                g.writeEndObject();
            } else {
                g.writeObjectField(key, value);
            }

        }
    }

    private static String resultObjTojson(List<?> list) {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code", TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            g.writeArrayFieldStart("data");

            for (Object tem : list) {
                if (tem instanceof Map) {
                    g.writeStartObject();// {
                    writeTreeMap(g, (Map) tem);
                    g.writeEndObject();
                } else if (tem instanceof String) {
                    g.writeString((String) tem);
                } else {
                    g.writeObject(tem);
                }
            }

            g.writeEndArray();
            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String resultObjAndStrTojson(String str) {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code",TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            if (str != null) {
                g.writeStringField("data", str);
            }
            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String resultObjTojson() {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code", TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    private static String resultObjTojson(String key, Object value) {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code", TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            g.writeObjectFieldStart("data");
            if (value instanceof String) {
                g.writeFieldName(key);
                g.writeString((String) value);
            } else {
                g.writeObjectField(key, value);
            }
            g.writeEndObject();
            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String resultObjTojson(Object obj) {
        ObjectMapper mapper = getMapper();
        JsonFactory f = mapper.getJsonFactory();
        StringWriter w = new StringWriter();
        JsonGenerator g;
        try {
            g = f.createJsonGenerator(w);
            g.writeStartObject();// {
            g.writeObjectField("code", TpErrorCodeGeneral.RESULT_CODE_OK);
            g.writeStringField("msg", "ok");
            if (obj != null) {
                if (obj instanceof String) {
                    g.writeFieldName("data");
                    g.writeString((String) obj);
                } else {
                    g.writeObjectField("data", obj);
                }
            }

            g.writeEndObject();
            g.close();
            return w.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
