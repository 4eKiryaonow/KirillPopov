package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features/"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
