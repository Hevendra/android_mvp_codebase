package com.hevendra.mycodebase.network.Requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hevendra.Jadaun on 3/25/2018.
 */

public class LoginRequest {
    @SerializedName("loginId")
    public String loginId;

    @SerializedName("password")
    public String password;

}
