package com.victor.gankandroid.retrofit;

import com.victor.gankandroid.Model.base.DetailData;
import com.victor.gankandroid.Model.base.Result;
import com.victor.gankandroid.base.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by victor on 2017/6/13.
 */

public interface Api {

    //android列表
    @GET(Constants.ANDROID)
    Call<Result<List<DetailData>>> androidList(@Path("page") int page);
}
