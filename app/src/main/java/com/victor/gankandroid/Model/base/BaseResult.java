package com.victor.gankandroid.Model.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victor on 2017/6/13.
 */

public class BaseResult implements Parcelable {

    protected boolean error;
    protected int count;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.error ? (byte) 1 : (byte) 0);
        dest.writeInt(this.count);
    }

    public BaseResult() {
    }

    protected BaseResult(Parcel in) {
        this.error = in.readByte() != 0;
        this.count = in.readInt();
    }

    public static final Parcelable.Creator<BaseResult> CREATOR = new Parcelable.Creator<BaseResult>() {
        @Override
        public BaseResult createFromParcel(Parcel source) {
            return new BaseResult(source);
        }

        @Override
        public BaseResult[] newArray(int size) {
            return new BaseResult[size];
        }
    };
}
