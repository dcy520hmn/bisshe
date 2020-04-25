package com.keji.common.utils;

public class OrderIdUtil {

    public static String getId(){
        String id = DateUtil.dateToString(DateUtil.getCurrentDateTime(),"yyyyMMddHH24mmss");
        System.out.println(id);
        return id;
    }
}
