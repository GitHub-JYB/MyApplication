package com.example.admin_jyb.myapplication.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.admin_jyb.myapplication.R;


/**
 * Created by Admin-JYB on 2017/4/13.
 */

/**
 * 自定义滑动开关
 */
public class SwitchButton extends View {

    private Bitmap mBgBitmap;//按钮的背景图片
    private Bitmap mSildeBitmap;//按钮的滑动图片
    private boolean isChecked = false;//开关状态
    private boolean isTouching = false;//滑动状态
    private boolean isclick = false;//点击状态
    private int mSbImageOffset ;//滑动的偏移量
    private int mDown;//按下的x值

    public SwitchButton(Context context) {
        super(context);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        int bgResouce = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto",
//                "sb_bg_image", R.drawable.switch_background);
//        setBgBitmapResource(bgResouce);//初始化背景图片
//
//        int imageResouce = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto",
//                "sb_slide_image",R.drawable.slide_button_background);
//        setSlideBitmapResource(imageResouce);
//
//        //取布尔值
//        isChecked=attrs.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto",
//                "is_checked", false);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SwitchButton);
        Drawable bgbitmap = typedArray.getDrawable(R.styleable.SwitchButton_sb_bg_image);
        if (bgbitmap != null){
            mBgBitmap = ((BitmapDrawable)bgbitmap).getBitmap();
        }else {
            setBgBitmapResource(R.drawable.switch_background);
        }
        Drawable slidebitmap = typedArray.getDrawable(R.styleable.SwitchButton_sb_slide_image);
        if (slidebitmap != null){
            mSildeBitmap = ((BitmapDrawable)slidebitmap).getBitmap();
        }else {
            setSlideBitmapResource(R.drawable.slide_button_background);
        }
        isChecked = typedArray.getBoolean(R.styleable.SwitchButton_is_checked, false);
        mSbImageOffset = isChecked ? mBgBitmap.getWidth() - mSildeBitmap.getWidth(): 0;
        typedArray.recycle();
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //背景图片的宽高
        setMeasuredDimension(mBgBitmap.getWidth(),mBgBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画背景图片
        canvas.drawBitmap(mBgBitmap,0,0,null);
        if (isTouching){
            canvas.drawBitmap(mSildeBitmap,mSbImageOffset,0,null);
        }else if (isChecked){
            canvas.drawBitmap(mSildeBitmap,mBgBitmap.getWidth() - mSildeBitmap.getWidth(),0,null);
        }else {
            canvas.drawBitmap(mSildeBitmap,0,0,null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://按下
                mDown = (int) event.getX();
                isTouching = true;
                isclick = true;
                break;
            case MotionEvent.ACTION_MOVE:
                isclick = false;
                int moveX = (int) event.getX();//移动后的x值
                int dx = moveX - mDown;
                mSbImageOffset += dx;
                if (mSbImageOffset < 0){//左边界
                    mSbImageOffset = 0;
                }else if (mSbImageOffset > mBgBitmap.getWidth() - mSildeBitmap.getWidth()){
                    //右边界
                    mSbImageOffset = mBgBitmap.getWidth() - mSildeBitmap.getWidth();
                }
                mDown = moveX;
                invalidate();//重新绘制
                break;
            case MotionEvent.ACTION_UP:
                isTouching = false;
                int center = (mBgBitmap.getWidth() - mSildeBitmap.getWidth())/2;
                boolean  newState = false;
                if (mSbImageOffset > center){
                    newState = true;
                }
                if (isclick){
                    isChecked = !isChecked;
                    if (mOnCheckedChangeListener != null){
                        mOnCheckedChangeListener.onCheckedChanged(this,isChecked);
                    }
                }else
                    if (newState != isChecked){
                    isChecked = newState;
                    if(mOnCheckedChangeListener != null){//表示调用者设置了状态改变的监听器
                        mOnCheckedChangeListener.onCheckedChanged(this, isChecked);
                    }
                }
                invalidate();
                break;
        }
        return true;
    }


    // 声明接口
    public interface OnCheckedChangeListener {

        void onCheckedChanged(SwitchButton switchButton, boolean isChecked);
    }
    // 声明接口的对象
    private OnCheckedChangeListener mOnCheckedChangeListener=null;
    // 添加设置监听对象的方法
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    /**
     * 设置滑动图片
     * @param slideInt
     */
    public void setSlideBitmapResource(int slideInt) {
        mSildeBitmap = BitmapFactory.decodeResource(getResources(),slideInt);
    }

    /**
     * 设置按钮背景图片
     * @param bgInt
     */
    public void setBgBitmapResource(int bgInt) {
        mBgBitmap = BitmapFactory.decodeResource(getResources(), bgInt);
    }

    // 设置开关状态
    public void setChecked(boolean b) {
        if(isChecked!=b){//状态发生改变
            isChecked=b;
            if(mOnCheckedChangeListener!=null){
                mOnCheckedChangeListener.onCheckedChanged(this, isChecked);
            }
        }

    }

    private void init() {

    }

}
