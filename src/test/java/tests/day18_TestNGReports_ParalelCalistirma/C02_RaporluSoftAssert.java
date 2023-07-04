package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluSoftAssert extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("Alert test",
                "Kullanici JS alert'leri calistirabilmeli ve kapatabilmeli");
        //-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("Kullanici herokuapp alerts sayfasina gider");

        //- 1.alert'e tiklayin
        WebElement ilkAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
        ilkAlert.click();
        extentTest.info("Ilk alert butonuna click yapar");
        ReusableMethods.bekle(2);

        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert= new SoftAssert();
        extentTest.info("soft assert ile alert yazisinin beklenen degere sahip oldugunu test eder");
        softAssert.assertEquals(expectedYazi,actualYazi,"Alertteki yazinin expected yaziyla ayni olup olmadigi test edilir.");

        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("alert'i kapatir");
        //alertin kapatildigini test edin
        softAssert.assertTrue(ilkAlert.isEnabled(),"alert kapatilma");
        extentTest.info("Softassert ile alert'in kapatildigini test eder");

        softAssert.assertAll();
        extentTest.pass("soft assert ile yapilan tüm testlerin sonucunu raporlar");

        Driver.closeDriver();
        extentTest.info("sayfa kapatilir");
    }
}
