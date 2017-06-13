package com.victor.gankandroid.retrofit;

import com.victor.gankandroid.Model.JsonDetailDataList;
import com.victor.gankandroid.base.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by victor on 2017/6/13.
 */

public interface Api {

    //android列表
    @GET(Constants.ANDROID)
    Call<JsonDetailDataList> androidList(@Path("page") int page);
}
