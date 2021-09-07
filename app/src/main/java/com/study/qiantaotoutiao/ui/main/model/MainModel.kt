package com.study.qiantaotoutiao.ui.main.model

import com.study.qiantaotoutiao.mvp.model.BaseModel

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
data class MainModel(val cityname:String,
                     val nameen:String,
                     val temp:String,
                     val WD:String,
                     val WS:String,
                     val wse:String,
                     val SD:String,
                     val weather:String,
                     val pm25:String,
                     val limitnumber:String,
                     val time:String)