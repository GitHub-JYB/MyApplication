package com.example.admin_jyb.myapplication.Show.Bean;

import com.example.admin_jyb.myapplication.Show.ShowContract;
import com.example.mvp.Base.MvpListener;
import com.example.mvp.Net.MyListener;
import com.example.mvp.Net.OkHttp;

import java.util.List;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public class ShowModelImpl implements ShowContract.ShowModel {
    @Override
    public void loadData(String url, final MvpListener<List<ZhiHu.StoriesBean>> listener) {
        OkHttp.getIntance().get(url, ZhiHu.class, new MyListener<ZhiHu>() {
            @Override
            public void onSuccess(ZhiHu result) {
                listener.onSuccess(result.getStories());
            }

            @Override
            public void onErroe(String errorMsg) {
                listener.onError(errorMsg);
            }
        });
    }
}
