package tests.day19_crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;
import utilities.TestBaseRapor;

public class C02_AlertsTesti extends TestBaseCross {

    @Test
    public void test01(){


        //-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //- 1.alert'e tiklayin
        WebElement ilkAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
        ilkAlert.click();


        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(expectedYazi,actualYazi,"Alertteki yazinin expected yaziyla ayni olup olmadigi test edilir.");

        driver.switchTo().alert().accept();

        //alertin kapatildigini test edin
        softAssert.assertTrue(ilkAlert.isEnabled(),"alert kapatilma");


        softAssert.assertAll();

    }
}
