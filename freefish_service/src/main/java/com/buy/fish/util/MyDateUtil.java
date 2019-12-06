package com.buy.fish.util;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {
    private static final Logger logger = LoggerFactory.getLogger(MyDateUtil.class);

    public static String DATETIME_FORMATE_STR = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMATE_STR = "yyyy-MM-dd";
    public static String DATETIME_FORMATE_PLAIN_STR = "yyyyMMddHHmmss";

    /**
     * 当天的Date格式化字符串
     */
    public static String getCurrDateStr() {
        DateTime dateTime = new DateTime();
        return dateTime.toString(DATE_FORMATE_STR);
    }

    /**
     * 与当天相差plusDays的日期的DateTime字符串
     */
    public static String getBeforeDateStr(Integer beforeDays) {
        DateTime dateTime = new DateTime();
        return dateTime.plusDays(-beforeDays).toString(DATE_FORMATE_STR);
    }

    /**
     * 当前时间的DateTime格式化字符串
     */
    public static String getCurrDateTimeStr() {
        DateTime dateTime = new DateTime();
        return dateTime.toString(DATETIME_FORMATE_STR);
    }

    /**
     * 当天的Date yyyy-MM-dd 00:00:00
     */
    public static Date getCurrDateTime(boolean isBeginningOfDay) {
        DateTime dateTime = new DateTime();
        if (isBeginningOfDay) {
            dateTime = dateTime.withTime(0, 0, 0, 0);
        } else {
            dateTime = dateTime.withTime(23, 59, 59, 0);
        }
        return dateTime.toDate();
    }

    /**
     * 当天的Date
     */
    public static Date getCurrDate() {
        DateTime dateTime = new DateTime();

        return dateTime.toDate();
    }

    /**
     * 当天的DateTime格式化字符串
     *
     * @param isBeginningOfDay true yyyy-MM-dd 00:00:00
     *                         false yyyy-MM-dd 23:59:59
     */
    public static String getCurrDateTimeStr(boolean isBeginningOfDay) {
        return formatDateTime(getCurrDateTime(isBeginningOfDay));
    }

    /**
     * 当前时间的DateTime
     *
     * @param isBeginningOfDay : true yyyy-MM-dd 00:00:00
     *                         false yyyy-MM-dd 23:59:59
     */
    public static Date getBeforeDateTime(Integer beforeDays, boolean isBeginningOfDay) {
        DateTime dateTime = new DateTime();
        if (isBeginningOfDay) {
            dateTime = dateTime.withTime(0, 0, 0, 0);
        } else {
            dateTime = dateTime.withTime(23, 59, 59, 0);
        }
        return dateTime.plusDays(-beforeDays).toDate();
    }

    /**
     * 当前时间的DateTime格式化字符串
     *
     * @param isBeginningOfDay : true yyyy-MM-dd 00:00:00
     *                         false yyyy-MM-dd 23:59:59
     */
    public static String getBeforeDateTimeStr(Integer beforeDays, boolean isBeginningOfDay) {
        return formatDateTime(getBeforeDateTime(beforeDays, isBeginningOfDay));
    }

    /**
     * 将Date对象日期时间序列化输出
     */
    public static String formatDateTime(Date date) {
        SimpleDateFormat DATETIME_FORMATTER = new SimpleDateFormat(DATETIME_FORMATE_STR);
        return DATETIME_FORMATTER.format(date);
    }

    /**
     * 将Date对象日期序列化输出
     */
    public static String formatDate(Date date) {
        SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMATE_STR);
        return DATE_FORMATTER.format(date);
    }

    /**
     * 将Date对象日期时间序列化输出(无连接符合)
     */
    public static String formatPlainDateTime(Date date) {
        SimpleDateFormat DATETIME_PLAIN_FORMATTER = new SimpleDateFormat(DATETIME_FORMATE_PLAIN_STR);
        return DATETIME_PLAIN_FORMATTER.format(date);
    }

    /**
     * 将日期时间字符串转换成Date对象
     */
    public static Date parseDateTime(String dateTimeStr) {
        Date date = null;
        try {
            SimpleDateFormat DATETIME_FORMATTER = new SimpleDateFormat(DATETIME_FORMATE_STR);
            date = DATETIME_FORMATTER.parse(dateTimeStr);
        } catch (Exception ex) {
            logger.info("parseDateTime方法未能解析出Date对象!");
        }
        return date;
    }

    /**
     * 将日期时间字符串转换成Date对象
     */
    public static Date parseDate(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMATE_STR);
            date = DATE_FORMATTER.parse(dateStr);
        } catch (Exception ex) {
            logger.info("parseDate方法未能解析出Date对象！");
        }
        return date;
    }

    /**
     * 对Date或DateTime字符串转换
     */
    public static Date parseDateOrDateTime(String str) {
        Date date = parseDateTime(str);
        return date != null ? date : parseDate(str);
    }

    /**
     * 将Date的Time部分设置为00:00:00或23:59:59
     *
     * @param date
     * @param isBegin
     * @return
     */
    public static Date transDateToBeginOrEnd(Date date, boolean isBegin) {
        if (date == null) {
            return date;
        }
        DateTime dateTime = new DateTime(date);
        if (isBegin) {
            dateTime = dateTime.withTime(0, 0, 0, 0);
        } else {
            dateTime = dateTime.withTime(23, 59, 59, 0);
        }
        return dateTime.toDate();
    }

}
