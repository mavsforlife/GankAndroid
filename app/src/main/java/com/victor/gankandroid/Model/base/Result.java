package com.victor.gankandroid.Model.base;

/**
 * Created by victor on 2017/6/14.
 */

public class Result<T> {

    private boolean error;
    private int count;
    private T results;

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

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
