package com.example.pengxuanping.msghelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Contact extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final String[] acontact = {
                "13200000000",
                "13200000001",
                "13200000002",
                "13200000003",
                "13200000004",
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        ListView lv_contact = findViewById(R.id.lv_contact);
        lv_contact.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,acontact));
        lv_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String contact = acontact[position];
                Intent intent = new Intent();
                intent.putExtra("contact", contact);
                setResult(1, intent);
                finish();/* need close current activity */
            }
        });
    }
}
