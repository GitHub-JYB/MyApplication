package com.example.admin_jyb.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.admin_jyb.myapplication.Base.ToolBarActivity;
import com.example.admin_jyb.myapplication.Utils.ImageLoader;


public class MainActivity extends ToolBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        ImageLoader.Builder builder = new ImageLoader.Builder();
        builder.with(getApplicationContext()).load("https://www.baidu.com/img/bd_logo1.png").into(imageView);
        new ImageLoader(builder).showImage();
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
