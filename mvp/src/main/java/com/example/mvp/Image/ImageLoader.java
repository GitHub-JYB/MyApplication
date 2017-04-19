package com.example.mvp.Image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Admin-JYB on 2017/4/14.
 */

public class ImageLoader {

    private Context context;
    private String url;
    private ImageView imageView;
    private RequestListener<String, GlideDrawable> requestListener;

    public ImageLoader(Builder builder){
        this.context = builder.context;
        this.url = builder.url;
        this.imageView = builder.imageView;
    }

    public void showImage(){
        requestListener = new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        };
        Glide.with(context)
             .load(url)
             .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸又缓存其他尺寸
//             .error(R.drawable.switch_background)//错误图片
//             .placeholder(R.drawable.slide_button_background)//占位图片，照片为空时显示
//             .centerCrop()//填充方式
//             .override(100,100)//改变大小
//             .skipMemoryCache(true)//跳过图片缓存
//             .priority(Priority.NORMAL)//设置下载优先级
//             .animate(R.anim.image_alpha)//动画
//             .crossFade(3000)//淡入，时间3秒，默认300毫秒
//             .dontAnimate()//没有淡入效果
//             .thumbnail(0.1f)//先加载缩略图，再加载全图
             .listener(requestListener) //设置监听
//             .transform(new CircleTransform(context))//转化为原形图片
             .into(imageView);
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
