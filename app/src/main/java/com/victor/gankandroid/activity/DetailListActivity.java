package com.victor.gankandroid.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.victor.gankandroid.Model.DetailData;
import com.victor.gankandroid.Model.JsonDetailDataList;
import com.victor.gankandroid.R;
import com.victor.gankandroid.adapter.DetailListAdapter;
import com.victor.gankandroid.application.ApplicationController;
import com.victor.gankandroid.client.RequestPath;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DetailListActivity extends AppCompatActivity {

    private static final String TAG = "DetailListActivity";

    private int currentPage = 1;
    private String pageSize = "10";
    private List<DetailData> mLists;

    private DetailListAdapter mAdapter;

    /*@BindView(R.id.rv_detail_list) RecyclerView mRv;
    @BindView(R.id.sr_layout) SwipeRefreshLayout mSrl;*/
    private RecyclerView mRv;
//    private SwipeRefreshLayout mSrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        //ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mRv = (RecyclerView) findViewById(R.id.rv_detail_list);
        /*mSrl = (SwipeRefreshLayout) findViewById(R.id.sr_layout);
        mSrl.setColorSchemeColors(R.color.cardview_light_background);
        mSrl.setOnRefreshListener(this);*/
        mAdapter = new DetailListAdapter(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
        mRv.setAdapter(mAdapter);
        getAllData();

    }


    private void getAllData() {
//        mSrl.setRefreshing(true);
        JsonObjectRequest request = new JsonObjectRequest(RequestPath.ANDROID + RequestPath.SPLIT + pageSize + RequestPath.SPLIT + currentPage,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject jsonObject) {

//                        mSrl.setRefreshing(false);
                        if (null == jsonObject) return;
                        String json2Str = jsonObject.toString();
                        JsonDetailDataList detailDataList = JSON.parseObject(json2Str, JsonDetailDataList.class);
                        mLists = detailDataList.getResults();
                        mAdapter.addMoreData(mLists);
                        /*try {
                            mLists = DetailData.initResponse(jsonObject);
                            mAdapter.addMoreData(mLists);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/
                        Log.e(TAG, jsonObject.toString());
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
//                        mSrl.setRefreshing(false);
                        Toast.makeText(DetailListActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, volleyError.toString());
                    }
                });
        request.setTag(TAG);
        ApplicationController.getInstance().addToRequestQueue(request, TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ApplicationController.getInstance().cancelPendingRequests(TAG);
    }

}
