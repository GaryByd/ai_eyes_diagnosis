package com.ljw.constants;

public class Constants {
    public static final String REDIS_TOKEN_KEY = "save:info:by:token";
    public static final String REDIS_TOKEN_ID = "save:token:by:id";
    public static final Integer LENGTH_5 = 5;
    public static final Integer LENGTH_11 = 11;
    public static final Integer LENGTH_21 = 21;

    public static final Integer TIME_ONE_MIN = 60;
    public static final Integer REDIS_TIME_EXPIRE_DAY = TIME_ONE_MIN * 60 * 24;

    public static final String PHONE_VERIFY_CODE = "phone:checked:code";

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";
}
