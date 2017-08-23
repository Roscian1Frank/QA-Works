package com.qaworks.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        plugin = {"pretty","html:target/cucumber-html-report"},
        glue = {"com.qaworks.steps"},
        tags = {"@regression"})
public class RunTest {

}


