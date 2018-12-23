package com.example.pengxuanping.databasejunit;

import junit.framework.Assert;

import org.junit.Test;
/*
* eg -> concept, Q -> A, what -> how & why (retrieve)
* 1. app/build.gradle -> dependencies -> junit:4.12
* 2. app/test/java/ -> creat class file -> new obj -> execute methed -> validate result
* */

public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator(); //new obj
        int sum = calculator.add(1, 2);//execute methed
        Assert.assertEquals(3, sum); //validate result
    }

}
