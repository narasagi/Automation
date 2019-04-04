/**
 * 
 */
package com.app.tests;

import static io.appium.java_client.touch.WaitOptions.waitOptions; 
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.app.pages.HomePage;
import com.app.pages.MoreTabPage;
import com.app.pages.StepsToOnBoardPage;
import com.testdata.GovernmentSchemeSearchData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import utility.AppContext;
import utility.BaseClass;

/**
 * @author narasimhulu.sagi
 *
 */
public class HomeAndMoreTabTest {
	
	public AppiumDriver<AndroidElement> driver;
	static Dimension size;
	
	@BeforeTest
	public void startApp() throws Exception {
		driver = BaseClass.setUp();
	}
	@Test(priority = 0)
	public void clickOnHomeButton() {
		for (int i = 0; i < 4; i++) {
			driver.findElementById(StepsToOnBoardPage.OK.toString()).click();	
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementById(HomePage.HOME_BUTTON.toString()).click();
		
	}
	@Test(priority = 1)
	public void clickOnAccessWeatherDetails() {
		driver.findElementById(HomePage.ACCESS_WEATHER_DETAILS.toString()).click();
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);   
	}
	@Test(priority = 3)
	public void scrollHorizontal() throws Exception {

		  for(int i=0; i<=4; i++){
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);   
		   if(driver.findElementsByClassName(HomePage.HORIZONTAL_SCROLL.toString()).size()!= 0){
			   scrollView(driver, 0.70, 0.30, 2000);
		    driver.findElement(By.name("11 PM")).isDisplayed();
		    break;
		   }
		  }
		  String verifyHours = driver.findElementByXPath(HomePage.VERIFY_HOURS.toString()).getText();
		  System.out.println("Text Value : " +verifyHours);
			if (verifyHours.contains("11 PM")) {
				System.out.print("Yes");
				}else{
				System.out.print("No");
			}
	}
	@Test(priority = 4)
	public void clickOnMoreTabButton() {
		driver.findElementById(MoreTabPage.MORE_BUTTON.toString()).click();

	}
	@Test(priority = 5)
	public void clickOnGovernmentSchemesLink() {
		driver.findElementById(MoreTabPage.GOVERNMENT_SCHEMES_LINK.toString()).click();

	}
	@Test(priority = 6)
	public void scrollToBottom() throws Exception {
		for (int i = 0; i < 4; i++) {
			if(driver.findElementsByClassName(MoreTabPage.VERTICAL_SCROLL.toString()).size()!= 0){
			scrollView(driver, 0.80, 0.20, 2000);
			}
		}
	}
	@Test(priority = 7)
	public void enterInputDataInSearchField() {
		GovernmentSchemeSearchData schemes = AppContext.getInstance().get("settings", GovernmentSchemeSearchData.class);
		driver.findElementById(MoreTabPage.SEARCH.toString()).sendKeys(schemes.getSearchField()+"\n");
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
		 driver.hideKeyboard();
		String verifyText = driver.findElementByXPath(MoreTabPage.VERIFY_TEXT.toString()).getText();
		System.out.println("Text Value : " +verifyText);
		if (verifyText.contains("Weather Based Crop Insurance Scheme (WBCIS) ")) {
			System.out.print("Yes");
			}else{
			System.out.print("No");
		}

	}
	@SuppressWarnings("rawtypes")
	public static void scrollView(AppiumDriver<AndroidElement> driver, double startPercentage, double finalPercentage,
			int duration) throws Exception {
		size = driver.manage().window().getSize();
		int width = (int) (size.width / 2);
		int startPoint = (int) (size.getHeight() * startPercentage);
		int endPoint = (int) (size.getHeight() * finalPercentage);
		new TouchAction(driver).press(point(width, startPoint)).waitAction(waitOptions(Duration.ofMillis(duration)))
				.moveTo(point(width, endPoint)).release().perform();

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
