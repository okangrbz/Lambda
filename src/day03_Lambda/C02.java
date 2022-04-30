package day03_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02 {
    public static void main(String[] args) {

        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
        List<Integer> sayi = new ArrayList<>(Arrays.asList(3, 2, 6, 11, -5, 7, 3, 21, -8, 38, 15));

        besdenbuyukenkucukteksayi(sayi);


    }
    public static void besdenbuyukenkucukteksayi(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t>5 && t%2==1).
                reduce(Math::min);
        System.out.println(sayi);
    }
}
