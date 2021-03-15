package com.cybertek.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "@target/rerun.txt",
        glue = "com/cybertek/library/step_difinitions"



)



public class FailedTestRunner {
}
