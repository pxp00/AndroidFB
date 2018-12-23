package com.example.pengxuanping.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
if class_x inherit RuntimeException thow new class_x no need use thows class_x,
    1. have not throws class_x, will it throw sys directly or throws to superior function ?
        a. yes, it will stop to run the remain code, throws runtimeexception to system
    2. if have throws class_x, it will throws to superior, but if superior have not throws or try-catch it will throws to sys directly;

if inherit Exception must be throws class_x or try-catch deal with the exception
    a. will throws to superior, will run the superior's code before exception occer
    it must be try-catch or throws to superior

finally, return of finally, return of try or catch, code block after return of try or catch
    1. code of block after return of try or catch
    2. code of finally before finallly return;
    3. return of finally
    4. return of try or catch
    5. Q, if try and catch have return, which one will be run ?


*/

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public int handleException(int a, int b) throws MyException {

        Log.d(TAG, "handleException: " +"before throw  exception");
        if (a < b) {
            throw new MyException("result is minus");
        }
        Log.d(TAG, "handleException: " +"after throw runtime exception");
        return a - b;
    }

    public int handleException1(int a) throws MyException{

        Log.d(TAG, "handleException1: " +"after throw  exception");
        /*return of try & catch  which one will be run*/
        try {
            Log.d(TAG, "handleException1: try");
            return 5; /* will not be run */

        } catch (MyException e) {
            String sa =  e.getMessage();
            Log.d(TAG, "handleException1: try"  + sa);
            return 2;
        } finally {
            Log.d(TAG, "handleException1: finally");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int  ret = handleException1(3);
        Log.d(TAG, "onCreate: ret = " + ret);

    }
}

