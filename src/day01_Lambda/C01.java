package day01_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
/*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
    ******  Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));


        sayilariyazdir(sayi);
        System.out.println("\n***");
        lammbdaIleYazdir(sayi);
        System.out.println("\n***");
        lammbdaIleYazdir1(sayi);//bazi methodlar isyedigimiz sonucu vermez oyuzden bady ye nasil yapacagini da soylememzi gerekir yani exretion ksimi
        //devreye girer


    }

    //Task1 ;Structuer programming kullanarak list elema,lari aralarinda bosluk olacak sekilde print edin
    public static void sayilariyazdir(List<Integer> list) {
        for (Integer each : list) {
            System.out.print(each + " ");

        }
    }
    //Task1 ;Functional programming kullanarak list elema,lari aralarinda bosluk olacak sekilde print edin
    public static void lammbdaIleYazdir(List<Integer> list) {
        list.stream().forEach(t-> System.out.print(t+" "));//buradaki t oreach in each i ni karsiliyor yani bos conteinir


        }
    public static void lammbdaIleYazdir1(List<Integer> list) {
        list.stream().forEach(System.out::print);//method referance -->Systhem.out yapisindan print methodu refere et
    }

}
