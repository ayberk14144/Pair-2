package org.example;

public class Loop {
    public static void main(String[] args) {
        // Prognamlamada liste eLeman saylsl Odan baslanarak sayilir.
        int[] numbers = {10, 20, 30, 40}; // array-dizi
        System.out.println(numbers[1] * 5);
        // degisken, sart, aksiyon
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println("Merhaba");
        }
        /*for (int i=0; i<numbers.length; i++)
        {´´
               System.out.println(numbers[i] * 5):
子 */

        for (int number : numbers) {
            System.out.println(number);
        }
        int a = 0;
        // Kosulu kontrol eder, calismaya baslar.
        while (a < 5) {
            a++;
            System.out.println("While calisti..");
        }
        // Calismaya baslar, kosulu kontrol eder.
        int i = 0;
        do {
            System.out.println("Do while  calisti.");
            i++;
        } while (i > 5);
        String[] ogrenciler = {"Utku", "Muzaffer", "Segil", "Ozgür"};
        for (String ogrenci : ogrenciler) {
          // Muzaffer isimli ögrenci es gecilsin-
            if (ogrenci.equals("Muzaffer")) {
               // continue; // Bu iterasyonu burada bitir. Sonrakine gec.
                break;   // Bu iterasyonu tamanen biter.
            }
            System.out.println("Ögrenci:" + ogrenci + " igin islem yapaliyor.");
        }
    }
}

