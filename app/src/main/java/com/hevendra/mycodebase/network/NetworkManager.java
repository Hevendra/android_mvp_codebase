package com.hevendra.mycodebase.network;

import com.hevendra.mycodebase.network.Api.AppDummyAPIs;
import com.hevendra.mycodebase.network.Api.PreLoginAPIs;

/**
 * Created by Hevendra.Jadaun on 3/25/2018.
 */

public class NetworkManager {


    public static PreLoginAPIs getPreLoginApi() {
        return RetrofitClient.getClient().create(PreLoginAPIs.class);
    }

    public static AppDummyAPIs getAppDummyApi() {
        return RetrofitClient.getClient()
                .create(AppDummyAPIs.class);
    }

}
