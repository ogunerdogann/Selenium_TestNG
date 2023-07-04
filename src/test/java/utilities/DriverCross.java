package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {

    private static WebDriver driver;
    private DriverCross(){
        /*
          Singleton Patteern kullanilarak istenmeyen yöntemlerle
          driver objesine erisilmesi engellenir

          Constructor'i private yaparak bu class'dan obje olusturularak class
          üyelerinin kullanilmasinin önüne gectik
         */
    }
    public static WebDriver getDriver(String browser){

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;
        //bu satir bizim emniyet subabimiz
        //eger parametre olarak null gönderilirse
        //configuration.properties'deki browser degerini alacak

        if (driver == null){

            switch (browser){
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        return  driver;
    }

    public static void closeDriver(){

        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
