package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //3.yontem
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");

        //eger appActivity ve appPackage kullanacaksaniz app path gerekli degildir
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\asus\\IdeaProjects\\appiumKURULUM\\Apps\\apiDemos.apk"); //app in absolute pathini aldik

        // app acilirken izin istendiginde appActivity ve appPackage tanimlayarak bu sorunu gecebilirsiniz
        // app telefonda acin
        // terminal veya CMD prompt acarak -> adb shell yazin sonra da -> dumpsys window | grep -E "mCurrentFocus" enter
        // komutunu girince appActivity ve appPackage bilgilerine ulasabilirsniz(cmd de key lerin value lari veriyor)
        desiredCapabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        desiredCapabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities); //test passed

        Thread.sleep(4000);

        //test fail olunca consol da link e yonlendiriyor
        // https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md

    }

}
