package com.example.pengxuanping.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_1;
    @Override/* entire lifetime */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");

        bt_1 = findViewById(R.id.bt_1);
        bt_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, first.class);
        startActivity(intent);
    }

    @Override /* visible lifetime (background run) */
    protected void onStart() {/* ppdp, public -> protected(package itself class + child class) ->default -> private(class itself) */
        super.onStart();
        System.out.println("onstart");
    }

    @Override/* foreground  lifetime (alter dialog) */
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    /* visable, on stack; currentAct -> DailogAct */
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override /* invisible, on stack; CurAct -> OtherAct */
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override/* CurAct out of stack */
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override/* menu -> click app/ otherAct -> CurAct */
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }
}
