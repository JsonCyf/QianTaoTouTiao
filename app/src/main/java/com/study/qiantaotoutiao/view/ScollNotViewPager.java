/**
 * Author: Administrator
 * Date: 2021/9/7 0007 16:33
 * Description:
 */
package com.study.qiantaotoutiao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
public class ScollNotViewPager extends ViewPager {
    public ScollNotViewPager(@NonNull Context context) {
        super(context);
    }

    public ScollNotViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
