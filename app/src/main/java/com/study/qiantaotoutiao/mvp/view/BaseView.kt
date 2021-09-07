package com.study.qiantaotoutiao.mvp.view

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
interface BaseView {
    fun <T>setData(data:T)

    fun setError(err:String)
}