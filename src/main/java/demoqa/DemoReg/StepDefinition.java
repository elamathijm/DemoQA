package demoqa.DemoReg;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {
	static WebDriver driver;
	Select s;
	
	@Given("^The user is in demoqa reg page$")
	public void the_user_is_in_demoqa_reg_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\New folder (2)\\DemoReg\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
	    
	}

	@When("^The user enters the firstname$")
	public void the_user_enters_the_firstname() throws Throwable {
		driver.findElement(By.id("name_3_firstname")).sendKeys("elamathi");
	   
	}

	@Then("^The user validate the firstname$")
	public void the_user_validate_the_firstname() throws Throwable {
		Assert.assertEquals(driver.findElement(By.id("name_3_firstname")).getAttribute("value"), "elamathi");
	    
	}

	@When("^The user enters the lastname$")
	public void the_user_enters_the_lastname() throws Throwable {
	   driver.findElement(By.id("name_3_lastname")).sendKeys("manoharan");
	}

	@Then("^The user validate the lastname$")
	public void the_user_validate_the_lastname() throws Throwable {
	   Assert.assertEquals(driver.findElement(By.id("name_3_lastname")).getAttribute("value"), "manoharan");
	}

	@When("^The user selects the country as india$")
	public void the_user_selects_the_country_as_india() throws Throwable {
		WebElement drpDnCountry=driver.findElement(By.id("dropdown_7"));
		 s=new Select(drpDnCountry);
		 s.selectByVisibleText("India");		
	    
	}

	@Then("^The user validate the selected country$")
	public void the_user_validate_the_selected_country() throws Throwable {
	   WebElement option=s.getFirstSelectedOption();
	   Assert.assertEquals(option.getAttribute("value"), "India");
	}


}
