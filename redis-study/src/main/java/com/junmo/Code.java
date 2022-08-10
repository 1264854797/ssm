package com.junmo;


import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

public class Code {

    /**
     * 1.生成6位数验证码
     *
     * @return
     */
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            //生成10以内的数字
            int ran = random.nextInt(10);
            code += ran;
        }
        return code;
    }

    /**
     * 2.发送
     *
     * @param phone
     */
    public static void lala(String phone) {
        //连接jedis
        Jedis jedis = new Jedis("110.40.211.111", 6379);

        //手机发送次数 key
        String countKey = "VerifyCode" + phone + ":count";
        //验证码 key
        String codeKey = "VerifyCode" + phone + ":code";

        //每个手机每天只能发三次
        String countValue = jedis.get(countKey);
        if (countValue == null) {
            //没有发送次数，第一次发送
            //设置发送次数为1
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(countValue) <= 2) {
            //发送次数加1
            jedis.incr(countKey);
        } else if (Integer.parseInt(countValue) > 2) {
            System.out.println("今天发送次数超过三次");
            jedis.close();
        }
        //发送验证码到redis中
        String code = getCode();
        jedis.setex(codeKey, 120, code);

    }

    /**
     * 3.验证
     *
     * @param phone
     * @param code
     */
    public static void getRedisCode(String phone, String code) {
        //连接jedis
        Jedis jedis = new Jedis("110.40.211.111", 6379);
        //获取验证码
        String codeKey = "VerifyCode" + phone + ":code";
        //获取验证码
        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        jedis.close();
    }

    public static void main(String[] args) {
        lala("13393459481");

    }


}
