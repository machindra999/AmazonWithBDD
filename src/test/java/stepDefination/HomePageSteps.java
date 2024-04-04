package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePage;

public class HomePageSteps {
	WebDriver driver;
	HomePage homepage = new HomePage(DriverFactory.getDriver());
	
	
	@Given("user is at the amazonhome page")
	public void user_is_at_the_amazonhome_page() {
	   driver = DriverFactory.getDriver();
	   
	   driver.get("https://www.amazon.in/");
	   
	   driver.navigate().refresh();
	}

	@Then("page title should contains {string}")
	public void page_title_should_contains(String string) {
		String title = homepage.fetchTitle();
		
	boolean	isPresent = title.contains(string);
	Assert.assertEquals(isPresent, true);
	}

	@Then("cart icon should get display")
	public void cart_icon_should_get_display() {
	 boolean isDisplaying = homepage.isCartDisplayed();
	 
	 Assert.assertEquals(isDisplaying, true);
	}

	@When("user search {string} from text field")
	public void user_search_from_text_field(String string) {
		homepage.searchProduct(string);
		
	}
	    

	@Then("user should see mobiles")
	public void user_should_see_mobiles() {
	 
		homepage.checkMobileOnPage();
	  String title = driver.getTitle();
	    
	  boolean isPresent = title.contains("mobile");
	  
	  Assert.assertEquals(isPresent, true);
	    
	}

	@When("user click on mobile")
	public void user_click_on_mobile() {
	    homepage.clickOnMobile();
	}

	@Then("mobile page should get open")
	public void mobile_page_should_get_open() {
	 String title = homepage.navToMobilePage();
	 
	boolean isPresent = title.contains("Samsung");
	
	Assert.assertEquals(isPresent, true);
	 
	}

}
