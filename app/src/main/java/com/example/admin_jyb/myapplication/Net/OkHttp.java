package com.example.admin_jyb.myapplication.Net;

import java.io.IOException;
import java.util.HashMap;

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
     * 异步GET
     * @param url
     * @param callback
     */
    public void get(String url, Callback callback){
        Request request = builder.url(url)
                                 .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 异步POST
     * @param url
     * @param map
     * @param callback
     */
    public void post(String url, HashMap<String,String> map,Callback callback){
        FormBody.Builder build = new FormBody.Builder();
        for (String Key : map.keySet()) {
            build.add(Key,map.get(Key));
        }
        FormBody formBody = build.build();
        Request request = builder.url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }
}
