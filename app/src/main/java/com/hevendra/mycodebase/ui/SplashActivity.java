package com.hevendra.mycodebase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hevendra.mycodebase.R;
import com.hevendra.mycodebase.base.BaseActivity;
import com.hevendra.mycodebase.utils.AppPref;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public class SplashActivity extends BaseActivity {

    private static final int DELAY_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        handleSplashLogic();
    }


    /**
     * Method to check whether user is logged in or not and on the basis of that
     * open login or home screen.
     */
    private void handleSplashLogic() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (AppPref.getInstance().getBoolean(SplashActivity.this,AppPref.PREF_LOGIN)) {
                    startActivity(new Intent(SplashActivity.this,
                            HomeActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this,
                            LoginActivity.class));
                }
                finish();
            }
        }, DELAY_TIME);
    }
}
