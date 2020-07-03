package com.study.shangguigu.shejimoshi.adapter.classAdapter;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/21 15:28
 */
public class Phone {

    /**
     * 充电方法
     * @param voltage5V
     */
    public void chaming(Voltage5V voltage5V) {
        if (voltage5V.output5V() == 5) {
            System.out.println("电压是5V，可以充电了");
        } else if (voltage5V.output5V() > 5) {
            System.out.println("电压过高，不能充电");
        }
    }

}
