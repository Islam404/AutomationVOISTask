package base;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    protected WebDriverWait wait;

 
    
	private static final Logger LOGGER = Logger.getLogger(PageBase.class);



	   public PageBase(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	    }
	 
	   public String getAttribute(WebDriver driver, By elementLocator, String attributeName) {
			if (isElementVisible(elementLocator)) {
			    String attributeValue = driver.findElement(elementLocator).getAttribute(attributeName);
			    LOGGER.info("Get value for attribute: [ " + attributeName + " ] is: " + attributeValue);
			    return attributeValue;
				} else {
					LOGGER.error("Can't get value for attribute: " + attributeName);
					return null;
				}
		    }
	   public void moveTo(WebDriver driver, By elementLocator) {
			WebElement element = null;
			try {
			    element = driver.findElement(elementLocator);
			    Actions action = new Actions(driver);
			    action.moveToElement(element).perform();

			    LOGGER.info("Moved to element and clicked successfully performed on the element");

			}  catch (Exception e) {
			    LOGGER.error(e.getMessage());
			    LOGGER.error("[Double Click] :Element " + element + " was not clickable " + e.getMessage());

			}
		    }
	public boolean isElementVisible(By elementLocator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			LOGGER.info("Element matching this locator [ " + elementLocator + " ] is visible");
			return true;
		} catch (Exception e) {
			LOGGER.error("Element matching this locator [ " + elementLocator + " ] is not visible");
			return false;
		}
	}
	
	public boolean isElementClickable(By elementLocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			LOGGER.info("Element matching this locator [" + elementLocator + "] is Clickable.");
			return true;
		} catch (Exception e) {
			LOGGER.error("Element matching this locator [" + elementLocator + "] is not Clickable.");
			return false;
		}
	}
	public void setElement( By elementLocator, String value) {

		isElementVisible(elementLocator);
		try {
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			LOGGER.info("Type " + value);
		} catch (Exception e) {
			LOGGER.error("Can't type :" + value);
		}

	}
	
	public void clickElement( By elementLocator) {

		if (isElementClickable(elementLocator)) {
			WebElement element = driver.findElement(elementLocator);
			element.click();
			LOGGER.info("Click on element locator: " + elementLocator);
		} else {
			LOGGER.error("Cannot Click on element locator: " + elementLocator);
		}
	}
	public void controlClick( WebElement link) {
		
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.LEFT_CONTROL).click(link).keyUp(Keys.LEFT_CONTROL).build().perform();
			LOGGER.info("[Control +Click] successfully performed ");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("[Control +Click] : failed due to  " + e.getMessage());

		}
	}
	
	public void pressEnter( By elementLocator) {
		WebElement element = driver.findElement(elementLocator);
		try {
			Actions actions = new Actions(driver);
			element.sendKeys(Keys.ENTER);
			LOGGER.info("[press ENTER] successfully performed ");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("[press ENTER] : failed due to  " + e.getMessage());

		}
	}
	
	public void selectItemFromList(WebDriver driver, By elementLocator, String value) {
		isElementVisible(elementLocator);
		try {
		new Select(driver.findElement(elementLocator)).selectByVisibleText(value);
		LOGGER.info("Select " + value + " : from drop down list");
		} catch (Exception e) {
		LOGGER.error("Can't select :" + value);
		}
		}
	
	public void selectTab(String window) {
		
		driver.switchTo().window(window);
	}
	
	public String getCurrentWindow() {
		
		return driver.getWindowHandle();
		
	}
	

	public  Set<String> getAllWindows() {
		
		return driver.getWindowHandles();
		
	}

}
