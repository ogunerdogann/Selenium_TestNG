package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesIlkTest {
        //POM mülakatlarda sorulabilir!!
    @Test
    public void amazonTest(){
        //amazon sayfasina gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella icin arama yapalim
            //Arama kutusunun locate'i pages sayfasinda!
            // POM'de pages sayfasindaki locate'lere erismek icin
            //pages sayfalarindan bir boje olusturulur.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualText = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualText.contains(expectedIcerik));

        //sayfayi kapatalim
        Driver.closeDriver();
    }
}
