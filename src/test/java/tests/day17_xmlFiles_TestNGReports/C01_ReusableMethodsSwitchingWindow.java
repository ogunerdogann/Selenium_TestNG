package tests.day17_xmlFiles_TestNGReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsSwitchingWindow {

    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD = Driver.getDriver().getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert = new SoftAssert();
        String expectedText = "Opening a new window";
        String actualText = Driver.getDriver().findElement(By.tagName("h3")).getText();
        softAssert.assertTrue(actualText.equals(expectedText),"ilk sayfa Text testi Opening a new window degil");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"2. sayfa titel'i The Internet degil");

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//a[@href='/windows/new']")).click();
        //43. Satir itibariyle yeni window acildi, artik 2 window var.

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ReusableMethods.switchToWindow("New Window");

        expectedTitle = "New Window";
        actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText ="New Window";
        actualText = Driver.getDriver().findElement(By.tagName("h3")).getText();
        softAssert.assertEquals(actualText,expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Driver.getDriver().switchTo().window(ilkSayfaWHD);
        expectedTitle = "The Internet";
        actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        softAssert.assertAll();
        Driver.quitDriver();
    }
}
