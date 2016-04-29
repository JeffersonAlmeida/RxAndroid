package com.rxandroid;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by jeffersonalmeida on 4/29/16.
 */
public interface RestInterface {

    @GET("posts")
    public Observable<List<User>> getUsers();

    @GET("posts/{id}")
    public Observable<User> getUser(@Path("id") int id);

}
