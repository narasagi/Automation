/**
 * 
 */
package utility;




import java.net.URL; 
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.app.pages.StepsToOnBoardPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author narasimhulu.sagi
 *
 */
public class BaseClass {
public BaseClass(){
		
	}
	
	public static AppiumDriver<AndroidElement> setUp() throws Exception {
		AppiumDriver<AndroidElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ce081718a105541f027e");
		capabilities.setCapability(CapabilityType.VERSION, "9.0.0");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage", "com.climate.farmrise");
		capabilities.setCapability("appActivity", "com.climate.farmrise.SplashScreen");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(15000);
		driver.findElementByXPath(StepsToOnBoardPage.LANGUAGE.toString()).click();
		driver.findElementById(StepsToOnBoardPage.PROCEED.toString()).click();
		driver.findElementById(StepsToOnBoardPage.AGREE_TERMS_CONDITIONS.toString()).click();
		Thread.sleep(7000);

		return driver;
	}
}
