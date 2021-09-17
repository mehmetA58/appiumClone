package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

    /*soru:
   Lunch API Demos =>Preference =>
   Preference dependencies

   WiFi check box
   checkbox checked/unchecked onayla

   WiFi setting
   yazi kutusuna yazı gönder

   Radio Button ==>ayni özellikte calisir
   */
public class Appium11 extends AppiumBase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();


        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        // 1.yol checkBox :Mesut cozum
        //String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
//
        //if (isChecked.equals("false")) {
        //    driver.findElementById("android:id/checkbox").click();
        //    Thread.sleep(2000);
        //}
//
        //driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        //Thread.sleep(2000);
//
        //driver.findElementByClassName("android.widget.EditText").clear();
        //Thread.sleep(1000);
//
        //driver.findElementByClassName("android.widget.EditText").sendKeys("android.widget.EditText");
        //Thread.sleep(1000);
//
        //// Click ok
        //driver.findElementById("android:id/button1").click();

        // 2.yol Wifi Settings e gore list kullanarak
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Wifi settings\").enabled(false)");

        if (list.size() > 0) { ///sayfada element varsa demek
            String isEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Wifi settings\").enabled(false)").getAttribute("enabled");
            if (isEnabled.equals("false")) {
                driver.findElementById("android:id/checkbox").click();

            }

            // 3.yol list kullanmadan

            //String isEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Wifi settings\").enabled(false)").getAttribute("false");
            // if (isEnabled.equals("false")) {
            //       driver.findElementById("android:id/checkbox").click();

            //   }

            Thread.sleep(2000);
            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
            Thread.sleep(2000);
            driver.findElementById("android:id/edit").sendKeys("test");
            Thread.sleep(2000);
            driver.findElementById("android:id/button1").click();
        }
    }

}
