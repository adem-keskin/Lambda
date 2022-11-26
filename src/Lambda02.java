import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        tekKupBirFazlaPrint(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        ciftKareKokPrint(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        maxElBul(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        structuredMaxElBul(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        ciftKareEnMaxPrint(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        elemanlarToplamlam(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        ciftCarp(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        minBul(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        bestenBykTekKck(sayi);
        System.out.println("\n+++++++++++++++++++++++");

        ciftKareKbSortPrint(sayi);

    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).  //akistaki cift sayilari filtreledik 4,2,6
                map(t-> t*t).   // 16,4,36 Stream icersindeki elemanlarin karesini aldirdik..
                forEach(Lambda01::yazdir);  // Burdada Lambda01 deki kendi yazdigimiz metodlari kullandik

    }

    // Task-2: Functinal pragraming ile listin tek elemanlarin küplerini ayni satirda aralarinda bosluk ile yazdirin

    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t % 2 != 0).
                map(t-> (t*t*t)+1).forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKareKokPrint (List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.print(t +" "));
    }

    // Task-4: listin en büyük elemanini yazdirin

    public static void maxElBul(List<Integer> sayi){
        Optional<Integer> maxSayi =
                sayi.
                stream().
                reduce(Math::max); // Eger sonuc ta tek deger dönecekse reduce() kullanilir.
        System.out.println(maxSayi);
    }
    //Structured yapi ile ayni taski cözelim
    public static void structuredMaxElBul(List<Integer>sayi){
        int max =Integer.MIN_VALUE;  //en kücük olabolecek degeri aldik ki max sorun olmasin
        System.out.println("max = "+ max);
        for (int i= 0; i<sayi.size(); i++){
            if (sayi.get(i)>max) max= sayi.get(i);
        }
        System.out.println("en büyük sayi : " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnMaxPrint(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));  //Math::max ´a göre daha hizli calisir!!
    }

    //Task-6: List teki tüm elemnlarin toplamini yazdiriniz.Lambda Expression...
    public static void elemanlarToplamlam(List<Integer>sayi){
        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);
        System.out.println("toplam = " + toplam);
    }
    /*
        * a ilk degerini her zaman atanan degerden (ilk parametre) alır
          bu örnekte 0 oluyor.  a=0; b=4 sayi Listin den gelir..
        * b degerini her zamana  stream()'dan akısdan alır
        * a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */

    // Task-7: List teki cift elemanlarin carpimini yazdiriniz

    public static void ciftCarp(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));  // Method refrance

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b))); //lambda expression
    }

    // Task-8: List teki elemanlardan en kücügünü print ediniz.
    public static void minBul(List<Integer>sayi){
        System.out.println(sayi.                    //1.yol
                stream().
                reduce(Integer::min));      // Math::min


        System.out.println(sayi.
                stream().
                reduce(Lambda02::byAdemMin));

    }
    public static int byAdemMin(int a, int b){      //2.yol
        return a<b ? a : b; //byAdemMin (4,9)
    }

    //Task-9 : List teki 5 ten büyük, en kücük, tek sayiyi print ediniz
    public static void bestenBykTekKck(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byAdemMin));

    }

    //Task-10 : list in cift elemanlarinin karelerini kücükten büyüge print ediniz.

    public static void ciftKareKbSortPrint(List<Integer>sayi){
        sayi.
                stream().       // akisi baslattik
                filter(Lambda01::ciftBul).      // cift sayilari aldik
                map(t->t*t).        // sayilarin karesi ile yeni bir akis olusturduk
                sorted().       // akis icindeki sayilari natural-order olarak siraladik
                forEach(Lambda01::yazdir);      // akistaki sayilai yazdirdik
    }




}