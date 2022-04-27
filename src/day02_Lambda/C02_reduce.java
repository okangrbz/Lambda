package day02_Lambda;

import day01_Lambda.C01;
import day01_Lambda.C02_foreachPrint;
import day01_Lambda.C03_filtre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C02_reduce {
    /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    public static void main(String[] args) {

        // Task 1.1: list'in en buyuk elemanini yazdiriniz
        List<Integer> sayi = new ArrayList<>(Arrays.asList(3, 2, 6, 11, -5, 7));

        maxElemanBul(sayi);
        System.out.println("\n***");
        ciftElemanKaresininEnbuyugu(sayi);//Optional[36]
        System.out.println("\n***");
        elemanlarinToplamini(sayi);//24
        System.out.println("\n***");
        ciftElemanlarinCarpimi(sayi);

        /*
        yaptigiz action da tek bir sonuc cikarsa reduce () meth kullanilir.
        reduce methodundan sonra foreach gelmez.Bu islem terminal islemi oldugu icin forech gelmez
        yani bu islemden sonra baska action yok. oyuzden ya action ciktisini yazdiriririz
        yada bir variable le baglariz onun uzeinden action yapariz

         */
    }
    public static void maxElemanBul(List<Integer> sayi)   {
        Optional<Integer> maxSayi=sayi.//int null alamadigi icin Optionel secmek zorundayiz int sayi=;-->olmaz
                stream().
                reduce(Math::max); //akisa giren elemanlari tek eleman haline getirir

/*
burada variable la baglasakta baglamasakta Optional a alir
cunki null degeri int olmadigi icin java kendini garantiye almak icin
 */
        System.out.println(maxSayi);
        System.out.println("bu sekilde de yazabiliriz "+sayi.stream().
                reduce(Math::max));


    }

    // Task 1.2 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftElemanKaresininEnbuyugu(List<Integer> sayi){
        sayi.
                stream().//akisa sundu
                filter(C03_filtre::ciftSayiBul).//cift sayilari filtreledi
                map(t->t*t).//karesini aldi
                reduce(Math::max);//burda math class dan max bulduk


        System.out.println(  sayi.
                stream().
                filter(C03_filtre::ciftSayiBul).
                map(t->t*t).
                reduce(Integer::max));//burda math class dan max bulduk buyuk bir class oldugu icin yazastir

        System.out.println(sayi.
                stream().
                filter(C03_filtre::ciftSayiBul).
                map(t->t*t).
                reduce(Integer::max));//burda Integer class da max bulduk.
                                    // bu clss daha spesifik oldugu icin daha hizli calisir

    }
    // Task 1.3 : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...

    public static void elemanlarinToplamini(List<Integer> sayi){
        sayi.stream().reduce(Integer::sum);//meth ref ile boyle yapilabilir-->bu deger 0 dan basladigi icin int
                                        // bir variable a atabiliriz Optional istemez

        sayi.
                stream().
                reduce(0,(a,b)->a+b);//expretion ile boyle yapilir -->bu deger verilmedigi icin
                                        // listenin bos olmasi durumunu goze alarak Optional kulanmak gerekir
        /*
        a,b isimleri baska seyde kullanabilirsin onemli degil
        a ilk degerini her zaman atanan degerden (0) dan alir
        b degerini her zaman stream(akistan) alir
        a ilk degerinden sonraki her degeri actiondan(islemden) alir
        loop gibi yani.
         */
        System.out.println("Lambda ex :"+sayi.
                stream().
                reduce(0,(a,b)->a+b));
    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftElemanlarinCarpimi(List<Integer> sayi){
        sayi.stream().filter(C03_filtre::ciftSayiBul).reduce(Math::multiplyExact);//bu meth call ile yapilisi

        System.out.println("Methd ref"+sayi.stream().filter(C03_filtre::ciftSayiBul).reduce(Math::multiplyExact));


        sayi.//buda expretion ile yapilisi
                stream().
                filter(t->t%2==0).
                reduce(1,(a,b)->a*b);

        System.out.println("Lambda ex :"+sayi.
                stream().
                filter(t->t%2==0).
                reduce(1,(a,b)->a*b));
    }
}
