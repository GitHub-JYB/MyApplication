package com.example.admin_jyb.myapplication.Utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by Admin-JYB on 2017/4/14.
 */

/**
 * 改变图片质量
 */
public class GlideConfiguration implements GlideModule{
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //改变图片质量
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
