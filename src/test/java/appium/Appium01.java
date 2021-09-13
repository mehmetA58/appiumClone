package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
@Test
    public void test() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

    //https://appium.io/docs/en/writing-running-appium/caps/index.html   //gerekli bilgiler detayli olarak linkte var

    //setCapability() farkli sekillerde yazabiliriz,

    //1-  desiredCapabilities.setCapability("automationName", "UiAutomator2");
    //2-  desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");

    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //3.yontem
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"1fd655780409");
    desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\asus\\IdeaProjects\\appiumKURULUM\\Calculator.apk");
    URL url = new URL("http://127.0.0.1:4723/wd/hub");
    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,desiredCapabilities);//MobileElement AndroidElementin parent i

    //        if(driver.isDeviceLocked()) {
    //          driver.unlockDevice();
    //        }
    driver.unlockDevice(); //500 hatasi alinirsa bu kod satiri kapatilabilir
    /*
    eger telefon(real device - kendi tel) istiyorsanz developer options dan aktif hale getirilmeli ve USB Debuggigng acik olmali
    USB vasitasiyla gercek telefonlarda da test yapabilirsnz
     */

        }
}
