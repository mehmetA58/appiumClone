package appium;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

        @Test
        public void test() throws MalformedURLException, InterruptedException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //3.yontem
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
            desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/asus/IdeaProjects/appiumKURULUM/Apps/gestureTool.apk");
            //noReset
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

            Thread.sleep(4000);


            //id ile bulduk
            // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
            // id bu sekilde de yazabilirsiniz
            // driver.findElementById("addButton").click();
            // xpath index ile bulduk
            // driver.findElementByXPath("(//android.widget.Button)[2]").click();
            // xpath text
           //  driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();


             /*soru :
                lunch GestureTool app
                click test button
                verify title "Test a gesture"
                close app

            */
                driver.findElementByXPath("//android.widget.Button[@text='Test']").click();
            String expetedTitle = "Test a gesture";
            String actualTitle = driver.findElementById("android:id/title").getText();

            Assert.assertEquals(actualTitle,expetedTitle);

            if (actualTitle.equals(expetedTitle)) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }


        }
}
