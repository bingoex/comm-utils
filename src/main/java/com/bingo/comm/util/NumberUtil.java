package com.bingo.comm.util;


import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil extends NumberUtils {

    public static long toLong(Long value, long defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        try {
            return value.longValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static boolean compare(Long value1, Long value2) {
        return toLong(value1, 0) == toLong(value2, 0);
    }

    /**
     * 比对两个数字是否相等
     *
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isEquals(Number v1, Number v2) {

        if (null != v1 && null != v2) {
            return v1.equals(v2);
        } else if (null == v1 && null == v2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用逗号（,）分隔的String转化为List<Long>
     *
     * @param str
     * @return
     */
    public static List<Long> string2LongList(String str) {
        String[] strArray = str.split(",");
        List<Long> list = new ArrayList<Long>();
        Long temp = null;
        for (String subStr : strArray) {
            if (StringUtil.isNotBlank(subStr) && (temp = NumberUtils.toLong(subStr.trim())) != null) {
                list.add(temp);
            }
        }
        return list;
    }

    /**
     * 用逗号（,）分隔的String转化为List<Integer>
     *
     * @param str
     * @return
     */
    public static List<Integer> string2IntegerList(String str) {
        String[] strArray = str.split(",");
        List<Integer> list = new ArrayList<Integer>();
        Integer temp = null;
        for (String subStr : strArray) {
            if (StringUtil.isNotBlank(subStr) && (temp = NumberUtils.toInt(subStr.trim())) != null) {
                list.add(Integer.valueOf(temp));
            }
        }
        return list;
    }

    /**
     * 保留n位小数，最多9位
     */
    public static String reserveDecimal(Float f, int n) {
        if (n < 0 || n > 10) {
            return f.toString();
        }
        float mode = 1f;
        for (int i = 0; i != n; i++) {
            mode *= 10;
        }
        return new Float(Math.round(f * mode) / mode).toString();
    }
}
