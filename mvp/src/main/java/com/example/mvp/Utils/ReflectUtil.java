package com.example.mvp.Utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public class ReflectUtil {
    public static <T> T getT(Object o,int i){
        try {
            return ((Class<T>)((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
