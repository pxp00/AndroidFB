package com.example.pengxuanping.eventbus;

/* bean(structure, container) mtd & field in common use */
/* code -> generate/ fn + F11(insert) + alter  */
public class FirstEvent {
     private String mMsg;
     FirstEvent(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
