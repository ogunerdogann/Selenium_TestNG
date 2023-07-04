package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_qualitydemyNegativeLoginTesti {

    @Test
    public void test01(){

        //qualitydemy ana sayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        //ilk login linkine tiklayin
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //kullanici adi olarak selenium password olarak candir yazin
        qualitydemyPage.email.sendKeys("Selenium");
        qualitydemyPage.password.sendKeys("Candir");

        //login butonuna tiklayin
        ReusableMethods.bekle(3);
        qualitydemyPage.submit.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.email.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }
}
