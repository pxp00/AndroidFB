package com.example.pengxuanping.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@SuppressLint("Registered") /* “Registered”: Class is not registered in the manifest */
public class NormalRxjava extends AppCompatActivity{

    private static final String TAG = "NormalRxjava";
    Disposable mDisposable = null;

    /*1. observable */
    /* new a obj, only allocate a space & addr to the obj,  do not run the methods */
    private Observable<String> novel= Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
            Log.d(TAG, "subscribe:" + "step0");
            /* observerable's event trigger */
            emitter.onNext("连载1");
            emitter.onNext("连载2");
            emitter.onNext("连载3");
            emitter.onComplete();
        }
    });

    /*2.  observer */
    private Observer<String> reader=new Observer<String>() {

        @Override
        public void onSubscribe(Disposable d) {
            mDisposable=d;
            Log.e(TAG,"onSubscribe");
        }

        @Override
        public void onNext(String value) {
            if ("2".equals(value)){
                mDisposable.dispose();
                return;
            }
            Log.e(TAG,"onNext:"+value);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG,"onError="+e.getMessage());
        }

        @Override
        public void onComplete() {
            Log.e(TAG,"onComplete()");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* thinking flow: subscrib(_able) -> onsubscribe(_er) -> onNext -> complete */

        Log.d(TAG, "onCreate: step 1");

        /* 3. subscribe */
        novel.subscribe(reader);//一行代码搞定
    }


}
