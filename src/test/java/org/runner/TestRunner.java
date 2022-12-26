package org.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources", glue="org.stepdefinition",monochrome=true,dryRun=false,plugin={"json:target/cucumber/cumcumber.json"})
public class TestRunner {

}
