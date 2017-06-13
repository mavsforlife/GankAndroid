package com.victor.gankandroid.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.victor.gankandroid.Model.base.BaseResult;
import com.victor.gankandroid.Model.base.DetailData;

import java.util.List;

/**
 * Created by victor on 2016/5/16.
 */
public class JsonDetailDataList extends BaseResult {

    private List<DetailData> results;

    public List<DetailData> getResults() {
        return results;
    }

    public void setResults(List<DetailData> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.results);
    }

    public JsonDetailDataList() {
    }

    protected JsonDetailDataList(Parcel in) {
        this.results = in.createTypedArrayList(DetailData.CREATOR);
    }

    public static final Parcelable.Creator<JsonDetailDataList> CREATOR = new Parcelable.Creator<JsonDetailDataList>() {
        @Override
        public JsonDetailDataList createFromParcel(Parcel source) {
            return new JsonDetailDataList(source);
        }

        @Override
        public JsonDetailDataList[] newArray(int size) {
            return new JsonDetailDataList[size];
        }
    };
}
