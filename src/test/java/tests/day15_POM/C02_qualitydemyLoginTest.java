package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_qualitydemyLoginTest {

    @Test(groups = "smoke")
    public void test01(){
        //Qualitydemy ana sayfasina gidelim
        Driver.getDriver().get("https://www.qualitydemy.com/");

        //login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();
        //gecerli username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.email.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.password.sendKeys("Nevzat152032");
        ReusableMethods.bekle(3);

        //login butonuna basin
        qualitydemyPage.submit.click();

        //basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrol.isDisplayed());

        //sayfayi kapatin
        Driver.closeDriver();

    }
}
