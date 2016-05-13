package com.victor.gankandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.victor.gankandroid.Model.DetailData;
import com.victor.gankandroid.R;
import com.victor.gankandroid.application.ApplicationController;
import com.victor.gankandroid.client.RequestPath;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*@BindView(R.id.tv_android) TextView mTvAndroid;
    @BindView(R.id.tv_ios) TextView mTvIOs;
    @BindView(R.id.tv_fore) TextView mTvFore;*/
    TextView mTvAndroid, mTvIOs, mTvFore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        mTvAndroid = (TextView) findViewById(R.id.tv_android);
        mTvIOs = (TextView) findViewById(R.id.tv_ios);
        mTvFore = (TextView) findViewById(R.id.tv_fore);

        mTvAndroid.setOnClickListener(this);
        mTvIOs.setOnClickListener(this);
        mTvFore.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_android:
                startActivity(new Intent(MainActivity.this, DetailListActivity.class));
                break;

            case R.id.tv_ios:
                break;

            case R.id.tv_fore:
                break;

            default:
                break;
        }
    }
}
