package com.study.shangguigu.basic.usualClass.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @description: jdk8 关于时间的操作
 * @date: 2020/3/7 17:56
 * @author: lizhenhong
 */
public class JDK8DateTest {

    @Test
    public void LocalNowTest() {
        //now():获取当前的日期、时间、日期+时间
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("=======>当前日期：" + date); //=======>当前日期：2020-03-07
        System.out.println("=========>当前时间：" + time); //=========>当前时间：19:17:56.884
        System.out.println("=========>当前日期+时间：" + dateTime);//=========>当前日期+时间：2020-03-07T19:17:56.884
        
        //of():设定指定的年月日时分秒，不存在时间的偏移量
        LocalDateTime dateTime1 = LocalDateTime.of(2020, 3, 7, 19, 30, 22);
        System.out.println("======>用of()设置的日期+时间" + dateTime1);//======>用of()设置的日期+时间2020-03-07T19:30:22
        
        //getXxx():获取一些属性值的方法   (不只是下面的这些，还有很多getXxx方法)（今天是2020-03-07）
        System.out.println(dateTime.getDayOfMonth()); //7
        System.out.println(dateTime.getDayOfWeek());  //SATURDAY
        System.out.println(dateTime.getMonth());      //MARCH
        System.out.println(dateTime.getMonthValue()); //3
        System.out.println(dateTime.getMinute());     //39
        
        //withXxx():设置相关属性
        // 不可变性
        LocalDate date1 = date.withDayOfMonth(22);
        System.out.println("===>date.withDayOfMonth(22)中date的值：" + date); //===>date.withDayOfMonth(22)中date的值：2020-03-07
        System.out.println("===>返回值date1的值：" + date1);     //===>返回值date1的值：2020-03-22
        
        //plusXxx()：加一定的时间（不可变性）
        LocalDateTime dateTime2 = dateTime.plusDays(3);
        System.out.println("dateTime.plusDays(3)中dateTime的值：" + dateTime);//dateTime.plusDays(3)中dateTime的值：2020-03-07T19:58:41.206
        System.out.println("返回的dateTime2的值：" + dateTime2);  //返回的dateTime2的值：2020-03-10T19:58:41.206
        
        //minusXxx():减一定的时间（也具有不可变性）
        LocalDateTime dateTime3 = dateTime.minusDays(3);
        System.out.println("dateTime.minusDays(3)中dateTime的值：" + dateTime);//dateTime.minusDays(3)中dateTime的值：2020-03-07T19:58:41.206
        System.out.println("返回的dateTime3的值是：" + dateTime3); //返回的dateTime3的值是：2020-03-04T19:58:41.206
    }
    
}
