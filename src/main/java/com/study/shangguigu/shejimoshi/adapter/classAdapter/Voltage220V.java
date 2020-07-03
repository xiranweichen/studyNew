package com.study.shangguigu.shejimoshi.adapter.classAdapter;

/**
 * @author lizhenhong
 * @Description: 被适配者
 * @date 2020/6/21 15:14
 */
public class Voltage220V {

    /**
     * 做一个方法，声明输出电压 是220V
     * @return
     */
    public int output220V() {
        int src = 220;
        System.out.println("电压是：" + src + "V");
        return src;
    }

}
