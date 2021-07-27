package com.cucumber.testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/java/com/cucumber/feature"
 ,glue= {"com.cucumber.stepDefinition"}
 ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
 ,monochrome=true
 ,dryRun = false

		
 )
public class TestRunner {

}
