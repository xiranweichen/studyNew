package com.study.shangguigu.shejimoshi.yuanxing.deepClone;

import java.io.*;

/**
 * @description: 既有基本数据类型，也有引用类型
 * @date: 2020/6/9 19:37
 * @author: lizhenhong
 */
public class DeepProtoType implements Serializable, Cloneable {

    private static final long serialVersionUID = -155014499208192813L;

    private String name;
    private DeepCloneableTarget deepCloneableTarget; //引用类型

    //深拷贝，方式一：使用重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();  //先用原始的clone方法完成对基本數據類型和字符串的clone
        //对引用类型的属性进行单独的处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //深拷贝，方式二：通过对象的序列化实现(推荐使用)
    public Object deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        DeepProtoType copy = null;
        //序列化
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //把当前对象以对象流的方式输出
            oos.writeObject(this);
            
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            copy = (DeepProtoType) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copy;

    }

    public DeepProtoType() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneableTarget getDeepCloneableTarget() {
        return deepCloneableTarget;
    }

    public void setDeepCloneableTarget(DeepCloneableTarget deepCloneableTarget) {
        this.deepCloneableTarget = deepCloneableTarget;
    }


    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", deepCloneableTarget=" + deepCloneableTarget +
                '}';
    }
}
