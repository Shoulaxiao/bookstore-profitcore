package com.shoulaxiao.exception;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author shoulaxiao
 * @Date 2021/3/4 10:49
 * @Description TODO
 * @Version 1.0
 **/
public class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static <T extends Throwable> T unwrap(T t) {
        return t instanceof InvocationTargetException ? (T) ((InvocationTargetException)t).getTargetException() : t;
    }
}
