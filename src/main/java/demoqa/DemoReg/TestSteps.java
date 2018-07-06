package demoqa.DemoReg;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestSteps {
	
	static WebDriver driver;
	static WebElement drpDnCountry,drpMonth,drpDay,drpYear,option,option1,option2,option3;
	Select s,s1,s2,s3;
	
	@Given("^The user is in demoqa registration page$")
	public void the_user_is_in_demoqa_registration_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\New folder (2)\\DemoReg\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
		   
	}

	@When("^The user enters the firstname \"([^\"]*)\",lastname \"([^\"]*)\",phonenumber \"([^\"]*)\",username \"([^\"]*)\",email \"([^\"]*)\",password \"([^\"]*)\",confirmpassword \"([^\"]*)\"$")
	public void the_user_enters_the_firstname_lastname_phonenumber_username_email_password_confirmpassword(String fname, String lname, String phno, String uname, String email, String pwd, String conpwd) throws Throwable {
		driver.findElement(By.id("name_3_firstname")).sendKeys(fname);
		driver.findElement(By.id("name_3_lastname")).sendKeys(lname);
		driver.findElement(By.id("phone_9")).sendKeys(phno);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("email_1")).sendKeys(email);
		driver.findElement(By.id("password_2")).sendKeys(pwd);
		driver.findElement(By.id("confirm_password_password_2")).sendKeys(conpwd);
		
	  
	}

	@Then("^The user validates the entered firstname \"([^\"]*)\",lastname \"([^\"]*)\", phonenumber \"([^\"]*)\", username \"([^\"]*)\", email \"([^\"]*)\",password \"([^\"]*)\",confirmpassword \"([^\"]*)\"$")
	public void the_user_validates_the_entered_firstname_lastname_phonenumber_username_email_password_confirmpassword(String fname, String lname, String phno, String uname, String email, String pwd, String conpwd) throws Throwable {
		Assert.assertEquals(fname,driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals(lname,driver.findElement(By.id("name_3_lastname")).getAttribute("value"));
		Assert.assertEquals(phno,driver.findElement(By.id("phone_9")).getAttribute("value"));
		Assert.assertEquals(uname,driver.findElement(By.id("username")).getAttribute("value"));
		Assert.assertEquals(email,driver.findElement(By.id("email_1")).getAttribute("value"));
		Assert.assertEquals(pwd,driver.findElement(By.id("password_2")).getAttribute("value"));
		Assert.assertEquals(conpwd,driver.findElement(By.id("confirm_password_password_2")).getAttribute("value"));
		
	    
	}

	@When("^The user clicks the marital status$")
	public void the_user_clicks_the_marital_status(DataTable status) throws Throwable {
		
		List<String> mydata=status.asList(String.class);
		WebElement radio=driver.findElement(By.xpath("//input[@value='single']"));
		if(radio.getAttribute("value").equalsIgnoreCase(mydata.get(0)))
		{
		    radio.click();
			
		}
	    
	}

	@Then("^The user validates the selected marital status$")
	public void the_user_validates_the_selected_marital_status() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='single']")).isSelected());
	}

	@When("^The user clicks the hobby$")
	public void the_user_clicks_the_hobby(DataTable hobby) throws Throwable {
		List<List<String>> mylist=hobby.asLists(String.class);
		List<WebElement> w=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<w.size();i++)
		{
			if(w.get(i).getAttribute("value").equalsIgnoreCase(mylist.get(0).get(0)) || w.get(i).getAttribute("value").equalsIgnoreCase(mylist.get(0).get(1)))
					{
						w.get(i).click();
					}
		}
	    
	}

	@Then("^The user validates the selected hobbies$")
	public void the_user_validates_the_selected_hobbies() throws Throwable {
		
		
	    
	}

	@When("^The user selects the country name \"([^\"]*)\" and dateofbirth month \"([^\"]*)\" , day \"([^\"]*)\" and year \"([^\"]*)\"$")
	public void the_user_selects_the_country_name_and_dateofbirth_month_day_and_year(String country, String month, String day, String year) throws Throwable {
	 drpDnCountry=driver.findElement(By.id("dropdown_7"));
	 s=new Select(drpDnCountry);
	 s.selectByVisibleText(country);
	 drpMonth=driver.findElement(By.id("mm_date_8"));
	 s1=new Select(drpMonth);
	 s1.selectByVisibleText(month);
	 drpDay=driver.findElement(By.id("dd_date_8"));
	 s2=new Select(drpDay);
	 s2.selectByVisibleText(day);
	 drpYear=driver.findElement(By.id("yy_date_8"));
	 s3=new Select(drpYear);
	 s3.selectByVisibleText(year);
	     
	}

	@Then("^The user validates the selected country  \"([^\"]*)\" and dateofbirth month \"([^\"]*)\" , day \"([^\"]*)\" and year \"([^\"]*)\"$")
	public void the_user_validates_the_selected_country_and_dateofbirth_month_day_and_year(String country, String month, String day, String year) throws Throwable {
		option=s.getFirstSelectedOption();
		Assert.assertEquals(country, option.getText());
		option1=s1.getFirstSelectedOption();
		Assert.assertEquals(month, option1.getText());	
		option2=s2.getFirstSelectedOption();
		Assert.assertEquals(day, option2.getText());
		option3=s3.getFirstSelectedOption();
		Assert.assertEquals(year, option3.getText());
		
	}



}
