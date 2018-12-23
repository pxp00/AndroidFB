package com.example.pengxuanping.databasejunit;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pengxuanping.databasejunit.dao.SQLiteDao;

/* AppCompatActivity-> FragmentActivity ->  ...SupportActivity -> Activity -> ContextThemeWrapper -> ContextWrapper-> Context -> Object */
/* view -> Object */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btsave, btquery;
    private EditText etname, etsex,etdisp;
    private SQLiteDao sqlitedao;
    private DataBaseContext dbctx;

    /* text vs string ?*/
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbctx = new DataBaseContext(this);
        sqlitedao = new SQLiteDao(dbctx);

//        sqlitedao.update("lisa", "male");
//        sqlitedao.select("lisa");
//        sqlitedao.delete("lisa");

        /* Q: onclick ? A: button id set on listener list -> press button trigger listener -> onclick method handle (V.getId() == R.id.xx)
         * findViewById id to view ->setOnClickListener -> View.OnClickListner -> onClick(View v) -> v.getId() == R.id.btsave (view to id)*/
        btsave = findViewById(R.id.bt_save);
        btquery = findViewById(R.id.bt_query); // id -> view, findViewById
        etname = findViewById(R.id.et_name); // id -> view, findViewById
        etsex = findViewById(R.id.et_sex); // id -> view, findViewById
        etdisp = findViewById(R.id.et_disp);

        btsave.setOnClickListener(this);
        btquery.setOnClickListener(this);

    }
    public void onClick(View v) {
        String name, sex;
        /* Q: diff button ? A: v.getId */
        name = etname.getText().toString().trim();
        sex = etsex.getText().toString().trim();

       switch (v.getId()){ // view -> id, getId

           case R.id.bt_save:
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sex)){
                    sqlitedao.insert(name, sex);

                }else{
                    Toast.makeText(this, "input name or sex err !", Toast.LENGTH_SHORT).show();
                }
                break;

           case R.id.bt_query:
                if(!TextUtils.isEmpty(name)){
                    sex = sqlitedao.select(name);
                    etdisp.setText(sex);
                }
                break;


           default:

               break;
       }


    }
}
