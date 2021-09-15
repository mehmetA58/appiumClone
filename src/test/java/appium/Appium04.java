package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //3.yontem
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/asus/IdeaProjects/appiumKURULUM/Apps/gestureTool.apk");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

        //close app
             /* soru :
            //    lunch GestureTool app
            //    click addGesture button
            //    send text to name box "testing"
            //    click done
            //    verify testing gesture is created
            //     */

        //    click addGesture button
        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(2000);

        //    send text to name box "testing"
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("testing");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(1000);

        //    click done
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(2000);

        //    verify testing gesture is created
        String expectedText = "testing";
        String actualText = driver.findElementByXPath("//android.widget.TextView[@text='testing']").getText();
        Assert.assertEquals(actualText,expectedText);



    }

}
