package com.example.mvp.Image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Admin-JYB on 2017/4/14.
 */

public class CircleTransform extends BitmapTransformation {

    public CircleTransform(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circle(pool,toTransform);
    }


    private static Bitmap circle(BitmapPool pool, Bitmap source) {
        if (source == null){
            return null;
        }
        int size = Math.min(source.getWidth(), source.getHeight());
        //矩形长和宽中较小的作为正方形的边长
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        //先转变成正方形
        Bitmap squaredBitmap = pool.get(x,y, Bitmap.Config.ARGB_8888);
        if (squaredBitmap == null){
            squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        }
        Bitmap bitmap = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (bitmap == null){
            bitmap =Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        }
        if (squaredBitmap != source) {
            source.recycle();
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();

        return bitmap;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
