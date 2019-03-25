package com.xplay.pp.scaletimebar.timebar;

import android.support.annotation.ColorInt;

public class SmallTime {
    private long startValue;
    private long endValue;
    @ColorInt
    private int timeColor;

    public long getStartValue() {
        return startValue;
    }

    public int getTimeColor() {
        return timeColor;
    }

    public void setTimeColor(@ColorInt int timeColor) {
        this.timeColor = timeColor;
    }

    public void setStartValue(long startValue) {
        this.startValue = startValue;
    }

    public long getEndValue() {
        return endValue;
    }

    public void setEndValue(long endValue) {
        this.endValue = endValue;
    }

    public long getRange() {
        return endValue - startValue;
    }
}
