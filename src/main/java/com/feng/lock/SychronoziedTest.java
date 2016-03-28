package com.feng.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FQ.CHINA on 2016/3/18.
 */
public class SychronoziedTest {

    public static void main(String[] args){
        TicketThread tt = new TicketThread();
        new Thread(tt,"票1").start();
        new Thread(tt,"票2").start();
        new Thread(tt,"票3").start();
        new Thread(tt,"票4").start();
    }

}

class TicketThread implements Runnable{
    private int tickets = 5;
    Lock lock = new ReentrantLock();
    public void run() {
        for(int i = 0; i < 20 ; i++){
            this.sale1();
        }
    }

    private synchronized void sale(){
        if(tickets > 0) {
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
            String name = Thread.currentThread().getName();
            System.out.println(name + "已经售卖了票：：" + tickets--);
        }
    }

    private void sale1(){
        lock.lock();
        try{
            if(tickets > 0) {
                try{
                    Thread.sleep(100);
                }catch (Exception e){

                }
                String name = Thread.currentThread().getName();
                System.out.println(name + "已经售卖了票：：" + tickets--);
            }
        }finally {
            lock.unlock();
        }
    }
}
