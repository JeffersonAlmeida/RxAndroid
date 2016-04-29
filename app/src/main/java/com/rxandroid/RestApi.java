package com.rxandroid;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by jeffersonalmeida on 4/29/16.
 */
public class RestApi {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    private static RestInterface restInterface;

    static {

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        restInterface = retrofit.create(RestInterface.class);

    }

    public static RestInterface get() {
        return restInterface;
    }
}
