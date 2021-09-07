package com.study.qiantaotoutiao.http

import com.study.qiantaotoutiao.mvp.model.BaseModel
import com.study.qiantaotoutiao.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
interface UserApi {
//    @GET("journalismApi")
//    fun getTest(): Observable<BaseModel<MainModel>>

    /**
     * 注意问题：
     * 1. 加入@FormUrlEncoded 只支持x-www-form-urlencoded不支持form-data所致,时加入这个
     *    如果不加人，会报错，正常请求应该不需要加
     * 2. BaseModel<MainModel>：BaseModel<T>是Model的基类，参考另外文章的data class
     * 3. MainModel是activity的MVP里的M层，具体内容是请求api返回的格式
     */
    @FormUrlEncoded
    @POST("api/tianqi")
    fun getTest(
        @Field("city") city: String,
        @Field("type") type: Int
    ): Observable<BaseModel<MainModel>>
}