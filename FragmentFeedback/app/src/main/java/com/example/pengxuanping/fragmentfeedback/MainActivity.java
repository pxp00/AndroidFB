package com.example.pengxuanping.fragmentfeedback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/* fragment of Act;need a container(FrameLayout) put it; remove, replace, addToBackStack()*/
/* act getSupportFragmentManager.beginTransaction. replace.addToBackStack.commit */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbt_replace = null;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* need add 1st fragment to backstack */
        replaceFragment(new FragmentRight());
        mbt_replace = findViewById(R.id.bt_replace);
        mbt_replace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_replace:
                replaceFragment(new FragmentOther());
                break;

            default:
                break;
        }
    }

    void replaceFragment(Fragment fragment){
        FragmentManager manager  = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        /* container view id(framelayout), fragment */
        transaction.replace(R.id.flt_R, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
