package com.example.pengxuanping.msghelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* listview disp the msg */
public class Msg extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final String[] listmsg = {
                "hello world",
                "I was telling him to drive slowly",
                "that policeman's waving to you",
                "he wants you to stop",
                "I won't charge you this time"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg);
        ListView lv_msg = findViewById(R.id.lv_msg);
        lv_msg.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listmsg)); /* disp */
        lv_msg.setOnItemClickListener(new AdapterView.OnItemClickListener() {/* listener */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemdata = listmsg[position];
                Intent intent = new Intent();
                intent.putExtra("msgdata", itemdata);
                setResult(0, intent);
                finish();
            }
        });
    }
}
