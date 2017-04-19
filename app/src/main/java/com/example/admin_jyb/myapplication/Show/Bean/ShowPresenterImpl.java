package com.example.admin_jyb.myapplication.Show.Bean;

import com.example.admin_jyb.myapplication.Show.ShowContract;
import com.example.mvp.Base.MvpListener;

import java.util.List;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public class ShowPresenterImpl extends ShowContract.ShowPresenter{
    @Override
    public void loadData(String url) {
        final ShowContract.ShowView view = getView();
        if (view == null){
            return;
        }
        view.showLoading();
        mModel.loadData(url, new MvpListener<List<ZhiHu.StoriesBean>>() {
            @Override
            public void onSuccess(List<ZhiHu.StoriesBean> result) {
                view.hideLoading();
                view.setData(result);
            }

            @Override
            public void onError(String errorMsg) {
                view.hideLoading();
                view.showError();
            }
        });
    }
}
