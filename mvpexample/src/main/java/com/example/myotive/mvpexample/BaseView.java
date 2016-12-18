package com.example.myotive.mvpexample;

/**
 * Created by michaelyotive_hr on 12/17/16.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
