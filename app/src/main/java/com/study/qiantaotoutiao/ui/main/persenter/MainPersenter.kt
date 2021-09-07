package com.study.qiantaotoutiao.ui.main.persenter

import com.study.qiantaotoutiao.http.HttpUtils
import com.study.qiantaotoutiao.http.ResponseListernter
import com.study.qiantaotoutiao.http.UserApi
import com.study.qiantaotoutiao.mvp.model.BaseModel
import com.study.qiantaotoutiao.mvp.persenter.BasePersenter
import com.study.qiantaotoutiao.mvp.view.BaseView
import com.study.qiantaotoutiao.ui.main.model.MainModel
import com.study.qiantaotoutiao.ui.main.view.MainView

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
class MainPersenter : BasePersenter<MainView>() {
    fun getTest(str: String) {
//        getBaseView ()!!.setData(str)
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest("合肥",1),
            object : ResponseListernter<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                    if (data != null) {
                        getBaseView()!!.setData(data)
                    }
                }

                override fun onFail(err: String) {
                    getBaseView()!!.setError(err)
                }

            })
    }
}