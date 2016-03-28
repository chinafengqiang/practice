package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/23.
 */
public class PayMethodFactoryUtil {

    private static PayMethodFactory factory;

    private PayMethodFactoryUtil(){
    }

    public static PayMethodFactory getInstance(){
        if(factory == null){
            try {
                String packageName = PayMethodFactoryUtil.class.getPackage().getName();
                factory = (PayMethodFactory)Class.forName(packageName+"."+Config.PAY_METHOD).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return factory;
    }
}
