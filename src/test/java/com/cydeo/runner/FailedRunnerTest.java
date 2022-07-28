package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/jira-report.json",
                "rerun:target/rerun.txt"
        },
        //features: Path of features to be executed
        features = "@target/rerun.txt",
        //glue: Step definitions location
        glue = "com/cydeo/step_definition"
)
public class FailedRunnerTest {
}
