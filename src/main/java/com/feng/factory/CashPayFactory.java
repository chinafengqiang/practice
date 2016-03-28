package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 * 具体支付方式工厂(现金支付)
 */
public class CashPayFactory implements PayMethodFactory {
    public AbstrctPay getPayMethod() {
        return new CashMethodPay();
    }
}
