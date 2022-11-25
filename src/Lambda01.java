import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

    */


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi);
        System.out.println("\n+++++++++++++++++++++++++++++++");
        printElFunctional(sayi);
        System.out.println("\n+++++++++++++++++++++++++++++++");
        printElFunctional1(sayi);
        System.out.println("\n+++++++++++++++++++++++++++++++");
        printElFunctional2(sayi);
        System.out.println("\n+++++++++++++++++++++++++++++++");
        printCiftElFunctional(sayi);
        System.out.println("\n+++++++++++++++++++++++++++++++");
        printCiftOtcKckFunctional(sayi);

    }

    //TASK: "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> sayi) {

        for (Integer w : sayi) {

            System.out.print(w + " ");

        }
    }
    //TASK: "fubctional  Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach((t) -> System.out.print(t + " "));    // lambda expression --->  NASIL yapmasi gerektigini söylüyoruz.
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print);     // method referance :: yan yana ikikez üstüste nokta koyariz.. cikti istedigimiz gibi degil!
    }

    // kendimiz bir method olusturuyoruz
    private static void yazdir(int a) {
        System.out.print(a + " ");
    }


    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir);     // method referance :: yan yana ikikez üstüste nokta koyariz.. Bu kez kendimiz method yazdik cikti istedigimiz gibi oldu!!!
    }

    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer>sayi){
        sayi.
                stream().
                filter(t->t % 2 == 0).      // lambda expression
                forEach(Lambda01::yazdir);
    }
    //TASK  : Structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer>sayi){
        for (Integer w:sayi) {
            if (w % 2 == 0){
                System.out.print(w +" ");
            }
        }
    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtcKckFunctional(List<Integer>sayi){
        sayi.
                stream().
                filter(t-> t % 2 == 0 && t < 34).       //filter(t-> t%2 == 0) . filter(t-> t<34) seklindede yazilabilirdi...
                forEach(Lambda01::yazdir);          // forEach((t) -> System.out.print(t + " "));  buradaki code un acilimi..
    }


}
