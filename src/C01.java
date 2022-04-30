import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C01 {
    public static void main(String[] args) {
        // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
//1. yontem Method Reference --> Integer class
//2. yontem Method Reference --> Math class
//3. yontem Lambda Expression
//4. yontem Method Reference --> Haluk class

        List<Integer> sayi = new ArrayList<>(Arrays.asList(3, 2, 6, 11, -5, 7, 3, 21, -8, 38, 15));
        System.out.println(sayi.stream().reduce(Integer::min));//1. yontem
        System.out.println(sayi.stream().reduce(Math::min));//2.yontem
        minBulIntegerClasile(sayi);
        minBulLamdaExpretioile(sayi);
        Optional<Integer> doruduncuyontem = sayi.stream().reduce(C01::halukMin);//4.yontem


// Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
// Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
// Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.


    }

    public static void minBulIntegerClasile(List<Integer> sayi) {//1.yon metthodla Integerclass
        sayi.
                stream().
                reduce(Integer::min);
        System.out.println(sayi);
    }

    public static void minBulMathClassile(List<Integer> sayi) {//1.yon metthodla Integerclass
        sayi.
                stream().
                reduce(Math::min);
        System.out.println(sayi);
    }

    public static void minBulLamdaExpretioile(List<Integer> sayi) {//1.yon metthodla Integerclass
        sayi.
                stream().
                reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);//3.yontem met lambda expretion
        System.out.println(sayi);
    }

    public static int halukMin(int a, int b) {//bu meth kendisine verilen iki degerin en kucugunu aliy

        return a < b ? a : b;
    }

}
