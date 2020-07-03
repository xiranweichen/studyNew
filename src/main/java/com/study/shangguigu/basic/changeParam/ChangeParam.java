package com.study.shangguigu.basic.changeParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lizhenhong
 * @description: 可变个数的形参方法
 * @date: 2020/1/4 12:39
 */
public class ChangeParam {

    /**
     * 下面的main方法都是调的同一个方法，但是入参不同
     */
    public static void main(String[] args) {
        changeParam("1");
        changeParam("1","2","3");
        changeParam("1","2","3","4");
        changeParam("1","2","3","4","5");
        changeParam("1","2","3","4","5","6");
    }

    private static void changeParam(String ... strings) {
        List<String> strList = new ArrayList<>();
        for (String string : strings) {
            strList.add(string);
        }
        System.out.println("===========>调用方法的形参列表是：string... strings,入参:" + strList);
    }

}
