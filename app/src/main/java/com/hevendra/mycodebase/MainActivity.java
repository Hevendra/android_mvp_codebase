package com.hevendra.mycodebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.hevendra.mycodebase.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.spCategory)
    Spinner spCategory;
    @BindView(R.id.btnNext)
    Button btnNext;
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

    @OnClick(R.id.btnNext)
    protected void showMessage()
    {
        showSnackBar("Button Clicked...");
    }
}
