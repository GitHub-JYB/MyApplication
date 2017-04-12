package com.example.admin_jyb.myapplication.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin_jyb.myapplication.R;

/**
 * Created by Admin-JYB on 2017/4/12.
 */

public class ImageWithText extends LinearLayout{


    public ImageWithText(Context context) {
        super(context);
    }

    public ImageWithText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.image_with_text, this, true);
        ImageButton btn = (ImageButton) view.findViewById(R.id.btn);
        TextView text = (TextView) view.findViewById(R.id.text);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageWithText);
        CharSequence text1 = typedArray.getText(R.styleable.ImageWithText_android_text);
        if (text != null)text.setText(text1);
        Drawable drawable = typedArray.getDrawable(R.styleable.ImageWithText_android_src);
        if (drawable != null)btn.setBackground(drawable);
        typedArray.recycle();
    }

}
