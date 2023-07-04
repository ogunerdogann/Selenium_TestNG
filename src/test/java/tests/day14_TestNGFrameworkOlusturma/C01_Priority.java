package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Test;

public class C01_Priority {
    /*
    Junit framework'de testlerin cvalisma süresi
     ONGÖRÜLEMEZ ve DÜZENLENEMEZ!!

     TestNG testleri harf sirasina göre calistirir. (ÖNGÖRÜLEBILIR!)

     Ayrica priority degeri girerek testleri istedigimiz sira ile calistirabiliriz!

     Priority sayisal olarak kücükten büyüge dogru testleri calistirir
     Eger priority degeri ayni olan birden fazla test varsa harf sirasina bakar!
     */
    @Test(groups = "minireg1")
    public void youTubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = -3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test(groups = {"smoke","minireg1"})
    public void amazonTesti(){  // priority yazilmazsa 0 kabul edilir.
        System.out.println("Amazon");
    }
}
