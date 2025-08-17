package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Ayberk Yaman");
        // Syntax => Söz dizim kurallar1.
        // Degiskenler => Programlamada verilerin bir isimle tanimlandiktan sonra tutulmasidir
        int yas = 25;    // Tamsayi numerik degerlere "integer,int" diyoruz.
        yas = 30; //set
        System.out.println(yas); //get
        yas = 40;

        String isim = "Halit Enes Kalayc1";
        System.out. println(isim);
        isim = "Engin Demiroğ" ;
        float sayi = 10.141f;
        double sayi1=10.141;
        short sayi2=10;
        long sayi3=1000000000;
        boolean aktif= true;
        // Aritmetik Operatörler
        System.out.println(10 + 10) ;
        System.out.println(11 - 10);
        System.out.println(10 * 10);
        System.out.println(10 /10);
        System.out.println(100 % 3); // Mod (Bölümünden kalan)
        // Atama Operatörleri
        int a = 10;
        a = 15;
        a += 5; // A'nan degeri üzerine -=
        a-= 5;// A'nin degerinden 5 gikan
        a*= 5; // A'yz 5 ile çarp
        a /= 5; // A'yz 5'e böl.
        // a = a + 5
        System.out.println(a);
        System.out.println(a == 15); // A 15 'e esit mi?
        System.out.println(a != 15); // A 15 'e esit degil mi?
        System.out.println(a > 10);
        System.out.println(a >= 15);
        System.out.println(a < 20);
        System.out.println(a <= 15);
        // Mantik Operatörleni
        // Ve => && => Iki kosulun da true olmasini ister.
        yas = 18;
        System.out.println(yas == 16 && yas < 18); // short-circuit çalisin.
        System.out.println(a == 15|| yas > 18); // short-circuit calzsir.
//
        if (yas >= 18)
        {
            System.out.println("Kisi resit.");
        }
        else if (yas == 18) // 18den büyük degil ama 18'e esitse
            System.out.println("Kisi tam 18, ay kontrolü yapilmal1."); // zZ
        else
        {
     System.out.println("Kisi resit degil");
        }
        boolean admin = true;
        if (admin)
            System.out.println("Logla");
    }
}