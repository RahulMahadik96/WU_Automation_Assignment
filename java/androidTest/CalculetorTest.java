package androidTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class CalculetorTest {
	
	//To find the app packeg name and app activiti we can use the following command
	// Command: adb shell dumpsys window | find "mCurrentFocus"
    
	static AppiumDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "OnePlus Nord CE 2");
		cap.setCapability("udid", "VSR8BARKYLHMIZGA");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("appPackage", "com.oneplus.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("automationName", "UiAutomator2");
		
		URL url=new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver(url, cap);
		
		
		WebElement element= driver.findElement(By.id("com.oneplus.calculator:id/digit_4"));
		element.click();
		driver.findElement(By.id("com.oneplus.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.oneplus.calculator:id/digit_8")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equals\"]")).click();
		
		String multipicationIs=driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
		
		System.out.println("Multipication is: "+multipicationIs);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().perform();
	
        
		
		
		new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.A);
	  
        new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.A);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
