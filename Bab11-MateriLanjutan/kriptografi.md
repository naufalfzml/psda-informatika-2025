# Kriptografi

Kriptografi adalah ilmu yang berkaitan dengan mengamankan informasi dengan mengubahnya menjadi bentuk yang tidak dapat dibaca tanpa memiliki kunci rahasia untuk mendekripsinya. Dalam pembelajaran ini, kita akan mempelajari bagaimana menggunakan Java untuk melakukan enkripsi dan dekripsi teks sederhana.

## Enkripsi Caesar Cipher

Caesar Cipher adalah salah satu teknik kriptografi paling sederhana yang menggeser setiap huruf dalam teks sejumlah tertentu dalam alfabet. 
Algoritma Caesar Cipher bekerja dengan menggeser setiap huruf dalam teks dengan jumlah tertentu dalam alfabet. Jumlah pergeseran ini disebut dengan kunci.

Sebagai contoh, misalkan kunci yang digunakan adalah 3. Teks "HELLOWORLD" akan dienkripsi menjadi "KHOORZRUOG".

Berikut adalah langkah-langkah enkripsi Caesar Cipher:

1. Konversi teks ke angka: Ubah setiap huruf dalam teks menjadi angka, dengan A = 1, B = 2, ..., Z = 26.
2. Tambahkan kunci: Tambahkan kunci ke setiap angka yang dihasilkan pada langkah 1.
3. Mod 26: Lakukan operasi modulus 26 pada setiap angka yang dihasilkan pada langkah 2. Artinya, jika hasil penjumlahan pada langkah 2 lebih besar dari 26, kurangi dengan 26.
4. Konversi angka ke huruf: Ubah kembali setiap angka yang dihasilkan pada langkah 3 menjadi huruf, dengan 1 = A, 2 = B, ..., 26 = Z.
Dekripsi Caesar Cipher

Dekripsi Caesar Cipher pada dasarnya adalah kebalikan dari proses enkripsi. Berikut adalah langkah-langkahnya:

1. Konversi teks ke angka: Ubah setiap huruf dalam teks menjadi angka, dengan A = 1, B = 2, ..., Z = 26.
2. Kurangi kunci: Kurangi kunci dari setiap angka yang dihasilkan pada langkah 1.
3. Mod 26: Lakukan operasi modulus 26 pada setiap angka yang dihasilkan pada langkah 2. Artinya, jika hasil pengurangan pada langkah 2 kurang dari 1, tambahkan 26.
4. Konversi angka ke huruf: Ubah kembali setiap angka yang dihasilkan pada langkah 3 menjadi huruf, dengan 1 = A, 2 = B, ..., 26 = Z.

Berikut adalah contoh implementasi dalam Java:


```java
public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (ch + shift);
                if ((Character.isLowerCase(ch) && encryptedChar > 'z') || (Character.isUpperCase(ch) && encryptedChar > 'Z')) {
                    encryptedChar = (char) (ch - (26 - shift));
                }
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int shift = 3;

        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Encrypted Text: " + ciphertext);

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
```


# Hash Functions

Hash functions adalah fungsi matematis yang mengonversi input (teks atau data) menjadi nilai hash yang tetap panjangnya, biasanya dalam format yang sulit untuk dibalik. Hash digunakan untuk mengenkripsi data untuk keperluan penyimpanan dan verifikasi integritas data. Beberapa karakteristik hash functions yang penting adalah:

- Deterministik: Satu input akan selalu menghasilkan output yang sama.
- Cepat: Hash functions harus dapat menghasilkan nilai hash dengan cepat.
- Tidak dapat dibalik: Tidak mungkin untuk mendapatkan input asli dari nilai hash.
- Contoh hash functions termasuk MD5, SHA-1, dan SHA-256.

## MD5 Hash
```java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String md5Hash = getMD5(input);
        System.out.println("MD5 Hash: " + md5Hash);
    }
}
```

## MD2 Hash
```java


## SHA-1 Hash
```java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Example {
    public static String getSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 40) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String sha1Hash = getSHA1(input);
        System.out.println("SHA-1 Hash: " + sha1Hash);
    }
}
```
## SHA-256 Hash
```java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {
    public static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 64) {
                hashText = "0";
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String sha256Hash = getSHA256(input);
        System.out.println("SHA-256 Hash: " + sha256Hash);
    }
}
```