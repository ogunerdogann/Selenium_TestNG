package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="//body/section/div/nav/div[3]/a[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookiesAccept;

    @FindBy(xpath="//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement submit;

    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement basariliGirisKontrol;
}
