package com.feng.singleton;

/**
 * Created by FQ.CHINA on 2016/3/24.
 * 静态内部类
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程
 * 这种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。
 *
 */
public class Singleton4 {
    private Singleton4(){}
    private static class SingletonHolder{
        private static final Singleton4 instance = new Singleton4();
    }
    public static final Singleton4 getInstance(){
        return SingletonHolder.instance;
    }
}
