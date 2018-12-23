package com.example.pengxuanping.mpvcivilian;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pengxuanping.mpvcivilian.base.BaseActivity;

public class MainActivity extends BaseActivity implements mvpView  {
    TextView text;
    mvpPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); /* call  mtd_parent to init obj_x */
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        //初始化Presenter
        presenter = new mvpPresenter();
        presenter.attachView(this); /* obj_view as a bridges, presenter call mtd_mtd */
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开View引用
        presenter.detachView();
    }
    @Override
    public void showData(String data) {
        text.setText(data);
    }
    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }
}
