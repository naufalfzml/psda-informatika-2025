package Bab2;
import java.util.Scanner;

public class iterasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        long hasil;
        System.out.println("Menghitung N faktorial (N!): ");
        System.out.print("Masukkan N: ");
        n = input.nextInt();
        hasil = factorial(n);
        System.out.println(n + "=" + hasil);
        input.close();
    }

    public static long factorial(long a) {
        long i, hasil1 = 1;
        for (i = 1; i <= a; i++) {
            hasil1 = hasil1 * i;
        }
        return hasil1;
    }
}