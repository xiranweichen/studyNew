package com.study.shangguigu.shejimoshi.adapter.classAdapter;

/**
 * @author lizhenhong
 * @Description: 适配器类
 * @date 2020/6/21 15:17
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {

        //获取220V电压
        int src = output220V();
        //处理(转换成5V)
        int dest = src / 44;

        return dest;
    }
}
