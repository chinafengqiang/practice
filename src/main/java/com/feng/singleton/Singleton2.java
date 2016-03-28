package com.feng.singleton;

/**
 * Created by FQ.CHINA on 2016/3/24.
 *  饿汉
 *  这种方式基于classloder机制避免了多线程的同步问题，不过instance在类装载时就实例化，
 *  这时候初始化instance显然没有达到lazy loading的效果
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}
