package com.example.mvp.Net;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Admin-JYB on 2017/4/12.
 */

public class OkHttp {

    private static volatile OkHttp okHttp;
    private static Gson gson = new Gson();
    private static OkHttpClient client = new OkHttpClient();
    private static Request.Builder builder = new Request.Builder();

    private OkHttp(){

    }

    /**
     * 单例双重检查
     * @return
     */
    public static OkHttp getIntance(){
        if (okHttp == null){
            synchronized (OkHttp.class){
                if (okHttp == null){
                    okHttp = new OkHttp();
                }
            }
        }
        return okHttp;
    }

    /**
     * 同步GET
     * @param url
     * @return
     * @throws IOException
     */
    public String get(String url) throws IOException {
        Request request = builder.url(url)
                                 .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()){
            return response.body().string();
        }
        return null;
    }

    /**
     * 异步GET获取字符串
     * @param url
     * @param
     */
    public void get(String url, final MyListener<String> myListener){
        Request request = builder.url(url)
                                 .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myListener.onErroe(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    myListener.onSuccess(response.body().string());
                }
            }
        });
    }/**
     * 异步GET获取javabean
     * @param url
     * @param
     */
    public <T> void get(String url, final Class<T> clazz, final MyListener<T> myListener){
        Request request = builder.url(url)
                                 .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myListener.onErroe(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    myListener.onSuccess( gson.fromJson(response.body().string(),clazz));
                }
            }
        });
    }

    /**
     * 异步POST获取字符串
     * @param url
     * @param map
     * @param
     */
    public void post(String url, HashMap<String,String> map, final MyListener<String> myListener){
        FormBody.Builder build = new FormBody.Builder();
        for (String Key : map.keySet()) {
            build.add(Key,map.get(Key));
        }
        FormBody formBody = build.build();
        Request request = builder.url(url).post(formBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myListener.onErroe(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    myListener.onSuccess(response.body().string());
                }
            }
        });
    } /**
     * 异步POST获取javajbean
     * @param url
     * @param map
     * @param
     */
    public <T> void post(String url, HashMap<String,String> map, final Class<T> clazz, final MyListener<T> myListener){
        FormBody.Builder build = new FormBody.Builder();
        for (String Key : map.keySet()) {
            build.add(Key,map.get(Key));
        }
        FormBody formBody = build.build();
        Request request = builder.url(url).post(formBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myListener.onErroe(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    myListener.onSuccess(gson.fromJson(response.body().string(),clazz));
                }
            }
        });
    }
}
