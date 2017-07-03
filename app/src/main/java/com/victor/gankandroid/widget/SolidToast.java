package com.victor.gankandroid.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StyleRes;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by victor on 2017/7/3.
 * 增强toast
 */

public class SolidToast {

    private Toast mToast;
    private Context mContext;
    private
    @StyleRes
    int style = -1;
    private String mText;
    private int duration;

    @SuppressLint("ShowToast")
    private void init() {

        mToast = Toast.makeText(mContext, mText, duration);

        try {
            Object mTN = getField(mToast, "mTN");
            if (mTN != null) {
                Object mParams = getField(mTN, "mParams");
                if (mParams != null
                        && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.windowAnimations = style;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    /**
     * 反射字段
     * @param object 要反射的对象
     * @param fieldName 要反射的字段名称
     * @return 反射的字段
     * @throws NoSuchFieldException exception
     * @throws IllegalAccessException exception
     */
    private static Object getField(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }
        return null;
    }

    public static class Builder {
        private SolidToast toast = new SolidToast();

        public Builder context(Context context) {
            toast.mContext = context;
            return this;
        }

        public Builder animation(@StyleRes int style) {
            toast.style = style;
            return this;
        }

        public Builder text(String text) {
            toast.mText = text;
            return this;
        }

        public Builder duration(int duration) {
            toast.duration = duration;
            return this;
        }

        public SolidToast build() {
            toast.init();
            return toast;
        }

    }
}
