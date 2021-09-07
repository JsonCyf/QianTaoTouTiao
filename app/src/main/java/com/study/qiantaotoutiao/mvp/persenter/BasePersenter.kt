package com.study.qiantaotoutiao.mvp.persenter

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
 open class BasePersenter<V> {
    private var mBaseView: V?=null

    fun bindView(mBaseView:V){
        this.mBaseView=mBaseView;
    }

    fun unBindView(){
        this.mBaseView=null
    }

    fun getBaseView()=mBaseView
}