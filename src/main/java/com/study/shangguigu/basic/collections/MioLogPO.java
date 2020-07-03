package com.study.shangguigu.basic.collections;

import java.io.Serializable;

/**
 * @description: 根据list的对象中的某个属性实现倒叙desc排序(从大到小)的PO
 * @date: 2020/5/29 15:55
 * @author: lizhenhong
 */
public class MioLogPO implements Serializable, Comparable<MioLogPO> {

    private static final long serialVersionUID = -419334373707249551L;
    private String id;
    private String mioDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMioDate() {
        return mioDate;
    }

    public void setMioDate(String mioDate) {
        this.mioDate = mioDate;
    }


    @Override
    public String toString() {
        return "MioLogPO{" +
                "id='" + id + '\'' +
                ", mioDate='" + mioDate + '\'' +
                '}';
    }


    @Override
    public int compareTo(MioLogPO o) {

        if (this.mioDate.compareTo(o.mioDate) > 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
