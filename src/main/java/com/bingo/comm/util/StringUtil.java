package com.bingo.comm.util;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil extends StringUtils {
    public static Charset utf8 = Charset.forName("UTF-8");
    public static String LOG_SEPARATOR = "|";
    public static String KEY_SEPARATOR = "_";

    public StringUtil() {
    }

    public static String replacePlaceHolderWithMapValue(String msg, Map<String, Object> errorParam) {
        Pattern placeHolderPattern = Pattern.compile("\\$\\{([\\w\\d]+)\\}");
        Matcher m = placeHolderPattern.matcher(msg);

        HashMap relaceList;
        String placeHolder;
        String errorValue;
        for(relaceList = new HashMap(); m.find(); relaceList.put(placeHolder, errorValue)) {
            placeHolder = m.group(0);
            String key = m.group(1);
            Object value = errorParam.get(key);
            if (value != null) {
                errorValue = value.toString();
            } else {
                errorValue = key;
            }
        }

        Entry keyValue;
        for(Iterator var9 = relaceList.entrySet().iterator(); var9.hasNext(); msg = msg.replace((CharSequence)keyValue.getKey(), (CharSequence)keyValue.getValue())) {
            keyValue = (Entry)var9.next();
        }

        return msg;
    }

    public static String getStringFromDate(Date date, String format) {
        if (date == null) {
            date = new Date();
        }

        String s = "";

        try {
            Locale locale = Locale.CHINESE;
            if (format == null) {
                format = "yyyy年MM月dd日 HH点mm分ss秒";
            }

            DateFormat formatter = new SimpleDateFormat(format, locale);
            s = formatter.format(date);
        } catch (Exception var5) {
            DateFormat f = DateFormat.getDateInstance();
            s = f.format(date);
        }

        return s;
    }

    public static List<String> string2List(String str) {
        return string2List(str, ",");
    }

    public static Set<String> string2Set(String str) {
        Set<String> set = new HashSet();
        set.addAll(string2List(str));
        return set;
    }

    public static List<Integer> intString2List(String str, String separator) {
        List<Integer> list = new ArrayList();
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return list;
        } else {
            String[] strArray = split(str, separator);
            String[] var4 = strArray;
            int var5 = strArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String subStr = var4[var6];
                if (org.apache.commons.lang3.StringUtils.isNotBlank(subStr)) {
                    int num = NumberUtil.toInt(subStr.trim());
                    if (num >= 0) {
                        list.add(num);
                    }
                }
            }

            return list;
        }
    }

    public static List<String> string2List(String str, String separatorChars) {
        List<String> list = new ArrayList();
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return list;
        } else {
            String[] strArray = split(str, separatorChars);
            String[] var4 = strArray;
            int var5 = strArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String subStr = var4[var6];
                if (org.apache.commons.lang3.StringUtils.isNotBlank(subStr.trim())) {
                    list.add(subStr.trim());
                }
            }

            return list;
        }
    }

    public static List<Long> longString2List(String str, String separator) {
        List<Long> list = new ArrayList();
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return list;
        } else {
            String[] strArray = split(str, separator);
            String[] var4 = strArray;
            int var5 = strArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String subStr = var4[var6];
                if (org.apache.commons.lang3.StringUtils.isNotBlank(subStr)) {
                    Long num = NumberUtil.toLong(subStr.trim());
                    if (num.longValue() >= 0L) {
                        list.add(num);
                    }
                }
            }

            return list;
        }
    }

    public static Set<Integer> intString2Set(String intString) {
        Set<Integer> set = new HashSet();
        if (isBlank(intString)) {
            return set;
        } else {
            String[] typeArray = intString.trim().split(",");
            String[] var3 = typeArray;
            int var4 = typeArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String type = var3[var5];
                set.add(Integer.parseInt(type.trim()));
            }

            return set;
        }
    }

    public static Set<Integer> intList2Set(List<Integer> list) {
        Set<Integer> set = new HashSet();
        if (list != null && list.size() != 0) {
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                Integer type = (Integer)var2.next();
                set.add(type);
            }

            return set;
        } else {
            return set;
        }
    }

    public static List<List<String>> queryStringConvertQueryList(String intString) {
        List<List<String>> list = new ArrayList();
        if (isBlank(intString)) {
            return list;
        } else {
            String[] typeArray = intString.trim().split(",");
            String[] var3 = typeArray;
            int var4 = typeArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String type = var3[var5];
                String[] values = type.split("#");
                List<String> typeList = new ArrayList();
                String[] var9 = values;
                int var10 = values.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    String value = var9[var11];
                    typeList.add(value);
                }

                list.add(typeList);
            }

            return list;
        }
    }

    public static List<List<String>> queryStringConvertQueryList(Set<Integer> set) {
        List<List<String>> list = new ArrayList();
        if (set == null) {
            return list;
        } else {
            Iterator var2 = set.iterator();

            while(var2.hasNext()) {
                Integer value = (Integer)var2.next();
                List<String> typeList = new ArrayList();
                typeList.add(String.valueOf(value));
                list.add(typeList);
            }

            return list;
        }
    }

    public static int byteLength(String str) {
        try {
            return str == null ? 0 : str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException("以gbk字符集获取指定字符串长度出错!str=" + str);
        }
    }

    public static String exp2String(Exception e) {
        Writer w = new StringWriter();
        e.printStackTrace(new PrintWriter(w));
        return w.toString();
    }

    public static String removeSupplementaryCharacter(String s) {
        if (isEmpty(s)) {
            return "";
        } else {
            StringBuilder rel = new StringBuilder();

            for(int i = 0; i != s.length(); ++i) {
                if (Character.isSupplementaryCodePoint(s.codePointAt(i))) {
                    ++i;
                } else {
                    rel.append((char)s.codePointAt(i));
                }
            }

            return rel.toString();
        }
    }

    public static String subString(String s, String separator) {
        if (isEmpty(s)) {
            return "";
        } else {
            int begin = s.indexOf(separator);
            int end = -1;
            if (begin >= 0) {
                ++begin;
                end = s.indexOf(separator, begin);
            }

            return end > begin ? s.substring(begin, end) : "";
        }
    }

    public static Map<String, String> urlParameters(String URL) {
        Map<String, String> mapRequest = new LinkedHashMap();
        String[] arrSplit = null;
        String strUrlParam = TruncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        } else {
            arrSplit = strUrlParam.split("[&]");
            String[] var4 = arrSplit;
            int var5 = arrSplit.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String strSplit = var4[var6];
                String[] arrSplitEqual = null;
                int index = strSplit.indexOf("=");
                if (index >= 0) {
                    String key = strSplit.substring(0, index);
                    String value = strSplit.substring(index + 1);
                    arrSplitEqual = strSplit.split("[=]");
                    if (key.length() > 0) {
                        mapRequest.put(key, value);
                    } else {
                        mapRequest.put(key, "");
                    }
                }
            }

            return mapRequest;
        }
    }

    private static String TruncateUrlPage(String strURL) {
        int index = strURL.indexOf("?");
        return index >= 0 ? strURL.substring(index + 1) : null;
    }

    public static String percentEncode(String s, String encoding) {
        if (s == null) {
            return "";
        } else {
            try {
                String url = URLEncoder.encode(s, encoding).replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("%3D", "=").replace("%26", "&").replace("%2F", "/").replace("%3A", ":").replace("%3F", "?").replace("%23", "#").replace("%21", "!");
                return url;
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException(var3.getMessage(), var3);
            }
        }
    }

    public static String collection2String(Collection<?> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                Object object = var2.next();
                builder.append(object);
                builder.append(",");
            }

            return builder.substring(0, builder.length() - 1);
        } else {
            return "";
        }
    }

    public static int lengthUtf8(String str) {
        return isBlank(str) ? 0 : str.getBytes(utf8).length;
    }

    public static List<String> extractTags(String str, String sep) {
        List<String> tags = new ArrayList();
        if (!isBlank(str) && !isBlank(sep)) {
            Pattern pattern = Pattern.compile(sep);
            Matcher match = pattern.matcher(str);
            int cnt = 0;
            int start = 0;
            boolean var7 = false;

            while(match.find()) {
                ++cnt;
                if (cnt == 1) {
                    start = match.end();
                }

                if (cnt == 2) {
                    int end = match.start();
                    tags.add(str.substring(start, end));
                    cnt = 0;
                }
            }

            return tags;
        } else {
            return tags;
        }
    }

    public static String notBlank(String str) {
        if (isBlank(str)) {
            throw new RuntimeException("str here can't be blank");
        } else {
            return str;
        }
    }

    public static String buildLog(Object... args) {
        return join(args, LOG_SEPARATOR);
    }

    public static String joinWithSeparator(String separator, Object... args) {
        return join(Arrays.asList(args), separator);
    }

    public static void main(String[] args) {
        System.out.println(extractTags("#abcdefabc", "#"));
    }
}

