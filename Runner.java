package utilities;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		features={"src/test/java/featuresFiles/Login.feature"},
						glue= {"src/test/java/stepDefinitions"})
public class Runner {

}
