package com.cybertek.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com/cybertek/library/step_difinitions",
        plugin = "html:target/cucumber-report.html",
        dryRun = false,
        tags = "@TC10 or @TC05"


)



public class CuckesRunner {
}
