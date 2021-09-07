package com.study.qiantaotoutiao.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
data class TitleModel(val title:String,val select:Int ,val unSelect:Int):CustomTabEntity{
    override fun getTabTitle(): String =title

    override fun getTabSelectedIcon(): Int =select

    override fun getTabUnselectedIcon(): Int =unSelect

}
