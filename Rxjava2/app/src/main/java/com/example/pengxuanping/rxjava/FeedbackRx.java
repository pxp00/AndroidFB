package com.example.pengxuanping.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class FeedbackRx extends AppCompatActivity {

    private static final String TAG = "Feedback";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         apply/Q -> retrieve thinking flow & key points -> apply/Q/feedback(get the result)
         observable.subscribe(observer)
         debug: Thread.currentThread().getName()
         onNext use String, so cls T = String
         reactive program: trigger -> react;  obj.mtd(bind, subscribe) -> interface(anonymous cls, Observer) -> mtd(onClick/OnNext)
         async: subscribeOn(Schedulers.io), observerOn(AndroidSchedulers.mainThread())
         note: mtd_onSubscribe run on thrd_main */
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

                Log.d(TAG, "subscribe: hello--" + Thread.currentThread().getName());
                /*run on the thrd_Rxcached*/
                emitter.onNext("hello" + "\n");
                Log.d(TAG, "subscribe: world1--" + Thread.currentThread().getName());
                emitter.onNext("world1" + "\n");
                Thread.sleep(3000);
                Log.d(TAG, "subscribe: world2--" + Thread.currentThread().getName());
                emitter.onNext("world2" + "\n");
                Log.d(TAG, "subscribe: world3--" + Thread.currentThread().getName());
                emitter.onNext("world3" + "\n");
                Log.d(TAG, "subscribe: worl4--" + Thread.currentThread().getName());
                emitter.onNext("world4" + "\n");

                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io()) // subscriberm thread
                .observeOn(Schedulers.newThread()) //observer thread
                .subscribe(new Observer<String>() {
                    @Override
                    /* run on the thrd_main*/
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: step0--" + Thread.currentThread().getName());
                    }

                    @Override
                    /*run on the thrd_Rxnew*/
                    public void onNext(String value) {
                        Log.d(TAG, "onNext: run " + value + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: finish run--" + Thread.currentThread().getName());
                    }
                });
        /* run on the thrd_main  */
        Log.d(TAG, "onCreate: step1--" + Thread.currentThread().getName());
    }
}
