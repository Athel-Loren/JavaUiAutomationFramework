package com.opencart.stepdefinitions;


import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    @BeforeAll
    public static void theMethodExecutedBeforeAllTests(){
        System.out.println("The Test Execution started");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("A new Test Execution started");
    }
    @After
    public void afterEachTest(){
        DriverManager.getInstance().deleteCookies();
        System.out.println("A Test Execution just finished");
    }

    @AfterAll
    public static void afterAll(){
        DriverManager.getInstance().tearDown();
        System.out.println("The Test Execution has been finished");
    }
}
