package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 * 具体支付方式工厂(卡支付工厂)
 */
public class CardPayFactory implements PayMethodFactory {
    public AbstrctPay getPayMethod() {
        return new CardMethodPay();
    }
}
