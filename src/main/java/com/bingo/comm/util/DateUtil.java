package com.bingo.comm.util;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil extends DateUtils {

    private static final Long ONE_DAY_MSEL = 1000L * 3600 * 24;

    /**
     * 计算前days天或者后days 天
     *
     * @param date
     * @param days 为负数代表 计算前days天
     * @return
     */
    public static Date dateOperation(Date date, int days) {
        return new Date(date.getTime() + ONE_DAY_MSEL * days);
    }

    /**
     * 计算前days天或者后days天的毫秒数
     *
     * @param dateMillis
     * @param days 为负数代表 计算前days天
     * @return
     */
    public static long dateMillisOperation(long dateMillis, int days) {
        return dateMillis + ONE_DAY_MSEL * days;
    }

    /**
     * 比较2个时间是否相等。
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqualsDate(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            return true;
        }
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.getTime() == date2.getTime();
    }

    /**
     * 获取时间的秒数
     *
     * @param day
     * @return
     */
    public static int getDateSeconds(Date day) {
        return (int) (day.getTime() / 1000);
    }

    /**
     * 获取时间的秒数
     *
     * @param time
     * @return
     */
    public static int getDateSeconds(long time) {
        return (int) (time / 1000);
    }

    /**
     * 获取时间的小时数
     *
     * @param day
     * @return
     */
    public static int getDateHours(Date day) {
        return (int) (day.getTime() / 1000 / 3600);
    }

    /**
     * 获取时间的天数
     *
     * @param day
     * @return
     */
    public static int getDateDays(Date day) {
        return getDateHours(day) / 24;
    }

    public static String toString(Date d) {
        if (d == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    }

    public static String toString(long time) {
        if (time <= 0) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    public static Date toDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 比较2个long时间是否是同一天
     *
     * @param ms1
     * @param ms2
     * @return
     */
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < ONE_DAY_MSEL && interval > -1L * ONE_DAY_MSEL && toDay(ms1) == toDay(ms2);
    }

    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / ONE_DAY_MSEL;
    }

    /**
     * 二个日期是否为通一天
     *
     * @param ms1
     * @param ms2
     * @return
     */
    public static boolean isSomeDay(final long ms1, final long ms2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTimeInMillis(ms1);
        c2.setTimeInMillis(ms2);

        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
            return true;
        }
        return false;
    }

    /**
     * 格式化日期（long转为M月d日） 如：04-08返回4月8日，11-11返回11月11日
     *
     * @param ms
     * @return
     */
    public static String formatDate(final long ms) {
        SimpleDateFormat dateformat = new SimpleDateFormat("M月d日");
        return dateformat.format(new Date(ms));
    }

    /**
     * 格式化日期（Date转为M月d日） 如：04-08返回4月8日，11-11返回11月11日
     *
     * @param date
     * @return
     */
    public static String formatDate(final Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("M月d日");
        return dateformat.format(date);
    }

    /**
     * @param date
     * @flag 0 返回当天0点时间<br>
     *       1 返回第二天0点时间
     * @return
     */
    public static Timestamp getZeroClockDate(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int milliSecond = cal.get(Calendar.MILLISECOND);
        long milliSecondPassedOnTheDay = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000 + milliSecond;
        cal.setTimeInMillis(cal.getTimeInMillis() - milliSecondPassedOnTheDay);

        if (flag == 0) {
            return new Timestamp(cal.getTime().getTime());
        }

        cal.setTimeInMillis(cal.getTimeInMillis() + 24 * 60 * 60 * 1000);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Calendar getZeroClockCal(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int milliSecond = cal.get(Calendar.MILLISECOND);
        long milliSecondPassedOnTheDay = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000 + milliSecond;
        cal.setTimeInMillis(cal.getTimeInMillis() - milliSecondPassedOnTheDay);

        if (flag == 0) {
            return cal;
        }

        cal.setTimeInMillis(cal.getTimeInMillis() + 24 * 60 * 60 * 1000);
        return cal;
    }

    /**
     * String的“yyyy-MM-dd：类型转化成Date“Fri Aug 08 00:00:00 CST 2014”
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        Date date = null;
        if (StringUtil.isBlank(str)) {
            return date;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * String的“yyyy-MM-dd：类型转化成Long毫秒
     *
     * @param str
     * @return
     */
    public static Long stringToMillis(String str) {
        Date date = stringToDate(str);
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    /**
     * 返回未来的一个较大Date时间，用于查询未来时间
     *
     * @return
     */
    public static Date getFutureDate() {
        return stringToDate("2030-01-01");
    }

    /**
     * 返回未来的一个较大Long毫秒时间，用于查询未来时间
     *
     * @return
     */
    public static Long getFutureMillis() {
        return getFutureDate().getTime();
    }

    /**
     * 获取当天开始时间，即00:00:00
     */
    public static Date getTodayBeginTime() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTime();
    }


    public static void main(String[] args) {
        Date cur =  getTodayBeginTime();
        System.out.println(toString(cur));
        System.out.println(getDateHours(new Date()));
    }

}
