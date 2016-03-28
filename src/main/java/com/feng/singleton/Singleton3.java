package com.feng.singleton;

/**
 * Created by FQ.CHINA on 2016/3/24.
 * 双重校验锁
 * 在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 *
 *  volatile变量自身具有下列特性：
    可见性。对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
    原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性。
 */
public class Singleton3 {
    private volatile static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton3.class){
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;

    }
}
