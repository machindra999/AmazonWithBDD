package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
//		features = {"src\\test\\resources\\uifeature\\Homepage.feature"},
		
		features = {"@target/failedrerun.txt"},
		
		glue = {"stepDefination"},
		
		plugin = {"pretty", "html:target/cucumber-reports/AmazonTestResults.html"
				
		, "rerun:target/failedrerun.txt"},
		
		publish = true
		
		)

public class AmazonFailedRunner extends AbstractTestNGCucumberTests
{

}
