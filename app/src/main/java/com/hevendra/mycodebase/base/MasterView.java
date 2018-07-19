package com.hevendra.mycodebase.base;

import android.content.DialogInterface;
import android.support.annotation.StringRes;

/**
 * Created by Hevendra.Jadaun on 3/24/2018.
 */

public interface MasterView {

    void openActivityOnTokenExpire();

    void onError(int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(int resId);

    void hideKeyboard();

    void showLoader();

    void hideLoader();

    void showProgress(String msg, boolean isCancellable,
                      DialogInterface.OnCancelListener cancelListener);

    void hideProgress();

    void showSnackBar(String message);
}
