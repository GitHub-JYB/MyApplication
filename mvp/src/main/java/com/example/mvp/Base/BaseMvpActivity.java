package com.example.mvp.Base;

import android.os.Bundle;

import com.example.mvp.Utils.ReflectUtil;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public abstract class BaseMvpActivity<T extends BasePresenter,M extends BaseModel> extends BaseActivity{
    protected T mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = ReflectUtil.getT(this,0);
        mModel = ReflectUtil.getT(this,1);
        mPresenter.onAttach(mModel,this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
