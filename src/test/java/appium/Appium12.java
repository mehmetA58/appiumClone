package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Appium12 extends AppiumBase {
    /*soru:
    app ac(API Demos)
    APi demos
    Preference
    sonra Preference form code
    =>tkla Checkbox preference secili olmali ve onayla
    =>Edit text preference tikla
    yazi yaz ve OK tikla
    => List preference tikla ce Option3 sec
     */
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        // API Demos tıkla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(2000);

        // Preference tıkla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);

        // 5. Preference form code tıkla
        driver.findElementByXPath("//android.widget.TextView[@text='5. Preferences from code']").click();
        Thread.sleep(2000);

        // Checkbox preference tıkla
        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        if (isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();
            Thread.sleep(2000);
        }

        /*hocanin ekstra
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(false)");
        List<MobileElement> list1 = driver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checked(true)");
        System.out.println(list.size());
        System.out.println(list1.size());
        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        if (isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();
            Thread.sleep(2000);
        }

         */

        // Checkbox preference tikli olduğunu onayla
        isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        Assert.assertTrue(isChecked.equals("true"));

        // Edit text preference tıkla
        driver.findElementByXPath("//android.widget.TextView[@text='Edit text preference']").click();
        Thread.sleep(2000);

        // yazi sil
        driver.findElementById("android:id/edit").clear();
        Thread.sleep(1000);

        // yazi yaz
        driver.findElementById("android:id/edit").sendKeys("EditText");
        Thread.sleep(1000);

        // OK tikla
        driver.findElementById("android:id/button1").click();

        // => List preference tikla ce

        driver.findElementByXPath("//android.widget.TextView[@text='List preference']").click();
        Thread.sleep(2000);

        // Option3 sec
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Charlie Option 03']").click();


    }
}

