package com.example.admin_jyb.myapplication;

import android.util.Log;

import com.example.admin_jyb.myapplication.Show.Bean.ShowModelImpl;
import com.example.admin_jyb.myapplication.Show.Bean.ShowPresenterImpl;
import com.example.admin_jyb.myapplication.Show.Bean.ZhiHu;
import com.example.admin_jyb.myapplication.Show.ShowContract;
import com.example.mvp.Base.BaseMvpActivity;
import com.example.mvp.Utils.ToastUtil;

import java.util.List;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public class ShowActivity extends BaseMvpActivity<ShowPresenterImpl,ShowModelImpl> implements ShowContract.ShowView{
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void setData(List<ZhiHu.StoriesBean> list) {
        Log.i("abc", "setData: " + list.get(0).getTitle());
    }

    @Override
    protected void loadData() {
        mPresenter.loadData("http://news-at.zhihu.com/api/4/news/latest");
    }
}
