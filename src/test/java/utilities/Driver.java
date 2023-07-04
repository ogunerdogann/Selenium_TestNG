package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
   private static WebDriver driver;
   private Driver(){
        /*
          Singleton Patteern kullanilarak istenmeyen yöntemlerle
          driver objesine erisilmesi engellenir

          Constructor'i private yaparak bu class'dan obje olusturularak class
          üyelerinin kullanilmasinin önüne gectik
         */
   }
    public static WebDriver getDriver(){

        String istenenBrowser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (istenenBrowser){
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
        /*
           Böyle yapmamizin sebebi bu methodu baska class'lardan her cagirdigimizda
           cagirdigimiz kadar sayida bir driver olusmasini onlemek.
           Yaptigimiz bu yöntemle sadece bir tane driver kullanarak islerimizi hallediyoruz.
           Methodu ilk calistiridigimiz zaman zaten driver null olarak isaretlenmis oldugundan
           if icindeki sarti saglar.
           Ikinci veya daha fazla cagirmada ise driver'in degeri null degil ChromeDriver olur yani
           if icindeki sart saglanmaz. Bu sart saglanmadigi icin de yeni bir driver olusrutmaz ve var olan,
           zaten olusturulmus olan driver'i dondurur.
         */

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
