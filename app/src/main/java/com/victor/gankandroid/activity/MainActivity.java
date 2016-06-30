package com.victor.gankandroid.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.victor.gankandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.tv_android)
    Button mTvAndroid;
    @BindView(R.id.tv_ios)
    Button mTviOS;
    @BindView(R.id.tv_fore)
    Button mTvFore;


    //TextView mTvAndroid, mTvIOs, mTvFore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_android, R.id.tv_ios, R.id.tv_fore})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_android:
                Toast.makeText(this, "android", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DetailListActivity.class));
                break;
            case R.id.tv_ios:
                Toast.makeText(this, "iOS", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DetailListActivity.class));
                break;
            case R.id.tv_fore:
                Toast.makeText(this, "fore", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DetailListActivity.class));
                break;
        }
    }

}
