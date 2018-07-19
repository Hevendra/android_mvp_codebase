package com.hevendra.mycodebase.views;

import com.hevendra.mycodebase.base.MasterView;

/**
 * Created by Hevendra.Jadaun on 3/25/2018.
 */

public interface LoginView extends MasterView {
    void loginSuccessful();
    String getLoginID();
    String getLoginPassword();
    void setLoginIDError();
    void setLoginPasswordError();
    void setInvalidIDError();
}
