package com.study.qiantaotoutiao.mvp.model

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
data class BaseModel<T>(var code: Int, var message: String, var data: T)