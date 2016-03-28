package com.feng.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by FQ.CHINA on 2016/3/18.
 */
public class CacheTest {
    public static void main(String[] args){
        CacheThread ct = new CacheThread();
        new Thread(ct).start();
        new Thread(ct).start();
        new Thread(ct).start();
    }
}

class CacheReduce {

    private static Map<String,Object> cache = new HashMap<String, Object>();
    private static ReadWriteLock rwl = new ReentrantReadWriteLock();

    public static Object getValue(String key){
        Object value = null;
        rwl.readLock().lock();
        try {
            if(cache == null || cache.size() == 0){
                rwl.readLock().unlock();
                //rwl.writeLock().lock();
                try {
                    if(cache == null || cache.size() == 0){
                        setMap();
                    }
                }finally {
                   // rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
            value = cache.get(key);
        }finally {
            rwl.readLock().unlock();
        }

        return value;
    }


    public static void setMap(){
        for(int i = 0;i<1000;i++){
            cache.put(i+"",i);
        }
    }


}

class CacheThread implements Runnable{
    public void run() {
        for(int n = 0;n < 20 ; n++){
            Object res = CacheReduce.getValue(n+"");
            System.out.println(n+" :: "+res);
        }
    }
}