package com.example.pengxuanping.asynctask;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pengxuanping.asynctask.R;

public class MainActivity extends Activity {

    private ImageView	image		= null;
    private Button		show;
    private ProgressBar	progressBar	= null;
    private int			number		= 0;
    List<String>		imageUrl	= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.processBar);
        image = (ImageView) findViewById(R.id.image);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(new showButtonListener());

        imageUrl = new ArrayList<String>(); // 图片地址List
        imageUrl.add("http://comic.sinaimg.cn/2011/0824/U5237P1157DT20110824161051.jpg");
        imageUrl.add("http://new.aliyiyao.com/UpFiles/Image/2011/01/13/nc_129393721364387442.jpg");
    }

    public class showButtonListener implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            number++;
            MyAsyncTask myAsyncTask = new MyAsyncTask(getApplicationContext());
            myAsyncTask.execute(imageUrl.get(number % imageUrl.size())); //loop: 0 ~ (size-1)
        }
    }

    //ppdp: private(cls_cur), default(package_cur), protected, public
    class MyAsyncTask extends AsyncTask<String, Integer, Bitmap>
    {
        // 可变长的输入参数，与AsyncTask.exucute()对应
        MyAsyncTask(Context context)
        {
            progressBar.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }

        //1. onPreExecute: prompt on main thread
        @Override
        protected void onPreExecute()
        {
            Toast.makeText(getApplicationContext(), "任务开始......", Toast.LENGTH_SHORT).show();
        }

        //2. onInBackgroud: thread_back, get parameter from execute
        @Override
        protected Bitmap doInBackground(String... params)
        {
            Bitmap bitmap = null;
            try
            {
                //根据URL取得图片并返回
                URL url = new URL(params[0]);

                URLConnection conn = url.openConnection();
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);

               // Toast.makeText(getApplicationContext(), "传回图片了", Toast.LENGTH_SHORT).show();
                inputStream.close();
            }
            catch (Exception e)
            {
                Log.e("msg", e.getMessage());
            }
            return bitmap;
        }

        //3. onPostExecute: thread_main, get parameters from doInBackground
        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            progressBar.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            if (bitmap != null)
            {
                image.setImageBitmap(bitmap);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "网络异常", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
