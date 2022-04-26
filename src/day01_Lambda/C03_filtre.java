package day01_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_filtre {
    public static void main(String[] args) {

//task 2.0 structured Programming ile list elemanlarinin  cift olanalrini
// ayni satirda aralarina bosluk birakarak print ediniz

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        ciftleriprrinted(sayi);
        System.out.println("\n***");
        lambdaileciftleriprrinted(sayi);
        System.out.println("\n***");
        lambdaileciftleriprrinted1(sayi);
        System.out.println("\n***");
        lambdaileciftlerveOtuzdortenKucukiprrinted(sayi);
        System.out.println("\n***");
        lamdaotuzdorttenbuyuciftOlanlar(sayi);
    }

    public static void ciftleriprrinted(List<Integer> l) {
        for (Integer each : l) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }

        }

    }
    //Task 2.1:functionel Programming ile list elemanlarinin  cift olanalrini
// ayni satirda aralarina bosluk birakarak print ediniz

    public static void lambdaileciftleriprrinted(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari akisa alindi
                filter(t -> t % 2 == 0 && t < 34).//burda direk manuel filtreledik
                forEach(C02_foreachPrint::adiyazdir);

    }


    public static boolean ciftSayiBul(int a) {//seed(tohum meth) kendisine verilen int degerin cift olup omamasini kotrol eder

        return a % 2 == 0;
    }

    public static void lambdaileciftleriprrinted1(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari akisa alindi
                filter(C03_filtre::ciftSayiBul).//ciftSayiBul() metoduu refere edilerek akistaki elemanlar filitreden gecildi
                forEach(C02_foreachPrint::adiyazdir);//filt den gecilen elemanlar adiyazdir() refere edilerek print edildi

    }
//Task 2.2 : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void lambdaileciftlerveOtuzdortenKucukiprrinted(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari akisa alindi
                //filter(t -> t % 2 == 0 && t < 34).//once cifligine bak sonra 34 den kucuk olanlari filtrele
                filter(C03_filtre::ciftSayiBul).//bu sekildede ayri ayri olabilir
                filter(t-> t<34).
                forEach(C02_foreachPrint::adiyazdir);//filt den gecilen elemanlar adiyazdir() refere edilerek print edildi
    }
//Task 2.3 : functional Programming ile list elemanlarinin 34 den buyuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void lamdaotuzdorttenbuyuciftOlanlar(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari akisa alindi
                filter(t -> t % 2 == 0 || t > 34).//cift veya 34 den buyuk elemanlari filtreler
                forEach(C02_foreachPrint::adiyazdir);//filt den gecilen elemanlar adiyazdir() refere edilerek print edildi
    }

}
