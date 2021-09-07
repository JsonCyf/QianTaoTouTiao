package com.study.qiantaotoutiao.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}