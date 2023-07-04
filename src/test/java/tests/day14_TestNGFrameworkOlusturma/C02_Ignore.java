package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C02_Ignore {
    /*
       @Ignore notasyonu
       basina yazildigi testin Ignore edilmesini saglar
     */
    @Test(priority = 57)
    public void youTubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = -3) @Ignore  //Testi calistir ve sonuclari gör
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test
    public void amazonTesti(){  // priority yazilmazsa 0 kabul edilir.
        System.out.println("Amazon");
    }
}
