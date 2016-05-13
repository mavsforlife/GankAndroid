package com.victor.gankandroid.Model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

/**
 * Created by victor on 16-5-8.
 */
public class DetailData implements Parcelable {

    /**
     * _id : 572c10ac67765974fbfcfa19
     * createdAt : 2016-05-06T11:34:04.190Z
     * desc : 一个学习 Android 开发相关技术的项目
     * publishedAt : 2016-05-06T12:04:47.203Z
     * source : chrome
     * type : Android
     * url : http://www.jianshu.com/p/faf1ce1e232b
     * used : true
     * who : AndWang
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeString(this.createdAt);
        dest.writeString(this.desc);
        dest.writeString(this.publishedAt);
        dest.writeString(this.source);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeByte(used ? (byte) 1 : (byte) 0);
        dest.writeString(this.who);
    }

    public DetailData() {
    }

    protected DetailData(Parcel in) {
        this._id = in.readString();
        this.createdAt = in.readString();
        this.desc = in.readString();
        this.publishedAt = in.readString();
        this.source = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.used = in.readByte() != 0;
        this.who = in.readString();
    }

    public static final Parcelable.Creator<DetailData> CREATOR = new Parcelable.Creator<DetailData>() {
        @Override
        public DetailData createFromParcel(Parcel source) {
            return new DetailData(source);
        }

        @Override
        public DetailData[] newArray(int size) {
            return new DetailData[size];
        }
    };

    public static List<DetailData> initResponse(JSONObject jsonObject) throws JSONException {

        JSONArray jsonArray = jsonObject.getJSONArray("results");
        List<DetailData> detailDatas = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            DetailData detailData = new DetailData();
            detailData.set_id(jsonObject1.getString("_id"));
            detailData.setCreatedAt(jsonObject1.getString("createdAt"));
            detailData.setDesc(jsonObject1.getString("desc"));
            detailData.setPublishedAt(jsonObject1.getString("publishedAt"));
            detailData.setSource(jsonObject1.getString("source"));
            detailData.setType(jsonObject1.getString("type"));
            detailData.setUrl(jsonObject1.getString("url"));
            detailData.setUsed(jsonObject1.getBoolean("used"));
            detailData.setWho(jsonObject1.getString("who"));
            detailDatas.add(detailData);
        }
        return detailDatas;
    }
}
