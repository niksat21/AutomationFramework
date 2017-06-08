package com.testScripts;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Created by niksat21 on 2/21/2017.
 */
public class LoginSuit {



    //JUnit Suite Test
    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            ValidLoginTest.class ,InvalidLoginTest.class
    })

    public class LoginSuite {
    }
}
