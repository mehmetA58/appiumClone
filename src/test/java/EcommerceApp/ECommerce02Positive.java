package EcommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ECommerce02Positive {
    // Shop the items in the app by scrolling to specific Product and add to cart ()
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //3.yontem
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability("app","C:\\Users\\asus\\IdeaProjects\\appiumKURULUM\\Apps\\General-Store.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        //butun data eksiksiz doldurunca basarili girs yapacagiz
        Thread.sleep(3000);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='France']").click();

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Anne");
        //eger klavyeyi kapatmak istiyorsaniz
        // driver.hideKeyboard(); //klavyeyi kapatir

        driver.getKeyboard();

        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        Thread.sleep(3000);
        //product title basrasili girsi sonrasi onayliyalim
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

    }
}