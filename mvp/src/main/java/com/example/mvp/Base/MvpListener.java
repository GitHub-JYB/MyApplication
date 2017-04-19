package com.example.mvp.Base;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public interface MvpListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}
