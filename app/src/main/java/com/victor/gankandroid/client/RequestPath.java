package com.victor.gankandroid.client;

/**
 * Created by victor on 16-5-7.
 */
public class RequestPath {

    public static final String BASE_URL = "http://gank.io/api/";

    public static final String SPLIT = "/";

    /*分类数据: http://gank.io/api/data/数据类型/请求个数/第几页

    数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
    请求个数： 数字，大于0
    第几页：数字，大于0*/
    public static final String FU_LI = BASE_URL + "data/福利";

    public static final String ANDROID = BASE_URL + "data/Android";

    public static final String IOS = BASE_URL + "data/iOS";

    public static final String TAKE_A_BREAK = BASE_URL + "data/休息视频";

    public static final String RESOURS = BASE_URL + "data/拓展资源";

    public static final String FORE = BASE_URL + "data/前端";

    public static final String ALL = BASE_URL + "data/all";

}
