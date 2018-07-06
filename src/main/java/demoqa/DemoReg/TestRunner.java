package demoqa.DemoReg;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/NewDemoReg.feature",tags= {"@smoke"})

public class TestRunner {
	

}
