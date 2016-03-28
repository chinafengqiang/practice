package com.feng.factory;

/**
 * Created by FQ.CHINA on 2016/3/25.
 */
public class PayMethodFactoryUtil1 {
    private static class UtilsHolder{
        private static  PayMethodFactory factory = null;
        private static  String pakageName = "";
        static {
            try {
                pakageName = PayMethodFactoryUtil1.class.getPackage().getName();
                factory = (PayMethodFactory) Class.forName(pakageName+"." + Config.PAY_METHOD).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private PayMethodFactoryUtil1(){}

    public static final PayMethodFactory getInstance(){
        return UtilsHolder.factory;
    }
}
