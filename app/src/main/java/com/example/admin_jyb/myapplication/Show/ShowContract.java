package com.example.admin_jyb.myapplication.Show;

import com.example.admin_jyb.myapplication.Show.Bean.ZhiHu;
import com.example.mvp.Base.BaseModel;
import com.example.mvp.Base.BasePresenter;
import com.example.mvp.Base.BaseView;
import com.example.mvp.Base.MvpListener;

import java.util.List;

/**
 * Created by Admin-JYB on 2017/4/19.
 */

public interface ShowContract {
    interface ShowModel extends BaseModel{
        void loadData(String url, MvpListener<List<ZhiHu.StoriesBean>> listener);
    }

    interface ShowView extends BaseView{
        void setData(List<ZhiHu.StoriesBean> list);
    }

    abstract class ShowPresenter extends BasePresenter<ShowModel,ShowView>{
        protected abstract void loadData(String url);
    }
}
