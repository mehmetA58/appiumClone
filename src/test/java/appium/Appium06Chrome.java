package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06Chrome {
    /*
    https://chromedriver.storage.googleapis.com/index.html  : bu linkten butun chrome versionlarina ulasabiliriz

    http://chromedriver.chromium.org/download  : bu linkten chrome version bilgisine ulasabiliriz
     */
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        desiredCapabilities.setCapability("chromedriverExecutable", "C:/Users/asus/IdeaProjects/appiumKURULUM/driver/chromedriver.exe");
        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);

        /*
        amazon.com git
        sign in tikla
        login page welcome yazisini onayla
         */
        // amazon.com git
        driver.get("https://www.amazon.com/");

        // remote device on chrome  : https://developer.chrome.com/docs/devtools/remote-debugging/
        //  yer cubugunda bu komutua git :       chrome://inspect#devices

       //getContextHandles() : mevcut olan app turlerini Set container a ekliyoruz
        Set contextNames = driver.getContextHandles();
        //burada mevcut app turunu (context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println("contextName :" + contextName); //contextName :NATIVE_APP //contextName :CHROMIUM
            Thread.sleep(3000);
            if (contextName.toString().contains("CHROMIUM")){
                // alttaki kod da hangi app turunde calisacaksak onu set ediyoruz..
                driver.context((String) contextName); //web app devam edecegz
                Thread.sleep(10000);
            }
        }

        //artik set ettigimiz context ile test devam ediyiruz.
        System.out.println("2 "+driver.getContext()); //2 CHROMIUM
        driver.findElementByXPath("//a[@class='nav-a nav-show-sign-in']").click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElementByXPath("//h2").isDisplayed());
        System.out.println("3 "+driver.getContext()); //3 CHROMIUM
        //  driver.quit();




    }
}