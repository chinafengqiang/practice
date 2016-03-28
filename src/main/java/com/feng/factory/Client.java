package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 */
public class Client {
    public static void main(String[] args){
       // PayMethodFactory factory = PayMethodFactoryUtil.getInstance();
        //PayMethodFactory factory = PayMethodFactoryEnum.PayMethodFactory.getInstance();
        PayMethodFactory factory = PayMethodFactoryUtil1.getInstance();
        AbstrctPay pay = factory.getPayMethod();
        pay.pay();
    }
}
