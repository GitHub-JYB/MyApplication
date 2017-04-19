package com.example.mvp.Base;


/**
 * Created by Admin-JYB on 2017/4/19.
 */

public abstract class BaseActivity extends superActivity implements BaseView{
    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void hideLoading() {

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return checkBackAction() || super.onKeyDown(keyCode, event);
//    }

//    private boolean mFlag = false;
//    private long mTimeout = -1;
//
//    /**
//     * 双击退出
//     * @return
//     */
//    private boolean checkBackAction() {
//        long time = 3000L;//判定时间间隔为3秒
//        boolean flag = mFlag;
//        boolean timeout = (mTimeout == -1 || (System.currentTimeMillis() - mTimeout > time));
//        if (mFlag && (mFlag != flag || timeout)){
//            mTimeout = System.currentTimeMillis();
//            ToastUtil.showShortToast("再点击一次回到桌面 ");
//            return true;
//        }
//        return !mFlag;
//    }
}
