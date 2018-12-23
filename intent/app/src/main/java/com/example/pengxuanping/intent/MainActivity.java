package com.example.pengxuanping.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* ctx -> ctxwrapper - ctxthemewrapper -> activity */
    /* explicit intent: open intent of app itself */
    public void click1(View v) {
        Intent intent = new Intent(this, first.class);
        startActivity(intent);
    }

    /* inexplicit intent: use to open other app's act */
    public void click2(View v) {

        /* creat intent */
        Intent intent = new Intent();

        /* set intent-filter, match with the manifest intent-filter */
        intent = intent.setAction("android.intent.action.SECOND"); /* could be defined by yourself */
        intent.addCategory("android.intent.category.DEFAULT"); /* could ignore, intent will add default auto; default(phone/pad), LAUNCHER(create a shotcut on desktop)*/

        /* start */
        if (null == intent.resolveActivity(getPackageManager())) { /* existed act or not */
            Toast.makeText(this, "resolveActivity = null", Toast.LENGTH_SHORT).show();

        } else {
            startActivity(intent);
        }
    }

    /* inexplicit use browser open an  url */
    public void click3(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW); /* browser: ACTION_VIEW*/
        intent.setData(Uri.parse("http://www.baidu.com")); /* scheme://host:port:path */
        startActivities(new Intent[]{intent});
    }

    /* inexplicit use phone call 10086 */
    public void click4(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL); /* call: ACTION_DAIL */
        intent.setData(Uri.parse("tel:10086"));
        startActivities(new Intent[]{intent});
    }

}
