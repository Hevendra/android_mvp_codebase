package com.hevendra.mycodebase.ui;

import android.os.Bundle;

import com.hevendra.mycodebase.R;
import com.hevendra.mycodebase.base.BaseActivity;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
