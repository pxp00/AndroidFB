package com.example.pengxuanping.msghelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQ_CONTACT = 0;
    private static final int REQ_MSG = 1;
    private Button bt_contact;
    private Button bt_selectMsg;
    private SharedPreferences sp;
    private EditText et_contact;
    private EditText et_msg;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_contact:
                Intent intent = new Intent(this, Contact.class);
                startActivityForResult(intent, REQ_CONTACT);
                break;
            case R.id.bt_selectMsg:
                Intent msgintent = new Intent(this, Msg.class);
                startActivityForResult(msgintent, REQ_MSG);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQ_MSG == requestCode) {

            String msgdata = data.getStringExtra("msgdata");

            et_msg.setText(msgdata);
        } else {
            String contactdata = data.getStringExtra("contact");
            et_contact.setText(contactdata);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* multi_click */
        bt_contact = findViewById(R.id.bt_contact);
        bt_selectMsg = findViewById(R.id.bt_selectMsg);
        bt_contact.setOnClickListener(this);
        bt_selectMsg.setOnClickListener(this);
        et_contact = findViewById(R.id.et_phoneNum);
        et_msg = findViewById(R.id.et_msg);
        sp = getSharedPreferences("msgheper", Context.MODE_PRIVATE);
        et_contact.setText(sp.getString("contact", " "));
        et_msg.setText(sp.getString("msg", " "));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor edt = sp.edit();
        String contactdata = et_contact.getText().toString().trim();
        String msgdata = et_msg.getText().toString().trim();

        edt.putString("contact", contactdata);
        edt.putString("msg", msgdata);
        edt.commit();

    }
}
