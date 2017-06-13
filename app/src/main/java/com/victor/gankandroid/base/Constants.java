package com.victor.gankandroid.base;

/**
 * Created by victor on 2017/6/13.
 */

public class Constants {

    public static final String LOG_TAG = "GankAndroid";

    //====================请求url，参数===================================
    public static final String BASE_URL = "http://gank.io/api/data/";

    public static final String SPLIT = "/";

    /*分类数据: http://gank.io/api/data/数据类型/请求个数/第几页

    数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
    请求个数： 数字，大于0
    第几页：数字，大于0*/
    public static final String FU_LI = "福利/10/{page}";

    public static final String ANDROID = "Android/10/{page}";

    public static final String IOS = "iOS/10/{page}";

    public static final String TAKE_A_BREAK = "休息视频/10/{page}";

    public static final String RESOURS = "拓展资源/10/{page}";

    public static final String FORE = "前端/10/{page}";

    public static final String ALL = "all/10/{page}";
}
