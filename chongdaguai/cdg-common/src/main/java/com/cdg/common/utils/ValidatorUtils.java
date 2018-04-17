/*
 * Copyright (C) 2016-2020 jindan.com Corporation
 *
 */
package com.cdg.common.utils;

import java.util.List;

/**
 * 通用类: 校验处理通用
 *
 * @author jinhongfei
 */
public class ValidatorUtils {

    /**
     * null字符串
     */
    private static final String STRING_NULL = "null";

    /**
     * 默认构造方法.
     */
    private ValidatorUtils() {
        // do nothing.
    }

    /**
     * 判断对象是否为Null
     *
     * @param obj 对象
     * @return true:空字符串 false:非空字符串
     */
    public static boolean isNull(Object obj) {
        return (obj == null);
    }

    /**
     * 判断对象是否为Null
     *
     * @param list 列表对象
     * @return true:空字符串 false:非空字符串
     */
    public static boolean isListNull(List list) {
        if (isNull(list)
                || (list.size() == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否为空字符串
     *
     * @param str source string.
     * @return is empty.
     */
    public static boolean isEmpty(String str) {
        String trim = str;
        if (null != str) {
            trim = str.trim();
        }
        if (trim == null || trim.length() == 0 || trim == STRING_NULL) {
            return true;
        }
        return false;
    }

    /**
     * 判读位数
     *
     * @param str source string.
     * @return is empty.
     */
    public static boolean validateLen(String str, int len) {
        if (isEmpty(str)) {
            return false;
        }
        if (str.length() >= len) {
            return true;
        } else {
            return false;
        }
    }
}
