package com.n26;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.n26.CustomListener.TestngListener;

import java.lang.reflect.Method;

@Listeners(value = {TestngListener.class})
public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("STARTING TEST: " + method.getName());
    }
    
}
