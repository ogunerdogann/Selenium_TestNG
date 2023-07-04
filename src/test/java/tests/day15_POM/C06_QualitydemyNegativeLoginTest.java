package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_QualitydemyNegativeLoginTest {

    @Test
    public void gecersizIsimSifreTesti() {

        //qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //kullanici adi olarak selenium password olarak candir yazin
        qualitydemyPage.email.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.password.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReusableMethods.bekle(2);

        //login butonuna tiklayin
        qualitydemyPage.submit.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.email.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }

    @Test
    public void gecersizIsimTesti() {

        //qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //gecersiz username ve gecerli sifreyi ilgili kutulara yazin
        qualitydemyPage.email.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.password.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        ReusableMethods.bekle(2);

        //login butonuna tiklayin
        qualitydemyPage.submit.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.email.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void gecersizSifreTesti() {

        //qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //gecerli username ve gecersiz sifreyi ilgili kutulara yazin
        qualitydemyPage.email.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.password.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReusableMethods.bekle(2);

        //login butonuna tiklayin
        qualitydemyPage.submit.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.email.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }
}
