package com.microsoft.altframeworktraining;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.americanairlines.TestAppium.Util;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class StartAppTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedAndroidDriver<MobileElement> driver;

    public static EnhancedAndroidDriver<MobileElement> startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "foo");
        capabilities.setCapability(MobileCapabilityType.APP, "[path to local repo]/Appium/AndroidQAApp/appqa.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        URL url = new URL("http://localhost:4723/wd/hub");

        return Factory.createAndroidDriver(url, capabilities);
    }

   @Test
    public void loginAppTest() throws MalformedURLException, InterruptedException {
        driver = startApp();

		Thread.sleep(12000);
		//Enter user name
		MobileElement elem = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/username"), "+");
		elem.sendKeys("608TFK4");
		Thread.sleep(10000);
		//Enter last name
		MobileElement elem2 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/lastname"), "+");
		elem2.sendKeys("testfenix");
		Thread.sleep(10000);
		//Enter password
		MobileElement elem3 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/password"), "+");
		elem3.sendKeys("testing");
		Thread.sleep(10000);
		//Click on login button
		MobileElement elem4 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/login_button"), "+");
		elem4.click();
		Thread.sleep(10000);
    }
    
   // @Test1
    public void loginAndBookFlightTest() throws MalformedURLException, InterruptedException {
        driver = startApp();

		Thread.sleep(12000);
		//Enter user name
		MobileElement elem = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/username"), "+");
		elem.sendKeys("608TFK4");
		Thread.sleep(10000);
		//Enter last name
		MobileElement elem2 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/lastname"), "+");
		elem2.sendKeys("testfenix");
		Thread.sleep(10000);
		//Enter password
		MobileElement elem3 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/password"), "+");
		elem3.sendKeys("testing");
		Thread.sleep(10000);
		//Click on login button
		MobileElement elem4 = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/login_button"), "+");
		elem4.click();
		Thread.sleep(60000);
		
		//Click on the Flight status
		MobileElement FromAP = Util.findByByOrName(driver, By.xpath("//*/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView"), "+");
		FromAP.click();
		Thread.sleep(5000);
		
/*		//click on the from airport text box 
		MobileElement SearchBoxFromAP = Util.findByByOrName(driver, By.xpath("//android.widget.LinearLayout[@content-desc=\"Opens from search\"]/android.widget.EditText"), "+");
		SearchBoxFromAP.click();
		Thread.sleep(5000);
		
		//Enter Phoenix as origin airport
		MobileElement ListFromAirports = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/airport_name"), "+");
		ListFromAirports.click();
		Thread.sleep(5000);
		ListFromAirports.sendKeys("PHX - Phoenix Sky Harbor Intl, AZ");
		
		Thread.sleep(3000);
		SearchBoxFromAP.click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER );
		Thread.sleep(10000);
		SearchBoxFromAP.click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER );
		Thread.sleep(20000);*/
		
		
		
		//click on the to airport text box and enter Phoenix as origin airports
		//MobileElement ToAP = Util.findByByOrName(driver, By.xpath("//*[@resource-id='com.aa.android.qa:id/to_airport']/android.widget.EditText"), "+");
		////*[@id="selectedElementContainer"]/div/div[2]/div/div[2]/div/div/div/div/div/table/tbody/tr/td[2]
		//FromAP.click();
		//Thread.sleep(5000);
/*		MobileElement SearchBoxToAP = Util.findByByOrName(driver, By.id("com.aa.android.qa:id/airport_name"), "+");
		SearchBoxFromAP.click();
		SearchBoxFromAP.sendKeys("LAX - Los Angeles International, CA");
		//Thread.sleep(3000);
		//SearchBoxFromAP.click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER );
		Thread.sleep(1000);
		//SearchBoxFromAP.click();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER );*/

    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            driver.label("Stopping App");
            driver.quit();
        }
    }
}
