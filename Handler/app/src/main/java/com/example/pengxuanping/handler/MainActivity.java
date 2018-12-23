package com.example.pengxuanping.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    List<String> imageUrl = null;
    Handler m_mainHandler;
    private int number = 0;
    @BindView(R.id.show)
    Button show;
    @BindView(R.id.processBar)
    ProgressBar progressBar;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        m_mainHandler = new MyHandler(); //1. creat obj_handler on thread_main

        imageUrl = new ArrayList<String>(); // 图片地址List
        imageUrl.add("http://image.tianjimedia.com/uploadImages/2011/266/AIO90AV2508S.jpg");
        imageUrl.add("http://image.tianjimedia.com/uploadImages/2012/090/063N2L5N2HID.jpg");
        imageUrl.add("http://comic.sinaimg.cn/2011/0824/U5237P1157DT20110824161051.jpg");
        imageUrl.add("http://image.tianjimedia.com/uploadImages/2012/090/1429QO6389U8.jpg");
        imageUrl.add("http://new.aliyiyao.com/UpFiles/Image/2011/01/13/nc_129393721364387442.jpg");
    }

    @OnClick(R.id.show)
    public void onViewClicked() {
        number++;
        MyAsyncTask myAsyncTask = new MyAsyncTask(getApplicationContext());
        //1. execute AsyncTask
        myAsyncTask.execute(imageUrl.get(number % 5));
    }

    @SuppressLint("StaticFieldLeak")
    class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        // 可变长的输入参数，与AsyncTask.exucute()对应
        public MyAsyncTask(Context context) {
            progressBar.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }

        //3. doInBackground thread_worker
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                //根据URL取得图片并返回
                URL url = new URL(params[0]);

                URLConnection conn = url.openConnection();
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);

                Message msg = new Message();
                msg.what = 1;
                msg.obj = "传回图片了";
                m_mainHandler.sendMessage(msg); //2. send msg from thread_backgroud to thread_main

                inputStream.close();
            } catch (Exception e) {
                Log.e("msg", e.getMessage());
            }
            return bitmap;
        }

        /**
         * 在doInBackground 执行完成后，onPostExecute方法将被UI thread调用，后台的计算结果将通过该方法传递到UI thread.
         */
        // onPostExecute thread_UI
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressBar.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            if (bitmap != null) {
                image.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getApplicationContext(), "网络异常", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * 该方法将在执行实际的后台操作前被UI thread调用。这个方法只是做一些准备工作，如在界面上显示一个进度条。
         */
        //onPreExecute thread_UI
        @Override
        protected void onPreExecute() {
            // 任务启动
            Toast.makeText(getApplicationContext(), "任务开始......", Toast.LENGTH_SHORT).show();
        }
    }



    //cls_handler
    private class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {//3. deal with msg on thread_main(UI)
            switch (msg.what) {

                case 1:
                    String str = (String) msg.obj;
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    break;

                default:
                    break;
            }
        }
    }

}
