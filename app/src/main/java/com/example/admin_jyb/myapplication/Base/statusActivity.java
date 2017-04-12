package com.example.admin_jyb.myapplication.Base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.admin_jyb.myapplication.R;

/**
 * Created by Admin-JYB on 2017/4/11.
 */

public abstract class statusActivity extends superActivity{

    private View statusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStatusColor(this,getResources().getColor(R.color.colorPrimary));
    }

    protected void setStatusColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //生成一个状态栏大小的矩形

            //添加statusView到布局中
            ViewGroup decorView = (ViewGroup)activity.getWindow().getDecorView();
            if (statusView != null){
                decorView.removeView(statusView);
            }

            statusView = createStatusView(activity,color);
            decorView.addView(statusView);
            //设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * 生成一个状态栏大小的矩形
     *
     * @param activity 需要设置的activity
     * @param color 状态条颜色
     * @return 矩形状态条
     */
    private View createStatusView(Activity activity, int color) {
        //获得状态栏的高度
        int resourcedId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusHeight = activity.getResources().getDimensionPixelSize(resourcedId);
        //绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }

    /**
     * 提供remove方法，在不需要状态栏时可以移除
     */
    public void removeView(Activity activity){
        ViewGroup decorView = (ViewGroup)activity.getWindow().getDecorView();
        if (statusView != null){
            decorView.removeView(statusView);
        }
    }
}
