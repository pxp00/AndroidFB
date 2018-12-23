package com.example.pengxuanping.s_handler;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/*
1. 将json格式的字符串{}转换为Java对象, 使用原生API
2. 将json格式的字符串{}转换为Java对象, 使用GSON
3. 将json格式的字符串[]转换为Java对象的List, 使用原生API
4. 将json格式的字符串[]转换为Java对象的List, 使用GSON

5. 将Java对象转换为json字符串{}, 使用GSON
6. 将Java对象的List转换为json字符串[], 使用GSON
 */
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.pengxuanping.s_handler", appContext.getPackageName());
    }


}
