package com.java8newfeatures.code;

import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * java8新日期api
 * @author wj
 *
 *日期相关类LocalDate、LocalTime、LocalDateTime
 * 时间戳Instant
 * 计算时间间隔Duration
 * 计算日期间隔Period
 * 日期操作TemporalAdjuster，TemporalAdjusters提供大量实现
 * 日期的解析和格式化DateTimeFormatter
 * 带时区的日期ZonedDate,ZonedTime,ZonedDateTime,ZoneId类包含了所有时区的定义
 */
public class NewDateApi {

    @Test
    public void testZonedDateTime(){
        Set<String> zones=ZoneId.getAvailableZoneIds();
        zones.forEach(System.out::println);
        ZonedDateTime znow=ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(znow);
        ZonedDateTime zcn=ZonedDateTime.now(ZoneId.of("Asia/Hong_Kong"));
        System.out.println(zcn);
    }

    @Test
    public void testFormatter(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(now));
        String dateStr="2018-08-22 14:20:20";
        System.out.println(LocalDateTime.parse(dateStr,formatter));
    }

    @Test
    public void testLocalDate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.withHour(1));
        System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));

        LocalDateTime time = LocalDateTime.of(2018, 8, 22, 10, 30, 10);
        System.out.println(time);

        LocalDate date = LocalDate.of(2018, 8, 22);
        LocalDate date1 = LocalDate.now();
        Period pd=Period.between(date,date1);
        System.out.println(pd.getDays());
        System.out.println(Period.between(date1,date));
    }

    @Test
    public void testInstant() throws InterruptedException {
        Instant now=Instant.now();
        System.out.println(now);
        System.out.println(now.getNano());
        System.out.println(now.toEpochMilli());
        System.out.println(now.getEpochSecond());

        Thread.sleep(500);

        Instant end=Instant.now();
        System.out.println(Duration.between(now,end));

    }

}
