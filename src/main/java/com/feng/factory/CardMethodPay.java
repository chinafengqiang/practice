package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 * 具体方法
 */
public class CardMethodPay implements AbstrctPay{
    public int pay() {
        System.out.println("******* card pay 卡支付***********");
        return 1;
    }
}
