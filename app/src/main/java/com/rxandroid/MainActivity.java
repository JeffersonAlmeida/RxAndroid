package com.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import hugo.weaving.DebugLog;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observer<List<User>> observer = new Observer<List<User>>() {

            @Override
            @DebugLog
            public void onCompleted() {

            }

            @Override
            @DebugLog
            public void onError(Throwable e) {

            }

            @Override
            @DebugLog
            public void onNext(List<User> users) {
                Log.i("onNext", "onNext: " + users.toString());
            }

        };
//
//        RestApi.get().getUsers()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        RestApi.get().getUser(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        Log.i("call", "user: " + user);
                    }
                });


    }
}
