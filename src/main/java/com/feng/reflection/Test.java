package com.feng.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by FQ.CHINA on 2016/3/23.
 */
public class Test {
    public static void main(String args[]){
        //reflect1();
        //reflect2();
        //reflect3();
        reflect4();
    }

    public static  void reflect1(){
        User user = new User();
        String pakName = user.getClass().getPackage().getName();
        String name = user.getClass().getName();
        System.out.println("pagkage:: "+pakName+"  name:: "+name);
    }

    public static void reflect2(){
        String className = "com.feng.reflection.User";
        try {
            Class cls = Class.forName(className);
            String pakName = cls.getPackage().getName();
            String name = cls.getName();
            System.out.println("pagkage:: "+pakName+"  name:: "+name);

        }catch (Exception e){

        }
    }

    public static void reflect3(){
        String className = "com.feng.reflection.User";
        try {
            Class cls = Class.forName(className);



            Method[] methods = cls.getDeclaredMethods();
            if(methods != null){
                for (Method m :methods
                     ) {
                    System.out.println(m.getName());
                }
            }
            System.out.println("****************************");
            Field[] fields = cls.getDeclaredFields();
            for (Field f:fields
                 ) {
                System.out.println(f.getName());
            }


            System.out.println("****************************");

            User user = (User)cls.newInstance();
            user.setAge(20);
            user.setId(1000);
            user.print();

        }catch (Exception e){

        }
    }

    public static void reflect4(){
        String className = "com.feng.reflection.User";
        try {
            Class cls = Class.forName(className);
            Object obj = cls.newInstance();
            Field fName = cls.getDeclaredField("name");
            fName.setAccessible(true);
            fName.set(obj,"测试");
            System.out.println(fName.get(obj).toString());

            Method method = cls.getDeclaredMethod("print");
            method.invoke(obj);

            Method method1 = cls.getMethod("print",String.class,int.class);
            method1.invoke(obj,"晚上是滴是滴",100);
        }catch (Exception e){

        }
    }
}
