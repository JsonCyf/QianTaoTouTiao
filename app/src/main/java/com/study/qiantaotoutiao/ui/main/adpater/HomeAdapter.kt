package com.study.qiantaotoutiao.ui.main.adpater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
class HomeAdapter(fm: FragmentManager, fmslist: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    private val fmslist = fmslist

    override fun getCount(): Int = fmslist.size

    override fun getItem(position: Int): Fragment =fmslist[position]
}