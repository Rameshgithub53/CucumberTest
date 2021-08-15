package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(		features={"src/test/java/features/Login.feature"},
						glue= {"stepDefination"})

public class LoginRunner extends AbstractTestNGCucumberTests{

}
