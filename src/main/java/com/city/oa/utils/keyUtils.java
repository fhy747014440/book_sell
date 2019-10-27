package com.city.oa.utils;

import java.util.Random;

public class keyUtils {
    /**
     * 生成主键
     * 格式 时间+随机数
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random();

        //6位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);

    }
}
