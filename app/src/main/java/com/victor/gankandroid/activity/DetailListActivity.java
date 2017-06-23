package com.victor.gankandroid.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.victor.gankandroid.Model.base.DetailData;
import com.victor.gankandroid.Model.base.Result;
import com.victor.gankandroid.R;
import com.victor.gankandroid.adapter.DetailListAdapter;
import com.victor.gankandroid.base.AppClient;
import com.victor.gankandroid.retrofit.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "DetailListActivity";

    private int currentPage = 1;
    private List<DetailData> mList;

    private DetailListAdapter mAdapter;

    @BindView(R.id.rv_detail_list)
    RecyclerView mRv;
    @BindView(R.id.sr_layout)
    SwipeRefreshLayout mSrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mSrl.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary));
        mSrl.setOnRefreshListener(this);
        mAdapter = new DetailListAdapter(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
        mList = new ArrayList<>();
        getAllData();
    }

    private void getAllData() {
        mSrl.setRefreshing(true);
        Api api = AppClient.retrofit().create(Api.class);
        Call<Result<List<DetailData>>> call = api.androidList(currentPage);
        call.enqueue(new Callback<Result<List<DetailData>>>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onResponse(Call<Result<List<DetailData>>> call, Response<Result<List<DetailData>>> response) {

                mSrl.setRefreshing(false);
                if (null != response && null != response.body()) {
                    mList = response.body().getResults();
                    mAdapter.addMoreData(mList);
                }
            }

            @Override
            public void onFailure(Call<Result<List<DetailData>>> call, Throwable t) {
                mSrl.setRefreshing(false);
                Toast.makeText(DetailListActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        getAllData();
    }
}
