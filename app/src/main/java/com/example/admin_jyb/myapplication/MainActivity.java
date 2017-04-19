package com.example.admin_jyb.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.NotificationTarget;
import com.example.admin_jyb.myapplication.Base.ToolBarActivity;
import com.example.mvp.Image.ImageLoader;


public class MainActivity extends ToolBarActivity {

    private NotificationTarget notificationTarget;

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

    @Override
    protected void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        ImageLoader.Builder builder = new ImageLoader.Builder();
        builder.with(getApplicationContext()).load("https://www.baidu.com/img/bd_logo1.png").into(imageView);
        new ImageLoader(builder).showImage();

        final RemoteViews rv = new RemoteViews(getBaseContext().getPackageName(), R.layout.remoteview_notification);

        rv.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.ic_launcher);

        rv.setTextViewText(R.id.remoteview_notification_headline, "Headline");
        rv.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");

// build notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getBaseContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setContent(rv)
                        .setPriority( NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

// set big content view for newer androids
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = rv;
        }

        NotificationManager mNotificationManager = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, notification);



        notificationTarget = new NotificationTarget(
                getBaseContext(),
                rv,
                R.id.remoteview_notification_icon,
                notification,
                1);

        Glide
                .with( getApplicationContext() ) // safer!
                .load( "https://www.baidu.com/img/bd_logo1.png" )
                .asBitmap()
                .into( notificationTarget );
    }

    public void click(View view){
        Intent intent = new Intent(this, ShowActivity.class);
        startActivity(intent);
    }
}
