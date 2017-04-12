package com.example.admin_jyb.myapplication.Base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class superActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
    }

    protected abstract int getContentViewId();


}
