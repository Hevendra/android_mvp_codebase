package com.hevendra.mycodebase.presenters;

import android.app.Activity;

import com.hevendra.mycodebase.base.BaseActivity;
import com.hevendra.mycodebase.utils.AppUtils;
import com.hevendra.mycodebase.views.LoginView;

/**
 * Created by Hevendra.Jadaun on 3/25/2018.
 */

public class LoginPresenter {
    private Activity mActivity;
    private LoginView mView;

    public LoginPresenter(Activity mActivity, LoginView mView)
    {
        this.mActivity=mActivity;
        this.mView=mView;
    }

    public void login()
    {
         if(validate())
         {
            mView.loginSuccessful();
         }
    }

    private boolean validate()
    {
        boolean isValidate=true;
        if(AppUtils.isEmptyOrNull(mView.getLoginID()))
        {
            mView.setLoginIDError();
            isValidate=false;
        }
        else if(!AppUtils.isValidEmailAddress(mView.getLoginID()))
        {
            mView.setInvalidIDError();
            isValidate=false;
        }
        if(AppUtils.isEmptyOrNull(mView.getLoginPassword()))
        {
            mView.setLoginPasswordError();
            isValidate=false;
        }
        return isValidate;
    }
}
