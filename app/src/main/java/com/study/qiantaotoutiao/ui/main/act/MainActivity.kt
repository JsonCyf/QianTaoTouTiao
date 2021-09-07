package com.study.qiantaotoutiao.ui.main.act


import android.util.Log
import androidx.fragment.app.Fragment

import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.study.qiantaotoutiao.R
import com.study.qiantaotoutiao.base.BaseActivity
import com.study.qiantaotoutiao.ui.main.adpater.HomeAdapter
import com.study.qiantaotoutiao.ui.main.frg.HomeFragment
import com.study.qiantaotoutiao.ui.main.frg.MinVideoFragment
import com.study.qiantaotoutiao.ui.main.frg.MineFragment
import com.study.qiantaotoutiao.ui.main.frg.VideoFragment
import com.study.qiantaotoutiao.ui.main.model.TitleModel
import com.study.qiantaotoutiao.ui.main.persenter.MainPersenter
import com.study.qiantaotoutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import java.time.OffsetDateTime

// R.layout.activity_main
class MainActivity : BaseActivity<MainView, MainPersenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()

    private val fragments = ArrayList<Fragment>()


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {

//        btn_test.setOnClickListener {
//            getPersenter()!!.getTest("Test")
//        }
        val titles = resources.getStringArray(R.array.title)

        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unselect)

        for (i: Int in titles.indices) {

            titleTabs.add(
                TitleModel(
                    titles[i],
                    selectIds.getResourceId(i, 0),
                    unSelectIds.getResourceId(i, 0)
                )
            )
        }

        fragments.add(HomeFragment())
        fragments.add(VideoFragment())
        fragments.add(MinVideoFragment())
        fragments.add(MineFragment())

        vp_home.adapter=HomeAdapter(supportFragmentManager,fragments)


        ctl_home.setTabData(titleTabs)

        ctl_home.setOnTabSelectListener(object :OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(position,false)
            }

            override fun onTabReselect(position: Int) {
            }
        })
    }

    override fun initData() {

    }

    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
        Log.e("TAG", "=====>${data}")
    }

    override fun setError(err: String) {

    }

}