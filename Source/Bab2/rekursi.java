package Bab2;
import java.util.Scanner;

public class rekursi {
    public static int hitungFaktorial(int input) {
        if (input > 1) {
            return input * hitungFaktorial(input - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hitung Faktorial dengan Rekursi");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan angka:");
        int angka = scanner.nextInt();

        System.out.println(angka + "! = " + hitungFaktorial(angka));
        scanner.close();
    }
}