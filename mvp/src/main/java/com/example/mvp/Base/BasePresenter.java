package com.example.mvp.Base;

import java.lang.ref.WeakReference;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public class BasePresenter<M,V> {
    protected M mModel;
    protected WeakReference<V> mViewRef;

    protected void onAttach(M model,V view){
        mModel = model;
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView(){
        return isViewAttached() ? mViewRef.get() : null;
    }

    protected boolean isViewAttached(){
        return  mViewRef != null && mViewRef.get() != null;
    }

    protected void onDetach(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
