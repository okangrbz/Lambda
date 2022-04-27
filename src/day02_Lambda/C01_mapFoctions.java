package day02_Lambda;

import day01_Lambda.C02_foreachPrint;
import day01_Lambda.C03_filtre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/*
map methodu action yapar
 */

public class C01_mapFoctions {
    public static void main(String[] args) {
// Task 1.1 : Functional Programming ile listin cift elemanlarinin
// karelerini ayni satirda aralarina bosluk bırakarak print ediniz

        List<Integer> sayi = new ArrayList<>(Arrays.asList(3, 2, 6, 11, -5, 7, 3, 21, -8, 38, 15));
        ciftKarePrint(sayi);//1156 484 256 400 64 1444
        System.out.println("\n***");
        tekKupPrint(sayi);//1332 -42874 250048 9262 3376
        System.out.println("\n***");
        cifteKareKok(sayi);
        System.out.println("\n***");

    }

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().
                filter(t -> t % 2 == 0).//cift sayilari filitreledi
                map(t -> t * t).//bu call meth filitrelenen elemanlari alip karelerini verir
                forEach(C02_foreachPrint::adiyazdir);

        ////map()--> Stream içerisindeki elemanları başka tiplere
        // dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.

    }
// Task 1.2: Functional Programming ile listin tek elemanlarinin
// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupPrint(List<Integer> sayi) {
        sayi.
                stream().//list elemanlari akisa alindi
                filter(t -> t % 2 != 1).//tek elemanlar filitrelendi
                map(t -> (t * t * t) + 1).//tek eelemanlari kuplerinin bir fazlasina islem yapildi
                forEach(C02_foreachPrint::adiyazdir);//method call ederek yazdirirldi
    }
// Task 1.3 : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void cifteKareKok(List<Integer> sayi) {
        sayi.
                stream().//akisa soktuk
                filter(C03_filtre::ciftSayiBul).//
                map(Math::sqrt).//Math clasindan karekok meth call ettik
               // forEach(C02_foreachPrint::adiyazdir); --->bu meth integer calistigi icin
                // ama aksiyondan cikan degerler double oldugu icin expretion la ne yapacagini foreach de soyledik
                forEach(t-> System.out.print(t+" "));//yazdirdik
    }





}
