package com.example.admin_jyb.myapplication;

import android.os.Bundle;

import com.example.admin_jyb.myapplication.Base.ToolBarActivity;


public class MainActivity extends ToolBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setTitle() {
        getToolbar().setTitle("主界面");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
