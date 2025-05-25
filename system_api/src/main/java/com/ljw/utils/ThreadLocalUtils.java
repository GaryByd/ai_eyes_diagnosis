package com.ljw.utils;

import java.util.Objects;

/**
 * DATE: 2025/3/25
 * Author: lizhiyu
 */
public class ThreadLocalUtils {

    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<Object>();

    /**
     * 设置当前线程的变量值
     * @param value 要存储的值（泛型支持任意类型）
     */
    public static <T> void set(T value) {
        Objects.requireNonNull(value, "ThreadLocal value cannot be null");
        THREAD_LOCAL.set(value);
    }

    /**
     * 获取当前线程的变量值
     * @param clazz 值的类型 Class 对象（用于类型安全转换）
     * @return 当前线程的变量值
     */
    public static <T> T get(Class<T> clazz) {
        Object value = THREAD_LOCAL.get();
        if (value == null) return null;
        return clazz.cast(value);
    }

    /**
     * 移除当前线程的变量值（防止内存泄漏）
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
