package com.example.pengxuanping.handler;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
/*activity 开的线程每隔2秒钟向UI线程提交一个消息请求去更新title。
如果没有在onDestroy中将stopThread设为true，即使退出activity，线程没有销毁。重新开启程序，又重新去new了一个thread。重新启动程序几次就会对应几个一直循环的线程。。*/

public class ThirdAty extends Activity {
    private static final String TAG = "ThreadDemo";
    private int count = 0;
    /* handler: communicate between process */
    private Handler mHandler = new MyHandler(); //1. create handler
    boolean stopThread = false;

    private Runnable mRunnable = new Runnable() {

        public void run() {

            while (!stopThread) {
                count++;
                try {
                    Thread.sleep(2000); //wait 200ms
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        //使用Message.obtain( )或Handler.obtainMessage( )函数来获取Message对象，Msg 复用提高效率
                //2. send msg
                Message message = mHandler.obtainMessage();
                message.what = 0;
                message.obj = count;

                mHandler.sendMessage(message); //thread_worker
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(mRunnable).start(); //start a thread to refresh title interval
    }

    protected void onDestroy() {
        System.out.println("-----------onDestroy------");
        stopThread = true;
        super.onDestroy();
    }

    class MyHandler extends Handler {

        //3. handle msg
        @Override
        public void handleMessage(Message msg) { //thread_UI
// TODO Auto-generated method stub
            Log.e(TAG, Thread.currentThread().getName() + " " + msg.obj);
            setTitle("" + msg.obj);
// super.handleMessage(msg);
        }
    }

}
