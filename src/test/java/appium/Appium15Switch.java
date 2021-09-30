package appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Appium15Switch extends AppiumBase {
    /*
    Test Case:
    API Demos =>Views
    =>scroll yap asagiya
     */
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        // bu kod ile cihazin olcusunu(inch) almis olduk

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        Dimension dimension = driver.manage().window().getSize(); // Dimension-> Seleniumdan, getSize->(inch)

        int start_x = (int) (dimension.width * 0.5); //x in baslangic noktasi
        int start_y = (int) (dimension.height * 0.8); //y in baslangic noktasi

        int end_x = (int) (dimension.width * 0.5); //x in bitis noktasi
        int end_y = (int) (dimension.height * 0.2); //y in bitis noktasi

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x,start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(end_x,end_y)).release().perform().perform();
        //PointOption : su noktadan itibaren  start_x  -> end_x

    }
}
