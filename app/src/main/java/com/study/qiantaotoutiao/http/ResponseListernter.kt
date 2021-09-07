package com.study.qiantaotoutiao.http

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
interface ResponseListernter<T> {
    fun onSuccess(data:T)

    fun onFail(err:String)
}