package com.victor.gankandroid.base;


import com.victor.gankandroid.BuildConfig;
import com.victor.gankandroid.retrofit.LoggingInterceptor;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by victor on 2016/8/12.
 * retrofit请求
 */
public class AppClient {

    static Retrofit retrofit = null;

    public static Retrofit retrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            /**
             *设置缓存，代码略
             */
//            File cacheFile = new File(CustomApplication.getInstance().getExternalCacheDir(), "WuXiaolongCache");
//            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//            Interceptor cacheInterceptor = new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//                    if (!AppUtils.networkIsAvailable(DemoApplication.getContext())) {
//                        request = request.newBuilder()
//                                .cacheControl(CacheControl.FORCE_CACHE)
//                                .build();
//                    }
//                    Response response = chain.proceed(request);
//                    if (AppUtils.networkIsAvailable(DemoApplication.getContext())) {
//                        int maxAge = 0;
//                        // 有网络时 设置缓存超时时间0个小时
//                        response.newBuilder()
//                                .header("Cache-Control", "public, max-age=" + maxAge)
//                                .removeHeader("WuXiaolong")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                                .build();
//                    } else {
//                        // 无网络时，设置超时为4周
//                        int maxStale = 60 * 60 * 24 * 28;
//                        response.newBuilder()
//                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                                .removeHeader("nyn")
//                                .build();
//                    }
//                    return response;
//                }
//            };
//            builder.cache(cache).addInterceptor(cacheInterceptor);

            //公共参数
            Interceptor addQueryParameterInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    Request request;
                    HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                            .addQueryParameter("os", "android")
                            .build();
                    request = originalRequest.newBuilder().url(modifiedUrl).build();
                    return chain.proceed(request);
                }
            };
            builder.addInterceptor(addQueryParameterInterceptor);

            //设置头
            Interceptor headerInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    Request.Builder requestBuilder = originalRequest.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("Accept", "application/json")
                            .method(originalRequest.method(), originalRequest.body());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            };
            builder.addInterceptor(headerInterceptor);

//            //设置log
            if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//                builder.addInterceptor(logging);
                builder.addInterceptor(new LoggingInterceptor());//使用自定义的Log拦截器
            }

            //设置cookie
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            builder.cookieJar(new JavaNetCookieJar(cookieManager));

            //设置超时
            builder.connectTimeout(15, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            //以上设置结束，才能build(),不然设置白搭
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;

    }
}
