package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	
	WebDriver driver;
	
	WebDriverWait wait;
	@FindBy(xpath = "//*[@id='nav-cart']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//*[contains(text(),'Sign in to your account')]/parent::a")
	WebElement signinToAccount;
	
	
	
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}
	
	
	public void clickOnIcon()
	{
		cartIcon.click();
	
	}
	
	public void clickOnsignIn()
	{
		wait.until(ExpectedConditions.visibilityOf(signinToAccount));
		signinToAccount.click();
	}

}
