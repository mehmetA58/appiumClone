package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class Appium18GeneralStoreApp extends AppiumBase {
    /*
    E-commerce App
    Test Cases:
    1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    2-Shop the items in the app by scrolling to specific Product and add to cart ()
    3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
    4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
    5-Validate Mobile gestures working for link (long press) and navigate to WebView
    6-Verify if user can do operations on Web view and navigate back to native app if needed.
    (go to google and search "appium" then navigate to NATIVE APP and verify it)
     */

    @Test
    public void test1NegatifToast() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        // 1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Andorra\")").click();
        //  androidDriver().findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Ali bey");
        driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String toast = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
        Assert.assertEquals("Please enter your name",toast);
        System.out.println(toast); //Please enter your name
        //session kapat
        //  driver.quit();

    }

    @Test
    public void test2Positive() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        //2-Shop the items in the app by scrolling to specific Product and add to cart ()

        //Ulke sec
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Andorra\")").click();

        //Isim yaz
        driver.findElementById("com.androidsample.generalstore:id/nameField").click();
        //androidDriver().findElementByXPath("//android.widget.EditText[@text='Enter name here']").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Ali bey");

        //Burada sendKeys yapinca alt kisimda keybord cikiyor, navigate().back() yapinca kapaniyor.
        driver.navigate().back();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        //Sepete eklenecek elementler
        String elementText1= "Air Jordan 4 Retro";
        String elementText2= "Nike SFB Jungle";
        String addToCart = "ADD TO CART";
        //  ReusableMethods.scrollWithUiScrollable1(elementText1, addToCart);
        // ReusableMethods.scrollWithUiScrollable1(elementText2, addToCart );
        // ReusableMethods.clickOnPage(elementText2);

        //"$160.97"; ilk siradki eleman sepete ekle
        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

        //EN SONDAKI FIYATI ("$116.97") SEC VE ONU SePETE EKLE

        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[3]").click();

        //YukARIDAKI SEPETE TIKLA
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        //  3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
        String actualElement1= driver.findElementByXPath("(//android.widget.TextView[@text='"+elementText1 +"'])").getText();
        double elementFiyat1= 160.97;
        double elementFiyat2 = 116.97;

        System.out.println("actualElement1" + actualElement1);
        String actualElement2= driver.findElementByXPath("(//android.widget.TextView[@text='"+elementText2 +"'])").getText();
        System.out.println("actualElement2)" + actualElement2);
        Assert.assertEquals(elementText1, actualElement1);
        Assert.assertEquals(elementText2, actualElement2);


        //4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
        String actualTotalAmount =driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        double expectedToplamFiyat= 277.94;
        String dolarSign= "$ ";
        System.out.println("actualTotalAmount: " + actualTotalAmount);
        Assert.assertEquals(actualTotalAmount, dolarSign+expectedToplamFiyat);


        // 5-Validate Mobile gestures working for link (long press) and navigate to WebView
        //Burada (MobileElement) gerekiyor, WebElement cast to MobileElement
        TouchAction touchAction = new TouchAction(driver);
        MobileElement elementToLongPress = (MobileElement) driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Please read our terms of conditions\")");
        touchAction.press(ElementOption.element(elementToLongPress)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                perform();

        //   touchAction. longPress(ElementOption.element(driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Please read our terms of conditions\")"))).release().perform();

        //Assert title after clicking presslong
        Thread.sleep(3000);
        String actualTitleofTerm = driver.findElementByXPath("//android.widget.TextView[@text='Terms Of Conditions']").getText();
        String expectedTitleofTerm ="Terms Of Conditions";
        Assert.assertEquals(actualTitleofTerm, expectedTitleofTerm, "Actual title is not match");
        //Close the term of conditions
        driver.findElementByXPath("//android.widget.Button[@text='CLOSE']").click();

        //Checkbocx tikla
        WebElement checkBox = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\").text(\"Send me e-mails on discounts related to selected products in future\")");
        if(!checkBox.isSelected()){
            checkBox.click();
        }


        // 6-Verify if user can do operations on Web view and navigate back to native app if needed.
        //(go to google and search "appium" then navigate to NATIVE APP and verify it)

        //Visit website tikla
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Visit to the website to complete purchase\")").click();
        //driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(3000);

        //Google birsey yaz ara
        driver.findElementByXPath("//android.widget.EditText").sendKeys("qa engineer" + Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();

        //Assert the  title of App
        String expectedTitleofGeneralStore ="General Store";
        String actualTitleOfGeneralStore= driver.findElementById("com.androidsample.generalstore:id/toolbar_title").getText();
        Assert.assertEquals(actualTitleOfGeneralStore, expectedTitleofGeneralStore, "Titles are not match");


        //session kapat
        // driver.quit();

    }
}