package com.study.qiantaotoutiao.base


import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.study.qiantaotoutiao.mvp.persenter.BasePersenter
import com.study.qiantaotoutiao.mvp.view.BaseView


abstract class BaseActivity<V, P : BasePersenter<V>> : AppCompatActivity(), BaseView {

    private var mPersenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        if (mPersenter == null) {
            mPersenter = createPersenter()
        }

        mPersenter!!.bindView(this as V)

        init()

        initData()

    }

    abstract fun getLayoutId(): Int

    abstract fun init()

    abstract fun initData()


    abstract fun createPersenter(): P

    fun getPersenter() = mPersenter

    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }
}