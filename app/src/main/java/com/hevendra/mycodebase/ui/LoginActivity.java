package com.hevendra.mycodebase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import com.hevendra.mycodebase.R;
import com.hevendra.mycodebase.base.BaseActivity;
import com.hevendra.mycodebase.presenters.LoginPresenter;
import com.hevendra.mycodebase.utils.AppPref;
import com.hevendra.mycodebase.views.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public class LoginActivity extends BaseActivity implements LoginView{
    @BindView(R.id.tilEmail)
    protected TextInputLayout tilEmail;
    @BindView(R.id.etEmail)
    protected EditText etEmail;
    @BindView(R.id.tilPassword)
    protected  TextInputLayout tilPassword;
    @BindView(R.id.etPassword)
    protected EditText etPassword;

    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

        presenter=new LoginPresenter(this,this);
    }

    @OnClick(R.id.btnLogin)
    protected void login()
    {
        tilPassword.setErrorEnabled(false);
        tilEmail.setErrorEnabled(false);
        presenter.login();
    }

    @Override
    public void loginSuccessful() {
        AppPref.getInstance().saveString(this,AppPref.PREF_LOGGED_IN_USER,getLoginID());
        AppPref.getInstance().saveBoolean(this,AppPref.PREF_IS_LOGGED_IN,true);
        openHomeActivity();
    }

    private void openHomeActivity()
    {
        Intent intent=new Intent(this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public String getLoginID() {
        return etEmail.getText().toString();
    }

    @Override
    public String getLoginPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void setLoginIDError() {
        tilEmail.setErrorEnabled(true);
        tilEmail.setError(getResources().getString(R.string.error_blank_email));
    }

    @Override
    public void setLoginPasswordError() {
        tilPassword.setErrorEnabled(true);
        tilPassword.setError(getResources().getString(R.string.error_blank_password));
    }

    @Override
    public void setInvalidIDError() {
        tilEmail.setErrorEnabled(true);
        tilEmail.setError(getResources().getString(R.string.error_invalid_email));
    }
}
