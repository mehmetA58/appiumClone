package EcommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ECommerce01Negative {
    // Fill the form details and verify Toast error messages displayed appropriately for wrong inputs

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

        Thread.sleep(3000);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='France']").click();
        //isim kismi gerekli bos biraktigimiz icin girs yapamayagiz

        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        //hata mesajini onayliyacagiz
        String toastMessage = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");

    }
}