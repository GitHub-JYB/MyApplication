package com.example.admin_jyb.myapplication.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Admin-JYB on 2017/4/14.
 */

public class ImageLoader {

    private Context context;
    private String url;
    private ImageView imageView;

    public ImageLoader(Builder builder){
        this.context = builder.context;
        this.url = builder.url;
        this.imageView = builder.imageView;
    }

    public void showImage(){
        Glide.with(context).load(url).into(imageView);
    }


    public static class Builder{
        private Context context;
        private String url;
        private ImageView imageView;

        public Builder with(Context context){
            this.context = context;
            return this;
        }

        public Builder load(String url){
            this.url = url;
            return this;
        }

        public Builder into(ImageView imageView){
            this.imageView = imageView;
            return this;
        }
    }
}
