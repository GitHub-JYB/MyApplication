package com.example.mvp.Net;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public interface MyListener<T> {
    void onSuccess(T result);
    void onErroe(String errorMsg);
}
