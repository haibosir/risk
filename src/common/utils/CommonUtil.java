package com.cpiaoju.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class CommonUtil {
    /**
     * 生成时间戳
     */
    public static String getDateTime() {
        //LocalDate now = LocalDate.now();
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        return second.toString();
    }
    /**
     * 判断字符串是否为空 true不为空 false为空
     *
     * @param params
     * @return
     */
    public static boolean IsNotNull(String params) {
        if (params == null || params.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 判断对象是否为空 true是空 false 不为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }
        return false;
    }
}
