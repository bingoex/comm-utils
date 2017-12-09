package com.bingo.comm.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.bingo.comm.util.StringUtil;
import org.apache.commons.collections.MapUtils;


public class FeaturesUtil extends MapUtils {

    static final TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {
    };

    public static String getString(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        return JSON.parseObject(features).getString(key);
    }

    public static Long getLong(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        return JSON.parseObject(features).getLong(key);
    }

    public static long getLongValue(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return 0;
        }
        return JSON.parseObject(features).getLongValue(key);
    }

    public static Integer getInteger(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        return JSON.parseObject(features).getInteger(key);
    }

    public static int getIntValue(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return 0;
        }
        return JSON.parseObject(features).getIntValue(key);
    }

    public static Boolean getBoolean(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        return JSON.parseObject(features).getBoolean(key);
    }

    public static boolean getBooleanValue(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return false;
        }
        return JSON.parseObject(features).getBooleanValue(key);
    }

    public static List<String> getList(String features, String key) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        String value = JSON.parseObject(features).getString(key);
        return JSON.parseArray(value, String.class);
    }

    public static List<String> getList(Map<String, Object> features, String key) {
        if (features == null || !features.containsKey(key)) {
            return null;
        }
        return (List<String>)features.get(key);
    }

    public static Map<String, String> parseMap(String features) {
        if (StringUtil.isBlank(features)) {
            return null;
        }
        return JSON.parseObject(features, typeReference);
    }

}
