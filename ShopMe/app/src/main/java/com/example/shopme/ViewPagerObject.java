package com.example.shopme;

public enum  ViewPagerObject {

    RED(R.drawable.banner_1, R.layout.view_red),
    BLUE(R.drawable.banner_2, R.layout.view_blue),
    GREEN(R.drawable.banner_3, R.layout.view_green);

    private int mTitleResId;
    private int mLayoutResId;

    ViewPagerObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}