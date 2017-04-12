package com.example.admin_jyb.myapplication.Base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.admin_jyb.myapplication.R;

/**
 * Created by Admin-JYB on 2017/4/11.
 */

public abstract class ToolBarActivity extends statusActivity{

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null){
            //将toolbar显示到界面
            setTitle();
            setSupportActionBar(mToolbar);
        }
    }

    protected abstract void setTitle();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getToolbar() != null && isShowBacking()){
            //默认显示左上角的图标
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    /**
     * 是否显示后退按键，默认显示，可在子类重写该方法
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }

    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }





}
