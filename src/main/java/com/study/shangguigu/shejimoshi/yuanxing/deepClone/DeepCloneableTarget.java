package com.study.shangguigu.shejimoshi.yuanxing.deepClone;

import java.io.Serializable;

/**
 * @description: 实现深克隆(复制整个对象 ， 而不仅限于基本数据类型的属性)
 * @date: 2020/6/9 19:29
 * @author: lizhenhong
 */
public class DeepCloneableTarget implements Serializable, Cloneable {

    private static final long serialVersionUID = -7425325276161298933L;

    private String cloneName;
    private String cloneClass;

    //由于属性都是String，因此用默认的clone方法完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }

    @Override
    public String toString() {
        return "DeepCloneableTarget{" +
                "cloneName='" + cloneName + '\'' +
                ", cloneClass='" + cloneClass + '\'' +
                '}';
    }
}
