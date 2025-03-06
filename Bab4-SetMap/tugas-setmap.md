# Tugas Praktikum Set dan Map

Note:

- Kerjakan dengan bahasa Java
- Kumpulkan semua source code dengan format **NamaKelas_PSDASADAT04_NIM_NamaLengkap_NomorSoal.java**
- Contoh **A_PSDASADAT04_L0122004_AbrahamWillemHersubagyo_1.java**
- Assignment Google Classroom **(jangan di-ZIP)**

## Nomor 1 - Set

Lengkapi source code berikut dengan mengikuti instruksinya: **(bobot: 25%)**

```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    // mengecek apakah `n` adalah bilangan prima
    // return: `true` jika bilangan prima, `false` jika tidak
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> primeNumbers = new HashSet<>();

        // generate bilangan prima dari 1 sampai 100
        // dan masukkan ke dalam himpunan `primeNumbers`
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        // cek bilangan prima
        System.out.println("Send Ctrl+C to exit");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            // cek apakah `num` adalah bilangan prima dari 1 dan 100
            // fungsi isPrime() memiliki kompleksitas O(N), adakah versi yang lebih baik?
            // jika ada, perbaiki kondisi dalam if di bawah
            if (isPrime(num) && (1 <= num) && (num <= 100)) {
                System.out.println(num + " is a prime number between 1 and 100");
            } else {
                System.out.println(num + " is not a prime number between 1 and 100");
            }
        }
    }
}
```
Benarkan kode di atas jika dirasa ada kesalahan

## Nomor 2 - Map

Buatlah sebuah program dengan ketentuan dasar sebagai berikut: **(bobot: 75%)**

- Program ini merupakan program simulasi e-commerce sederhana yang memiliki database produk.
- Tiap produk memiliki kode, nama, stok, dan harga.
- Anda sebagai pelanggan memiliki saldo awal.
- Anda bisa memilih salah satu produk yang akan dibeli (berdasarkan kode) dan menginputkan jumlahnya yang akan dibeli.
- Ketika anda sudah membeli produk, kurangi stok produk dengan jumlah yang anda beli. Sesuaikan juga saldo akhir anda.

Buatlah sekreatif mungkin dalam bahasa Java menggunakan Map!
