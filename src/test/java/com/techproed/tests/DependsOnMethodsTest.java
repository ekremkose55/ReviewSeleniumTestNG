package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class DependsOnMethodsTest extends TestBase {


    @Test (priority = 1)
    public void test1(){
        System.out.println("Test01");

    }

    @Test (priority = 2, dependsOnMethods = "test1")
    public void test2(){
        System.out.println("Test02");
    }

    @Test (priority = 3)
    public void test3(){
        System.out.println("Test03");
    }


}
