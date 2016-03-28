package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 *具体方法
 */
public class CashMethodPay implements AbstrctPay{
    public int pay() {
        System.out.println("******* cash pay ***********");
        return 1;
    }
}
