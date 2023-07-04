package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyLogin {

    @Test
    public void test01(){

        //Qualitydemy ana sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //gecerli username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.email.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.password.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);

        //login butonuna basin
        qualitydemyPage.submit.click();

        //basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrol.isDisplayed());

        //sayfayi kapatin
        Driver.closeDriver();
    }

}
