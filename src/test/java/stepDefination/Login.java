package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;

	@Test
	@Given("User Opening the Browser and Entering the URL")
	public void user_opening_the_browser_and_entering_the_url() {

		System.out.println("This is Given Method");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.dnbdecisionmaker.com/dm/index.jsp");
		//Clicking on SignIn Link
		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		//Clicking on Sign In With WebAccessID
		driver.findElement(By.xpath("//span[normalize-space()='Sign In with Web Access ID']")).click();
		
	}

	@Test
	@When("User Enters the UserName2 and Password2")
	public void user_enters_the_user_name2_and_password2() {

		System.out.println("This is When Method");
		//Entering the UserName
		driver.findElement(By.xpath("//input[@id='idp-discovery-username']")).sendKeys("testprodgdmuser@gmail.com");
		//Clciking on Continue button
		driver.findElement(By.xpath("//input[@id='idp-discovery-submit']")).click();
		//Entering the Password
		driver.findElement(By.xpath("//input[@id='okta-signin-password']")).sendKeys("Password123");
		//Clicking on Continue Button
		driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
		String titile=driver.getTitle();
		System.out.println("Page Titile is:"+titile);
	}

	@Test
	@Then("Verifying the Titile of the Page")
	public void verifying_the_titile_of_the_page() throws InterruptedException {

		System.out.println("This is Then Method");
		
		Assert.assertEquals("dnb - Sign In", driver.getTitle());
		Thread.sleep(5000);
		driver.close();
	}
}
