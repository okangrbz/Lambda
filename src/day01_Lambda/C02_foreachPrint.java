package day01_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_foreachPrint {
    /*

   *** list.stream().forEach(t-> System.out.print(t+" "))

 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
 ahanda trick koseinde bugun : Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
 yani nasil yapacagini soyleme ne yapacagini soyle

 */
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        lammbdaIleYazdir1(sayi);//aralarinda bosluk atamiyoruz bu yontemle oyuzden expration kullaniriz
        System.out.println("\n****");
        lammbdaIleYazdir2(sayi);

    }

    public static void lammbdaIleYazdir1(List<Integer> list) {
        list.stream().forEach(System.out::print);//method referance -->Systhem.out yapisindan print methodu refere et
    //bu action task deki ayni satiri ve boslukla yazmayi karsilamaz bunun icin seed(tohum) method creat ederiz
    }

    public static void adiyazdir(int a) {//verilen int degerin ayni satirda bosluik birakarak
        // yazdirma actionu yapan seed (tohum) bir meth creat ettik
        System.out.print(a + " ");
    }

    public static void lammbdaIleYazdir2(List<Integer> list) {
        list.stream().forEach(C02_foreachPrint::adiyazdir);//method referance -->Systhem.out yapisindan print methodu refere et
        //::bu olmazsa olmaz
    }

}