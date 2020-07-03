package com.study.tencent.thread;

import org.junit.Test;

/**
 * @description: 锁的粗化和消除
 * @date: 2020/5/30 15:09
 * @author: lizhenhong
 */
public class LockCuhuaAndXiaochu {

    private static Object object;
    
    /**
     * 粗化
     */
    @Test
    public void testCuHua() {
        StringBuffer sb = new StringBuffer();
//        synchronized (object) {
//            sb.append("1");
//        }
//        synchronized (object) {
//            sb.append("2");
//        }
//        synchronized (object) {
//            sb.append("3");
//        }
//        synchronized (object) {
//            sb.append("4");
//        }
        //上面的每一步操作实际上都会加一个锁，但是这些锁经过jvm锁的粗化，会等效于下列的形式
        synchronized (object) {
            sb.append("1");
            sb.append("2");
            sb.append("3");
            sb.append("4");
        }
    }

    /**
     * 消除
     */
    public void testXiaoChu() {
        //jvm的优化，jvm不会对同步块进行加锁，因为访问该方法的其他线程不能看到该线程的信息
        synchronized (new Object()) {
            //伪代码：很多逻辑
            //jvm是否加锁
            //jvm会进行逃逸分析
        }
    }

}
