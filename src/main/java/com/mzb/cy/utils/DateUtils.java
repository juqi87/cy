package com.mzb.cy.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class DateUtils {

    public static final String DASH = "-";
    public static final String COLON = ":";
    public static final String BLANK = " ";


    //============================0.获取当前时间====================================

    /**
     * 获取当前日期类型时间
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 获取当前时间戳
     */
    public static long getNowTimestamp() {
        return getNow().getTime();
    }

    /**
     * 获取当前日期 yyyyMMdd
     */
    public static String getCurrentDate() {
        return toMailDateDtPartString(getNow());
    }

    /**
     * 获取当期时间HHmmss
     * @return
     */
    public static String getCurrentTime() {
        return toMailTimeTmPartString(getNow());
    }

    /**
     * 获取当期时间MM月dd日HH:mm
     * @return
     */
    public static String getCurrentMmDdHmTime() {
        return toMailDtmPart(getNow());
    }

    /**
     * 获取当前日期和时间yyyyMMddHHmmss
     * @return
     */
    public static String getCurrentDateTime() {
        return toMailDateString(getNow());
    }

    //============================1.Date2String=====================================

    /**
     * 将一个日期型转换为指定格式字串
     * @param aDate
     * @param formatStr
     * @return
     */
    public static final String toFormatDateString(Date aDate, String formatStr) {
        if (aDate == null)
            return StringUtils.EMPTY;
        Assert.hasText(formatStr);
        return new SimpleDateFormat(formatStr).format(aDate);

    }

    /**
     * 将一个日期型转换为'yyyy-MM-dd'格式字串 
     * @param aDate
     * @return
     */
    public static final String toShortDateString(Date aDate) {
        return toFormatDateString(aDate, SHORT_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMdd'格式字串
     * @param aDate
     * @return
     */
    public static final String toMailDateDtPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_DT_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'HHmmss'格式字串
     * @param aDate
     * @return
     */
    public static final String toMailTimeTmPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_TIME_TM_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMddHHmmss'格式字串
     * @param aDate
     * @return
     */
    public static final String toMailDateString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_FORMAT);
    }

    /**
     * 
     */
    /**
     * 将一个日期型转换为MM月dd日HH:mm格式字串
     * @param aDate
     * @return
     */
    public static final String toMailDtmPart(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATA_DTM_PART_FORMAT);
    }

    /**
     * 
     */
    /**
     * 将一个日期型转换为yyyy.MM.dd格式字串
     * @param aDate
     * @return
     */
    public static final String toPointDtmPart(Date aDate) {
        return toFormatDateString(aDate, POINT_DATA_DTM_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy-MM-dd HH:mm:ss'格式字串
     * @param aDate
     * @return
     */
    public static final String toLongDateString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'HH:mm:ss'格式字串
     * @param aDate
     * @return
     */
    public static final String toLongDateTmPartString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_TM_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日'格式字串
     * @param aDate
     * @return
     */
    public static final String toShortDateGBKString(Date aDate) {
        return toFormatDateString(aDate, SHORT_DATE_GBK_FORMAT);
    }
    
    /**
     * 将一个日期型转换为'MM-dd HH:mm'格式字串
     * @param aDate
     * @return
     */
    public static final String parseDateExcluedYear(Date aDate) {
    	return toFormatDateString(aDate, DATE_FORMAT_EXCLUD_YEAR);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分'格式字串
     * @param aDate
     * @return
     */
    public static final String toDateGBKString(Date aDate) {
        return toFormatDateString(aDate, DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分ss秒'格式字串
     * @param aDate
     * @return
     */
    public static final String toLongDateGBKString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'HH时mm分ss秒'格式字串
     * @param aDate
     * @return
     */
    public static final String toLongDateTmPartGBKString(Date aDate) {
        return toFormatDateString(aDate, Long_DATE_TM_PART_GBK_FORMAT);
    }

    /** 
     * 将一个日期型转换为'yyyy-MM-dd HH:mm:ss:SSS'格式字串
     * @param aDate
     * @return
     */
    public static final String toFullDateString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分ss秒SSS毫秒'格式字串
     * @param aDate
     * @return
     */
    public static final String toFullDateGBKString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMddHHmmssSSS'格式字串
     * @param aDate
     * @return
     */
    public static final String toFullDateCompactString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_COMPACT_FORMAT);
    }

    /**
     * 将一个日期型转换为LDAP格式字串
     * @param aDate
     * @return
     */
    public static final String toLDAPDateString(Date aDate) {
        return toFormatDateString(aDate, LDAP_DATE_FORMAT);
    }

    //============================2.String2Date=====================================    

    /**
     * 将一个符合指定格式的字串解析成日期型
     * @param aDateStr
     * @param formatter
     * @return
     * @throws ParseException 
     */
    public static final Date parser(String aDateStr, String formatter) throws ParseException {
        if (StringUtils.isBlank(aDateStr))
            return null;
        Assert.hasText(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        sdf.setLenient(false);
        return sdf.parse(aDateStr);
    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     * 
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);
    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     * 
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateDtPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);
    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     * 
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateTmPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);
    }

    /**
     * 将一个符合'yyyy-MM-dd'格式的字串解析成日期型
     * @param aDateStr
     * @return
     */
    public static final Date parseShortDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, SHORT_DATE_FORMAT);
    }

    /**
     * 将一个符合'yyyyMMddHHmmss'格式的字串解析成日期型
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_DATE_FORMAT);
    }

    /**
     * 将一个符合'yyyyMMdd'格式的字串解析成日期型
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateDtPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_DATE_DT_PART_FORMAT);
    }

    /**
     * 将一个符合'HHmmss'格式的字串解析成日期型
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateTmPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_TIME_TM_PART_FORMAT);
    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss:SSS'格式的字串解析成日期型
     * @param strDate
     * @return
     */
    public static final Date parseFullDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyy-MM-dd'、'yyyy-MM-dd HH:mm:ss'或'EEE MMM dd HH:mm:ss zzz yyyy'格式的字串解析成日期型，
     * 如果为blank则返回空，如果不为blank又不符合格式则报错
     * @param aDateStr
     * @return
     */
    public static Date parseDateString(String aDateStr) {
        Date ret = null;
        if (StringUtils.isNotBlank(aDateStr)) {
            try {
                if (isLongDateStr(aDateStr)) {
                    ret = DateUtils.parseLongDateString(aDateStr);
                } else if (isShortDateStr(aDateStr)) {
                    ret = DateUtils.parseShortDateString(aDateStr);
                } else if (isDateStrMatched(aDateStr, DateUtils.DEFAULT_DATE_FORMAT)) {
                    ret = DateUtils.parser(aDateStr, DateUtils.DEFAULT_DATE_FORMAT);
                } else {
                    throw new IllegalArgumentException("date format mismatch");
                }
            } catch (ParseException e) {
                //不可能到这里
            }
        }
        return ret;
    }

    //============================3.String2String===================================== 

    /**
     * 转换日期格式 yyyy-MM-dd => yyyyMMdd
     * @param dt yyyy-MM-dd
     * @return yyyyMMdd
     */
    public static String transfer2ShortDate(String dt) {
        if (StringUtils.isBlank(dt) || dt.length() != 10) {
            return dt;
        }
        Assert.notNull(dt);
        String[] tmp = StringUtils.split(dt, DASH);
        Assert.isTrue(tmp != null && tmp.length == 3);
        return tmp[0].concat(StringUtils.leftPad(tmp[1], 2, "0")).concat(
            StringUtils.leftPad(tmp[2], 2, "0"));
    }

    /**
     * 转换日期格式 yyyyMMdd => yyyy-MM-dd
     * @param dt yyyyMMdd
     * @return yyyy-MM-dd
     */
    public static String transfer2LongDateDtPart(String dt) {
        if (StringUtils.isBlank(dt)) {
            return " ";
        }
        if (dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return dt.substring(0, 4).concat(DASH).concat(dt.substring(4, 6))
            .concat(DASH).concat(dt.substring(6));
    }

    /**
     * 转换日期格式 HHmmss => HH:mm:ss
     * @param tm HHmmss
     * @return HH:mm:ss
     */
    public static String transfer2LongDateTmPart(String tm) {
        if (StringUtils.isBlank(tm) || tm.length() != 6) {
            return tm;
        }
        Assert.notNull(tm);
        Assert.isTrue(tm.length() == 6);
        return tm.substring(0, 2).concat(COLON).concat(tm.substring(2, 4))
            .concat(COLON).concat(tm.substring(4));
    }
    
    /**
     * 转换起始时段 HHmmHHmm  => HH:mm - HH:mm
     * @param tm  HHMMHHMM 起始时段
     * @return HH:mm - HH:mm
     */
    public static String transferTmInterval2LongDateTmPart(String tm) {
        if (StringUtils.isBlank(tm) || tm.length() != 8) {
            return tm;
        }
        Assert.notNull(tm);
        Assert.isTrue(tm.length() == 8);
        return tm.substring(0, 2).concat(COLON).concat(tm.substring(2, 4))
                .concat(" - ").concat(tm.substring(4, 6))
                .concat(COLON).concat(tm.substring(6, 8));
    }

    /**
     * 转换日期格式 yyyyMMdd => yyyy年MM月dd日
     * @param dt yyyyMMdd
     * @return yyyy年MM月dd日
     */
    public static String transfer2LongDateGbkDtPart(String dt) {
        if (StringUtils.isBlank(dt) || dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return dt.substring(0, 4).concat("年").concat(dt.substring(4, 6)).concat("月")
            .concat(dt.substring(6)).concat("日");
    }
    
    /**
     *  转换日期格式 yyyyMMdd => MM月dd日
     * @param dt yyyyMMdd
     * @return  MM月dd日  12月21日 1月8日
     */
    public static String transfer2LongDateGbkMonthAndDay(String dt) {
        if (StringUtils.isBlank(dt) || dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return (String.valueOf(Integer.parseInt(dt.substring(4, 6)))).concat("月")
            .concat(String.valueOf(Integer.parseInt(dt.substring(6)))).concat("日");
    }
    
    /**
     * 转换日期格式 yyyyMMdd => MM-dd
     * @param dt yyyyMMdd
     * @return MM-dd   10-22
     */
    public static String transfer2ShortMonthAndDay(String dt) {
        if (StringUtils.isBlank(dt) || dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return dt.substring(4, 6).concat("-")
            .concat(dt.substring(6));
    }
    
    /**
     * 转换日期格式HHmmss => HH时mm分ss秒
     * @param tm HHmmss
     * @return HH时mm分ss秒
     */
    public static String transfer2LongDateGbkTmPart(String tm) {
        if (StringUtils.isBlank(tm) || tm.length() != 6) {
            return tm;
        }
        Assert.notNull(tm);
        Assert.isTrue(tm.length() == 6);
        return tm.substring(0, 2).concat("时").concat(tm.substring(2, 4)).concat("分")
            .concat(tm.substring(4)).concat("秒");
    }
    
    /**
     * 
     * @param dateTime yyyyMMddhhmmss
     * @return yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String transfer2LongDateGbkDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return " ";
        }
        if (dateTime.length() != 14) {
            return dateTime;
        }
        return transfer2LongDateGbkDtPart(dateTime.substring(0, 8)).concat(BLANK).concat(
            transfer2LongDateGbkTmPart(dateTime.substring(8)));
    }

    /**
     * 转换日期格式为yyyy-MM-dd hh:mm:ss
     * 
     * @param date yyyyMMdd
     * @param time hhmmss
     * @return
     */
    public static String transfer2FullDateStyle(String date, String time) {
        return transfer2LongDateDtPart(date).concat(BLANK).concat(
            transfer2LongDateTmPart(time));
    }
    
    /**
     * 转换日期格式为yyyy-MM-dd hh:mm:ss
     * 
     * @param dateTime yyyyMMddhhmmss
     * @return
     */
    public static String transfer2FullDateStyle(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return " ";
        }
        if (dateTime.length() != 14) {
            return dateTime;
        }
        return transfer2FullDateStyle(dateTime.substring(0, 8), dateTime.substring(8));
    }

    //============================4.时间加减=====================================    

    /**
     * 为一个日期加上指定年数
     * @param aDate
     * @param amount 年数
     * @return
     */
    public static final Date addYears(Date aDate, int amount) {
        return addTime(aDate, Calendar.YEAR, amount);
    }

    /**
     * 为一个日期加上指定月数
     * @param aDate
     * @param amount 月数
     * @return
     */
    public static final Date addMonths(Date aDate, int amount) {
        return addTime(aDate, Calendar.MONTH, amount);
    }

    /**
     * 为一个日期加上指定天数
     * @param aDate
     * @param amount 天数
     * @return
     */
    public static final Date addDays(Date aDate, int amount) {
        return addTime(aDate, Calendar.DAY_OF_YEAR, amount);
    }

    /**
     * 为一个日期加上指定天数
     * @param aDate yyyyMMdd格式字串
     * @param amount 天数
     * @return
     */
    public static final String addDays(String aDate, int amount) {
        try {
            return DateUtils.toMailDateDtPartString(addTime(
                DateUtils.parseMailDateDtPartString(aDate), Calendar.DAY_OF_YEAR, amount));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 为一个日期加上指定小时数
     * @param aDate 
     * @param amount 小时数
     * @return
     */
    public static final Date addHours(Date aDate, int amount) {
        return addTime(aDate, Calendar.HOUR, amount);

    }

    /**
     * 为一个日期加上指定分钟数
     * @param aDate
     * @param amount 分钟数
     * @return
     */
    public static final Date addMinutes(Date aDate, int amount) {
        return addTime(aDate, Calendar.MINUTE, amount);
    }

    /**
     * 为一个日期加上指定分钟数
     * @param aDateTime yyyyMMddHHmmss
     * @param amount 分钟数
     * @return
     */
    public static final String addMinutes(String aDateTime, int amount) throws ParseException {
        Date date = parser(aDateTime, "yyyyMMddHHmmss");
        Date amoutDate = addTime(date, Calendar.MINUTE, amount);
        return toMailDateString(amoutDate);
    }

    /**
     * 为一个日期加上指定秒数 
     * @param aDate
     * @param amount 秒数
     * @return
     */
    public static final Date addSeconds(Date aDate, int amount) {
        return addTime(aDate, Calendar.SECOND, amount);

    }

    private static final Date addTime(Date aDate, int timeType, int amount) {
        if (aDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        cal.add(timeType, amount);
        return cal.getTime();
    }

    /**
     * 得到当前日期的前一天(昨天)
     * 
     * @return
     */
    public static String getYesterday() {
        return getYesterday(DateUtils.getCurrentDate());
    }

    /**
     * 得到指定日期的前一天
     * 
     * @param currentDay
     * @return
     */
    public static String getYesterday(String currentDay) {
        return getNDaysAgo(currentDay, 1);
    }

    /**
     * 得到指定日期的前几天
     * 前2天的话使用： getNDaysAgo(#{day}, 2);
     * 
     * @param theDay
     * @param nDays
     * @return
     */
    public static String getNDaysAgo(String theDay, int nDays) {
        return DateUtils.addDays(theDay, -nDays);
    }

    /**
     * 得到当前日期的前几天
     * 前2天的话使用： getNDaysAgo(2);
     * 
     * @param nDays
     * @return
     */
    public static String getNDaysAgo(int nDays) {
        return getNDaysAgo(DateUtils.getCurrentDate(), nDays);
    }

    //======================================5.时间国际化=================================

    /**
     * 得到当前时间的UTC时间
     * @return
     */
    public static final String getUTCTime() {
        return getSpecifiedZoneTime(Calendar.getInstance().getTime(), TimeZone.getTimeZone("GMT+0"));
    }

    /**
     * 得到指定时间的UTC时间
     * @param aDate 时间戳
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String getUTCTime(Date aDate) {
        return getSpecifiedZoneTime(aDate, TimeZone.getTimeZone("GMT+0"));
    }

    /**
     * 得到当前时间的指定时区的时间
     * @param tz
     * @return
     */
    public static final String getSpecifiedZoneTime(TimeZone tz) {
        return getSpecifiedZoneTime(Calendar.getInstance().getTime(), tz);

    }

    /**
     * 得到指定时间的指定时区的时间
     * 
     * @param aDate 时间戳,Date是一个瞬间的long型距离历年的位移偏量，
     * 在不同的指定的Locale/TimeZone的jvm中，它toString成不同的显示值，
     * 所以没有必要为它再指定一个TimeZone变量表示获取它时的jvm的TimeZone
     * 
     * @param tz 要转换成timezone
     * 
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String getSpecifiedZoneTime(Date aDate, TimeZone tz) {
        if (aDate == null)
            return StringUtils.EMPTY;
        Assert.notNull(tz);
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
        sdf.setTimeZone(tz);
        return sdf.format(aDate);
    }

    //==================================6. miscellaneous==========================

    /**
     * 计算两个日期之间相差的月数
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int getDifferenceMonths(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        return Math.abs((startCal.get(Calendar.YEAR) - endCal.get(Calendar.YEAR)) * 12
                        + (startCal.get(Calendar.MONTH) - endCal.get(Calendar.MONTH)));
    }

    /**
     * 计算两个日期之间相差的月数
     * @param startDateStr   yyyy-mm-dd
     * @param endDateStr  yyyy-mm-dd
     * @return
     */
    public static final int getDifferenceMonths(String startDateStr, String endDateStr) {
        checkShortDateStr(startDateStr);
        checkShortDateStr(endDateStr);
        try {
            return getDifferenceMonths(parseShortDateString(startDateStr),
                parseShortDateString(endDateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的天数
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr yyyy-mm-dd
     * @return
     */
    public static final int getDifferenceDays(String startDateStr, String endDateStr) {
        return new Long(getDifferenceMillis(startDateStr, endDateStr) / (NANO_ONE_DAY)).intValue();
    }

    /**
     * 计算两个日期之间相差的天数
     * @param startDateStr yyyymmdd
     * @param endDateStr yyyymmdd
     * @return
     */
    public static final int getDifferenceDays2(String startDateStr, String endDateStr) {
        return new Long(getDifferenceMillis(startDateStr, endDateStr, MAIL_DATE_DT_PART_FORMAT)
                        / (NANO_ONE_DAY)).intValue();
    }

    /* ------- start ------------ */
    /**
     * 两个日期之间相减（存在负数）
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr yyyy-mm-dd
     * @return
     */
    public static final int getDaysSubtract(String startDateStr, String endDateStr) {
        return new Long(getDaysSubtractMillis(startDateStr, endDateStr) / (NANO_ONE_DAY))
            .intValue();
    }

    /**
     * 两个日期之间相减（存在负数）
     * @param startDateStr yyyymmdd
     * @param endDateStr yyyymmdd
     * @return
     */
    public static final int getDaysSubtract2(String startDateStr, String endDateStr) {
        return new Long(getDaysSubtractMillis(startDateStr, endDateStr, MAIL_DATE_DT_PART_FORMAT)
                        / (NANO_ONE_DAY)).intValue();
    }

    /**
     * 两个日期之间相减（存在负数）
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr yyyy-mm-dd
     * @return
     * @throws ParseException
     */
    public static final long getDaysSubtractMillis(String startDateStr, String endDateStr) {
        return getDaysSubtractMillis(startDateStr, endDateStr, SHORT_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数（存在负数）
     * @param startDateStr
     * @param endDateStr
     * @param dateFormat
     * @return
     */
    public static final long getDaysSubtractMillis(String startDateStr, String endDateStr,
                                                   String dateFormat) {
        try {
            return getDaysSubtractMillis(parser(startDateStr, dateFormat),
                parser(endDateStr, dateFormat));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的的毫秒数（存在负数）
     * @param startDate
     * @param endDate
     * @return
     */
    public static final long getDaysSubtractMillis(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return endDate.getTime() - startDate.getTime();
    }

    /**
     * 计算两个日期之间相差的的秒数（存在负数）
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int getDaysSubtractSeconds(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return new Long((endDate.getTime() - startDate.getTime()) / (NANO_ONE_SECOND)).intValue();
    }

    /* ------- end ------------ */

    /**
     * 计算两个日期之间相差的天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int getDifferenceDays(Date startDate, Date endDate) {
        return new Long(getDifferenceMillis(startDate, endDate) / (NANO_ONE_DAY)).intValue();

    }

    /**
     * 计算两个日期之间相差的的毫秒数
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr yyyy-mm-dd
     * @return
     * @throws ParseException
     */
    public static final long getDifferenceMillis(String startDateStr, String endDateStr) {
        return getDifferenceMillis(startDateStr, endDateStr, SHORT_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     * @param startDateStr yyyyMMddHHmmss
     * @param endDateStr yyyyMMddHHmmss
     * @return
     * @throws ParseException
     */
    public static final long getDifferenceMillis2(String startDateStr, String endDateStr) {
        return getDifferenceMillis(startDateStr, endDateStr, MAIL_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     * @param startDateStr
     * @param endDateStr
     * @param dateFormat
     * @return
     */
    public static final long getDifferenceMillis(String startDateStr, String endDateStr,
                                                 String dateFormat) {
        try {
            return getDifferenceMillis(parser(startDateStr, dateFormat),
                parser(endDateStr, dateFormat));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     * @param startDate
     * @param endDate
     * @return
     */
    public static final long getDifferenceMillis(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return Math.abs(endDate.getTime() - startDate.getTime());
    }

    /**
     * 检验 日期是否在指定区间内，如果格式错误，返回false
     * 
     * 如果maxDateStr或minDateStr为空则比较时变为正负无穷大，如果都为空，则返回false
     * 
     * @param aDate 
     * @param minDateStr 必须是yyyy-MM-dd格式，时分秒为00:00:00
     * @param maxDateStr 必须是yyyy-MM-dd格式，时分秒为00:00:00
     * @return
     */
    public static final boolean isDateBetween(Date aDate, String minDateStr, String maxDateStr) {
        Assert.notNull(aDate);
        boolean ret = false;
        try {
            Date dMaxDate = null;
            Date dMinDate = null;
            dMaxDate = DateUtils.parseShortDateString(maxDateStr);
            dMinDate = DateUtils.parseShortDateString(minDateStr);
            switch ((dMaxDate != null ? 5 : 3) + (dMinDate != null ? 1 : 0)) {
                case 6:
                    ret = aDate.before(dMaxDate) && aDate.after(dMinDate);
                    break;
                case 5:
                    ret = aDate.before(dMaxDate);
                    break;
                case 4:
                    ret = aDate.after(dMinDate);
            }
        } catch (ParseException e) {
        }
        return ret;
    }

    /**
     * 计算某日期所在月份的天数
     * @param aDateStr yyyy-mm-dd
     * @return 
     */
    public static final int getDaysInMonth(String aDateStr) {
        checkShortDateStr(aDateStr);
        try {
            return getDaysInMonth(parseShortDateString(aDateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算某日期所在月份的天数
     * @param aDate
     * @return
     */
    public static final int getDaysInMonth(Date aDate) {
        Assert.notNull(aDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    //======================================7.时间格式的判断=================================
    /**
     * 判断字串是否符合yyyy-MM-dd格式
     * @param str
     * @return
     */
    public static final boolean isShortDateStr(String aDateStr) {
        try {
            DateUtils.parseShortDateString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 检查字串是否符合yyyy-MM-dd格式
     * @param number
     */
    public static final void checkShortDateStr(String aDateStr) {
        Assert.isTrue(isShortDateStr(aDateStr), "The str-'" + aDateStr
                                                + "' must match 'yyyy-MM-dd' format.");
    }

    /**
     * 判断字串是否符合yyyy-MM-dd HH:mm:ss格式
     * @param str
     * @return
     */
    public static final boolean isLongDateStr(String aDateStr) {
        try {
            DateUtils.parseLongDateString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 检查字串是否符合yyyy-MM-dd HH:mm:ss格式
     * @param str
     */
    public static final void checkLongDateStr(String aDateStr) {
        Assert.isTrue(isLongDateStr(aDateStr), "The str-'" + aDateStr
                                               + "' must match 'yyyy-MM-dd HH:mm:ss' format.");
    }

    /**
     * 判断字串是否符合yyyyMMddHHmmss格式
     * @param str
     * @return
     */
    public static final boolean isMailDateStr(String aDateStr) {
        try {
            DateUtils.parseMailDateString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断字串是否符合yyyyMMdd格式
     * @param str
     * @return
     */
    public static final boolean isMailDateDtPartStr(String aDateStr) {
        try {
            DateUtils.parseMailDateDtPartString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 检查字串是否符合yyyyMMddHHmmss格式
     * @param str
     */
    public static final void checkMailDateStr(String aDateStr) {
        Assert.isTrue(isMailDateStr(aDateStr), "The str-'" + aDateStr
                                               + "' must match 'yyyyMMddHHmmss' format.");
    }

    /**
     * 判断字串是否符合指定的日期格式
     * @param str
     * @return
     */
    public static final boolean isDateStrMatched(String aDateStr, String formatter) {
        try {
            DateUtils.parser(aDateStr, formatter);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    //==================================8. 获取一些指定的日期==========================
   
    public static Date getFirstDayOfLastWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEDNESDAY, -1);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        return calendar.getTime();
    }
    
    public static Date getFirstDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
    
    /**
     * 获取上周第一天：按西方标准星期天为一周之首
     * @return
     */
    public static String getFirstDayOfLastWeekFormatShortDate() {
        return toFormatDateString(getFirstDayOfLastWeek(), MAIL_DATE_DT_PART_FORMAT);
    }
    
    public static void main(String[] args) {
        System.out.println(getFirstDayOfLastWeekFormatShortDate());
    }
    
    /**
     * 获取上个月第一天
     * @return yyyyMMdd
     */
    public static String getFirstDayOfLastMonthFormatShortDate() {
        return DateUtils.toFormatDateString(getFirstDayOfLastMonth(), MAIL_DATE_DT_PART_FORMAT);
    }
    
    public static Date getLastDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }
    
    /**
     * 获取某段时间内的周一（二等等）的日期
     * @param dataBegin 开始日期(yyyyMMdd)
     * @param dataEnd 结束日期(yyyyMMdd)
     * @param weekDays 获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<String> getDayOfWeekWithinDate(String dataBegin, String dataEnd, int weekDays) {
        return getDayOfWeekWithinDateInterval(transfer2LongDateDtPart(dataBegin), transfer2LongDateDtPart(dataEnd), weekDays);
    }
  
    /**
     * 获取某段时间内的周一（二等等）的日期
     * @param dataBegin 开始日期(yyyy-MM-dd)
     * @param dataEnd 结束日期(yyyy-MM-dd)
     * @param weekDays 获取周几，1－6代表周一到周六。0代表周日
     * @return 返回日期List
     */
    public static List<String> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
        if(StringUtils.isBlank(dataBegin) || StringUtils.isBlank(dataEnd) || weekDays < 0 || weekDays > 6){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateResult = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        String[] dateInterval = {dataBegin, dataEnd};
        Date[] dates = new Date[dateInterval.length];
        for (int i = 0; i < dateInterval.length; i++) {
            String[] ymd = dateInterval[i].split("[^\\d]+");
            cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
            dates[i] = cal.getTime();
        }
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
            cal.setTime(date);
            if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
                String format = sdf.format(date);
                dateResult.add(transfer2ShortDate(format));
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }
        return dateResult;
    }

    public static Date stringToDate(String date,String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 计算两个字符串日期的时间差yyyyMMddHHmmss,返回毫秒值
     * @param start 开始日期
     * @param end   结束日期
     * @return
     */
    public static Long getSubTime(String start, String end) {
        Date s = stringToDate(start,MAIL_DATE_FORMAT);
        Date e = stringToDate(end,MAIL_DATE_FORMAT);
        return e.getTime()-s.getTime();
    }
    
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SHORT_DATE_GBK_FORMAT = "yyyy年MM月dd日";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_EXCLUD_YEAR = "MM-dd HH:mm";
    public static final String DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分";
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String LONG_DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String MAIL_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String MAIL_DATE_HHMM_FORMAT = "HH:mm";
    public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String FULL_DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
    public static final String FULL_DATE_COMPACT_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String LDAP_DATE_FORMAT = "yyyyMMddHHmm'Z'";
    public static final String US_LOCALE_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static final String MAIL_DATE_DT_PART_FORMAT = "yyyyMMdd";
    public static final String MAIL_TIME_TM_PART_FORMAT = "HHmmss";
    public static final String LONG_DATE_TM_PART_FORMAT = "HH:mm:ss";
    public static final String Long_DATE_TM_PART_GBK_FORMAT = "HH时mm分ss秒";
    public static final String MAIL_DATA_DTM_PART_FORMAT = "MM月dd日HH:mm";
    public static final String POINT_DATA_DTM_PART_FORMAT = "yyyy.MM.dd";

    public static final String DEFAULT_DATE_FORMAT = US_LOCALE_DATE_FORMAT;

    public static long NANO_ONE_SECOND = 1000;
    public static long NANO_ONE_MINUTE = 60 * NANO_ONE_SECOND;
    public static long NANO_ONE_HOUR = 60 * NANO_ONE_MINUTE;
    public static long NANO_ONE_DAY = 24 * NANO_ONE_HOUR;

    private DateUtils() {
    }
}
