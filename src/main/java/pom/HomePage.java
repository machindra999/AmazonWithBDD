package pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='nav-cart']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	WebElement searchTextField;
	
	@FindBy(xpath = "//*[@id='nav-search-submit-button']")
	WebElement searchButton;
		
	@FindBy(xpath = "//*[contains(text(),'Samsung Galaxy M14 5G (ICY Silver')]/parent::a")
	WebElement samsungPhone;
	
	WebDriverWait wait;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}
	
	
	public String fetchTitle()
	{
		String title = driver.getTitle();
		
		return title;
	}
	
	public boolean isCartDisplayed()
	{
		boolean isGettingDisplayed = cartIcon.isDisplayed();
		
		return isGettingDisplayed;
	}
	
	public void searchProduct(String productname)
	{
		searchTextField.sendKeys(productname);
		
		searchButton.click();
		
	}
	
	public void checkMobileOnPage()
	{
		wait.until(ExpectedConditions.titleContains("mobile"));
	}
	
	public void clickOnMobile()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		samsungPhone.click();
	}
	
	public String navToMobilePage()
	{
		String titleOfPage = "";
		String parentId = driver.getWindowHandle();
		
		Set<String> allWinId = driver.getWindowHandles();
		
		for(String winId :allWinId)
		{
			if(!(winId.equals(parentId)))
			{
				driver.switchTo().window(winId);
				wait.until(ExpectedConditions.titleContains("Samsung"));
			 titleOfPage = driver.getTitle();
			}
		}
		
		return titleOfPage;
	}
	
	
	
	
	

	
}
