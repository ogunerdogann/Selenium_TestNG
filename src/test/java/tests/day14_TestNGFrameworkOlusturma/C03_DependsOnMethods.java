package tests.day14_TestNGFrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOnMethods {
    /*
       DependsOnMethods oncelik sirasina karismaz!!

       dependsOnMethods bir method'un calismasini
       baska bir method'un calisip passed olmasina baglar

       baglanilan method calismaz veya calisir ama failed olursa
       baglanan method hic calismaz

       @Test notasyonu sayesinde her test bagimsiz olarak calistirilabilir
       Ancak bir test dependsOnMethods ile baska bir method'a baglanmis ise
       tek basina calismasi istendiginde, önce bagli oldugu test methodu'nu calistirir
       o method calisip passed olursa asil calistirmak istedigimz method da calisir

       bu baglanti 3 veya daha fazla method arasinda olursa yani calistirmak istedigimiz
       method baska bir method'a, o da baska bir method'a bagli ise
       3'u birden calismaz
       "No Tests were found" yazar ve hicbir test method'u calismaz
     */
    @Test(dependsOnMethods = "wiseTesti")
    public void youTubeTesti(){
        System.out.println("Youtube");
        Assert.assertTrue(8==3); // failed
    }

    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test(dependsOnMethods = "youTubeTesti")
    public void amazonTesti(){  // priority yazilmazsa 0 kabul edilir.
        System.out.println("Amazon");
    }
}
