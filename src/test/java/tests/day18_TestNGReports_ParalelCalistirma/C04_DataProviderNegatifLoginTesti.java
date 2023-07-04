package tests.day18_TestNGReports_ParalelCalistirma;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTesti {
    @DataProvider
    public static Object[][] YanlisKullaniciAdlariListesi() {

        String[][] kullaniciBilgileriArrayi = {{"Feride","12345"},{"Timur","123456"},
                                                {"Mete","12345,"},{"Tarik","12345."},
                                                {"Aytug","12345-"},{"Hasan","12345*"},
                                                {"Fatih","123458"},{"Nimet","123459"},
                                                {"Ogün","123450"},{"Böke","1234523"}};

        return kullaniciBilgileriArrayi;
    }

    //verilen 10 kullanici bilgisi ile
        //sisteme giris yapilamadigini test edin
    @Test(dataProvider = "YanlisKullaniciAdlariListesi")
    public void gecersizIsimSifreTesti(String kullaniciAdi, String password) {

        //qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.loginButton.click();
        qualitydemyPage.cookiesAccept.click();

        //kullanici adi olarak selenium password olarak candir yazin
        qualitydemyPage.email.sendKeys(kullaniciAdi);
        qualitydemyPage.password.sendKeys(password);
        ReusableMethods.bekle(1);

        //login butonuna tiklayin
        qualitydemyPage.submit.click();

        //giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.email.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }
}
