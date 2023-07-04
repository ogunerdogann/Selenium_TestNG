package tests.day16_POM_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SingletonPattern {

    @Test
    public void test01(){
        /*

           Biz otomasyon icin elimiz ve kolumuz olarak
           Driver class'indaki WebDriver driver objesini kullaniyoruz.
           ANCAK driver'in bizim istedigimiz isleri yapabilmesi icin
           öncelikle getDriver() icinde yaptigimiz atama islemlerine ihtiyaci var.

           Bir framework'de calisan kisilerin
           getDriver() kullanmadan direk driver objesine erisimini engellemek icin
           Singleton Pattern kullanimi TERCUH EDILMISTIR!

           Singleton Pattern bir class'dan
           obje olusturulmasini ve o obje ile class'daki class uyelerine erisimi engellemek icin kullanilir.

            OOP konsept cercevesinde
            Driver class'ini farkli farkli yöntemlerle kullanabilirsiniz.
            Ekip calismasinin tek düzen üzerinden gitmesi önemli oldugundan

            farkli yöntemlerle WebDriver driver'in kullanimini engellemek istiyoruz
         */
        //Driver.driver.get(ConfigReader.getProperty("amazonUrl"));
        // getDriver() calismadigindan driver null olarak isaretlendiginden
        //NullPointerException verir. (Bunu yapmak icin Driver'daki WebDriver'i publlic yaptik!)
        //Driver driver = new Driver();
        //driver.get("https://www.amazon.com");
        //driver.gerDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Driver class'indaki constructor'i private yapinca kimse Driver class'indan obje olusturamaz!
    }
}
