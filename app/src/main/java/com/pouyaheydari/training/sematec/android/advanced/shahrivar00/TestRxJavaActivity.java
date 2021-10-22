package com.pouyaheydari.training.sematec.android.advanced.shahrivar00;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestRxJavaActivity extends AppCompatActivity {
    CompositeDisposable cd = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rx_java);
        TextView textView = findViewById(R.id.textView);



        cd.add(Observable.just("Pouya", "Alireza", "Amirhossein", "Javad", "Negin", "Sahar", "Sina")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Throwable {
                        Thread.sleep(2000);
                        return s;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    textView.setText(s);
                },throwable -> {
                    throwable.printStackTrace();
                },() -> {
                    Log.d("TAG", "onComplete: ");
                }));
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d("TAG", "onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        textView.setText(s);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("TAG", "onComplete: ");
//                    }
//                });
    }

    @Override
    protected void onDestroy() {
        cd.dispose();
        super.onDestroy();
    }
}