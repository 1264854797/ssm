package com.junmo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class Study {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("110.40.211.111",6379);
        System.out.println(jedis.toString());
    }

    /**
     * String
     */
    @Test
    public void demo1(){
        Jedis jedis=new Jedis("110.40.211.111",6379);
        //新增
        jedis.set("name","xiaoming");
        //获取
        jedis.get("name");
        Set<String> set=jedis.keys("*");
        for(String lala:set){
            System.out.println(lala);
        }
    }
    /**
     * List
     */
    @Test
    public void demo2(){
        Jedis jedis=new Jedis("110.40.211.111",6379);
        jedis.lpush("user","1","2","3");
        List<String> list=jedis.lrange("user",0,-1);
        System.out.println(list);

    }

    /**
     * Set
     */
    @Test
    public void demo3(){
        Jedis jedis=new Jedis("110.40.211.111",6379);
        jedis.sadd("name","123","456");
        Set<String> set=jedis.smembers("name");
        System.out.println(set);

    }
    /**
     * hash
     */
    @Test
    public void demo4(){
        Jedis jedis=new Jedis("110.40.211.111",6379);
        jedis.hset("student","xiaomign","男");
        jedis.hset("student","xiaohong","女");
        jedis.hset("student","xiaomi","男");
        String sex=jedis.hget("student","xiaohong");
        System.out.println(sex);

    }

    /**
     * zset
     */
    @Test
    public void demo5(){
        Jedis jedis=new Jedis("110.40.211.111",6379);
        jedis.zadd("china",100d,"上海");
        Set<String> chain=jedis.zrange("china",0,-1);
        System.out.println(chain);

    }
}
