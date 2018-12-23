package com.example.pengxuanping.test;

/*
IOexception (checked exception)
RuntimeException

*/
public class MyException extends RuntimeException{
    public MyException(String ErrMsg) {
        super(ErrMsg);
    }
}
