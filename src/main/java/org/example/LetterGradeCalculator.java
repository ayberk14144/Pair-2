package org.example;

import java.util.Scanner;

public class LetterGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen 0–100 arasında bir not giriniz: ");
        int note = scanner.nextInt();

        String harfNotu;

        if (note >= 90 && note <= 100) {
            harfNotu = "AA";
        } else if (note >= 80 && note <= 89) {
            harfNotu = "BA";
        } else {
            harfNotu = "Geçersiz not (0–100 aralığında değildir ya da AA/BA değil)";
        }

        System.out.println("Harf notunuz: " + harfNotu);
        scanner.close();
    }
}
