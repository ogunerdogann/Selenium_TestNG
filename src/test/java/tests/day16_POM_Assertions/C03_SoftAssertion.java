package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void hardAssertion(){

        /*
           Assert islemi ilk failed oldugunda sElenium calismayi durdurur ve
           java.lang.AssertionError verir.

           Eger bir test methodu icinde birden fazla assertion varsa ilk failed olanda
           calisma durur sonraki assertion'lar calismamis olur

           TestNG bu konuda da bize daha fazla kontrol yetkisi vermistir
           Istersek TestNG assertion failed olsa bile
           bizim istedigimiz satira kadar kodlarin calismasini saglar,
           "artik rapor ver" dedigimizde
           failed olan assertion'lari raporlar
           ve failed olan varsa calismayi durdurur.
         */

        int sayi = 23;

        Assert.assertTrue(sayi%2==0); //sayi cift mi

        Assert.assertTrue(sayi>100); // sayi 100'den büyük mü?

        Assert.assertTrue(sayi<1000); //sayi 1000'den kücük mü?

        Assert.assertFalse(sayi%3==0); // sayinin 3 ile bölünemedigini test edin
    }

    @Test
    public void softAssertionTesti(){

        /*
           SoftAssert class'i sayesinde
           assertAll() methodu'nun calisacagi satira kadar
           failed olan olsa bile tüm assertion'lar calismaya devam eder.

           assertAll() calistiginda
           failed olan assertion'lara ait raporu verir
           ANCAK hangi satirda olduklarini vermez

           Selenuim hata mesaji da assertAll()'un bulundugu satiri isaret eder.

           Failed olan assertion'lari kolaylikla bulabilmemiz icin
         */
        int sayi = 23;

        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(sayi%2==0,"sayi cift olmali"); //sayi cift mi

        softAssert.assertTrue(sayi>100,"sayi 100'den büyük olmali"); // sayi 100'den büyük mü?

        softAssert.assertTrue(sayi<1000,"sayi 1000'den kücük olmali"); //sayi 1000'den kücük mü?

        softAssert.assertFalse(sayi%3==0,"sayi 3'e bölünememeli"); // sayinin 3 ile bölünemedigini test edin

        softAssert.assertAll();

        // softAssert objesi ile assertion'lari yaptiktan sonra
        //assertAll() kullanmazsaniz, test direk PASSED olur,
        //failed olan assertion'lar raporlanmaz!
    }
}
