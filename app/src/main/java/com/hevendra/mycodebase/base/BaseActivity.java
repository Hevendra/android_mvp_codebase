package com.hevendra.mycodebase.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hevendra.mycodebase.R;
import com.hevendra.mycodebase.ui.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements MasterView{

    private final String TAG = getClass().getName();
    private ProgressDialog pdDialog;
    @Nullable
    @BindView(R.id.loader_progress_layout)
    protected FrameLayout mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState);
    }

    protected abstract int getContentView() ;
    protected abstract void onViewReady(Bundle savedInstanceState);



    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }
    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }


    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        Intent intent=new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }



    @Override
    public void showLoader() {
        if (mLoader != null) {
            mLoader.setVisibility(View.VISIBLE);
        } else {
            Log.e(TAG, "Progress Bar not added in layout of : "
                    + getClass().getSimpleName());
        }
    }

    @Override
    public void hideLoader() {
        if (mLoader != null && mLoader.isShown()) {
            mLoader.setVisibility(View.GONE);
        }
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        textView.setMaxLines(2);
        snackbar.show();
    }

    @Override
    public void showProgress(String msg, boolean isCancellable,
                                DialogInterface.OnCancelListener cancelListener) {
        try {
            if (null == pdDialog) {
                pdDialog = new ProgressDialog(this);
                pdDialog.setCancelable(isCancellable);
                pdDialog.setOnCancelListener(cancelListener);
                pdDialog.setCanceledOnTouchOutside(false);
                pdDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pdDialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT));
                pdDialog.setMessage(msg);
                pdDialog.show();
                pdDialog.setContentView(R.layout.progress_view);
            } else {
                pdDialog.setCancelable(isCancellable);
                pdDialog.show();
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void hideProgress() {
        if (pdDialog != null && pdDialog.isShowing())
            pdDialog.hide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != pdDialog) {
            pdDialog.dismiss();
            pdDialog = null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}

