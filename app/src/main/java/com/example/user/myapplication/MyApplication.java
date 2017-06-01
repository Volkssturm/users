package com.example.user.myapplication;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 王 ：王万鹏
 * 2017/5/30 20:06 .：
 * & 作用  ：
 * & 思路  ：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
