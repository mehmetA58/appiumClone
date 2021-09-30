package EcommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ECommerce03SepeteEkle {

    //Validate if the items selected in the page 2 are matching with the items displayed in check out page

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


        //sepete ekleme
        //Sepete eklenecek elementler
      /*
        String elementText1= "Air Jordan 4 Retro";
        String elementText2= "Air Jordan 1 Mid SE";
        String addToCart = "ADD TO CART";

        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();     //ilk urun
        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();    //ikinci urun
        //sepete eklendikten sonra "added cart" oldugu icin yine sayfada "ADD TO CART" olan ilk index oluyor,
        // bir daha urun secerken ayni index oluyor
       */
        //not: elementi container a koyarsak ;stack memory de sakladigi icin mi 2. elementi 2. index de aliyor
        MobileElement ilk_urun = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        MobileElement ikinci_urun = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]"); //ikinci urun icin
        ilk_urun.click();
        ikinci_urun.click();

        //Sepete git
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        String ilkUrunAdi =driver.findElementByXPath("(//android.widget.TextView[@text='Air Jordan 4 Retro'])").getText();
        String ikinciUrunAdi =driver.findElementByXPath("(//android.widget.TextView[@text='Air Jordan 1 Mid SE'])").getText();

        Assert.assertEquals(ilkUrunAdi, "Air Jordan 4 Retro");
        Assert.assertEquals(ikinciUrunAdi,"Air Jordan 1 Mid SE" );


        //4 fiyati onayla
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
            // driver.findElementById("com.androidsample.generalstore:id/rvProductList").click();

       List<MobileElement> urunler = (List<MobileElement>) driver.findElementById("com.androidsample.generalstore:id/productName");

    }

}
