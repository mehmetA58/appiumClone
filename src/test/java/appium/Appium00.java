package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium00 {
    /*
    arama:
    uygulamayi ac
    bir numara  ara ve aramayi bitir.
    app kapat
     */

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "phone");
        //desiredCapabilities.setCapability("chromedriverExecutable", "com.google.android.apps.nexuslauncher:id/icon");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        //Thread.sleep(4000);

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Phone\"]").click();



        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"key pad\"]").click();

       // Thread.sleep(2000);
        AndroidElement num0 = driver.findElementById("com.android.dialer:id/zero");
        AndroidElement num1 = driver.findElementById("com.android.dialer:id/one");
        AndroidElement num2 = driver.findElementById("com.android.dialer:id/two");
        AndroidElement num3 = driver.findElementById("com.android.dialer:id/three");
        AndroidElement num4 = driver.findElementById("com.android.dialer:id/four");
        AndroidElement num5 = driver.findElementById("com.android.dialer:id/five");
        AndroidElement num6 = driver.findElementById("com.android.dialer:id/six");
        AndroidElement num7 = driver.findElementById("com.android.dialer:id/seven");
        AndroidElement num8 = driver.findElementById("com.android.dialer:id/eight");
        AndroidElement num9 = driver.findElementById("com.android.dialer:id/nine");

        num1.click();
        num6.click();
        Thread.sleep(500);
        num6.click();

        Thread.sleep(1000);

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"dial\"]").click();
       // Assert.assertEquals(expectedResult,"166");
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"End call\"]").click();
    }
}