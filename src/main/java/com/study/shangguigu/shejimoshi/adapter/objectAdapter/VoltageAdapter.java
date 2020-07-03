package com.study.shangguigu.shejimoshi.adapter.objectAdapter;

/**
 * @author lizhenhong
 * @Description: 适配器类
 * @date 2020/6/21 15:17
 */
public class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {

        int dest = 0;
        if (null != voltage220V) {
            //获取220V电压
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器进行转换");
            //处理(转换成5V)
            dest = src / 44;
            System.out.println("对象适配器适配完成，输出电压为：" + dest);
        }

        return dest;
    }
}
