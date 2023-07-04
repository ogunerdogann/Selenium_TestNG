package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // Page class'lari sürekli kullandigimiz locate islemleri ve varsa login gibi kücük islevleri iceren
    //method'lar barindirir.
    // Selenium ile locate islemi veya herhangi bir islem gerceklestirmek istedigimizde
    //WebDriver objesine ihtiyacimiz vardir.
    //POM(Page Object Model)'de Driver class'inda olusturdugumuz
    //WebDriver driver objesini page class'larina tanimlamak icin
    //PageFaktory class'indan initElements() kullanilir.

   public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //bu ayari constructor icine koyma sebebimiz:
        //page sayfalarina obje olusturarak ulasildigi icin
        //kim page sayfasini kullanmak isterse
        //page sayfasindan obje olusturmak icin, constructor calisacak
        //ve bu constructor'in icinde bulunan initelements() gerekli ayari yapilmis olacak
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

   @FindBy(xpath="(//div[@class='sg-col-inner'])[1]")
    public WebElement aramaSonucuElementi;
}
