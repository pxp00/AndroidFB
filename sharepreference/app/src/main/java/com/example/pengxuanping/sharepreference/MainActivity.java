package demo.liuchen.com.welcomepager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pengxuanping.sharepreference.R;

public class MainActivity extends AppCompatActivity {
    private EditText meditText1, meditText2;
    private Button SaveBtn, GetBtn;
    //声明Sharedpreferenced对象
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meditText1 = (EditText) findViewById(R.id.edit1);
        meditText2 = (EditText) findViewById(R.id.edit2);
        SaveBtn = (Button) findViewById(R.id.btn_Save);
        GetBtn = (Button) findViewById(R.id.btn_Get);
    }

    public void Click(View view) {
        /**
         * 获取SharedPreferenced对象
         * 第一个参数是生成xml的文件名
         * 第二个参数是存储的格式（**注意**本文后面会讲解）
         */
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        switch (view.getId()) {
            case R.id.btn_Save:
                //获取到edit对象
                SharedPreferences.Editor edit = sp.edit();
                //通过editor对象写入数据
                edit.putString("Value", meditText1.getText().toString().trim());
                //提交数据存入到xml文件中
                edit.commit();
                break;
            case R.id.btn_Get:
                //取出数据,第一个参数是写入是的键，第二个参数是如果没有获取到数据就默认返回的值。
                String value = sp.getString("Value", "Null");
                meditText2.setText(value);
                break;
        }
    }
}