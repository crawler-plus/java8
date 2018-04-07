package it4u.site;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * LocalDate LocalTime LocalDateTime
 */
public class TestLocalDateTime {

    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 指定年月日时分秒
        LocalDateTime dateTime = LocalDateTime.of(2018, 1, 1, 14, 23, 44);
        System.out.println(dateTime);
        LocalDateTime plus = dateTime.plusYears(2);// 加两年
        System.out.println(plus);
        LocalDateTime plusMonth = dateTime.minusMonths(10);// 减10个月
        System.out.println(plusMonth);
        System.out.println(dateTime.getYear()); // 得到年
        System.out.println(dateTime.getMonthValue()); // 得到月
        System.out.println(dateTime.getDayOfMonth()); // 得到日
        System.out.println(dateTime.getHour()); // 得到小时
        System.out.println(dateTime.getMinute()); // 得到分钟
        System.out.println(dateTime.getSecond()); // 得到秒
    }

    /**
     * Instant 时间戳
     */
    @Test
    public void test2() {
        Instant instant = Instant.now(); // 默认获取的是UTC 时区
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8)); // 带时差偏移量运算
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli()); // 得到毫秒时间戳
        Instant instant1 = Instant.ofEpochSecond(60);
        System.out.println(instant1);
    }

    /**
     * Duration 计算两个时间之间的间隔
     */
    @Test
    public void test3() {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Instant ins2 = Instant.now();
        Duration between = Duration.between(ins1, ins2);
        System.out.println(between.getSeconds()); // 获取间隔的秒
        System.out.println(between.toMillis()); // 获取间隔的毫秒

        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        LocalTime localTime1 = LocalTime.now();
        Duration between1 = Duration.between(localTime, localTime1);
        System.out.println(between1);
    }

    /**
     * Period 计算两个日期之间的间隔
     */
    @Test
    public void test4() {
        LocalDate localDate = LocalDate.of(2015, 1, 1);
        LocalDate localDate1 = LocalDate.now();
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

    /**
     * TemporalAdjuster: 时间校正器
     */
    @Test
    public void test5() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10); // 指定成某一个时间
        System.out.println(localDateTime1);
        LocalDateTime lo = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));// 指定为下一个周日
        System.out.println(lo);
        // 自定义： 下一个工作日
        LocalDateTime ldt5 = localDateTime.with((l) -> {
            LocalDateTime ldt = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();// 获取周几
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            }
            if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    /**
     * DateTimeFormatter 格式化时间/日期
     */
    @Test
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = ldt.format(dtf);
        System.out.println(format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format1 = dateTimeFormatter.format(ldt);
        System.out.println(format1); // 格式化成字符串
        LocalDateTime parse = ldt.parse(format1, dateTimeFormatter);
        System.out.println(parse);
    }

    /**
     * 时区的
     */
    @Test
    public void test7() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test8() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Chungking"));
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ldt2.atZone(ZoneId.of("Asia/Chungking"));
        System.out.println(zonedDateTime);
    }
}
