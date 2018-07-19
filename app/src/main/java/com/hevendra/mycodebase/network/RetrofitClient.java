package com.hevendra.mycodebase.network;

import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hevendra.Jadaun on 3/25/2018.
 */

public class RetrofitClient  {
    static SSLContext sslContext = null;

    public static final String BASE_URL = "https://wall.alphacoders.com/api2.0/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

   /* protected static Retrofit getAuthClient(String baseUrl, boolean isSSL) {

        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(getOkHttpClient(true, isSSL))
                .addConverterFactory(GsonConverterFactory
                        .create(new GsonBuilder().serializeNulls()
                                .excludeFieldsWithModifiers(Modifier.FINAL,
                                        Modifier.TRANSIENT, Modifier.STATIC)
                                .create()))
                .build();
    }*/


}

