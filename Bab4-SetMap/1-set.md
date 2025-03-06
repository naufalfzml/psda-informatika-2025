# 1 - Set

## Konsep Set

Set (atau **himpunan**) adalah suatu struktur data yang operasinya hanya digunakan untuk **mengecek keberadaan suatu data** tertentu. Konsep himpunan ini mirip dengan himpunan dengan matematika, akan tetapi dengan jumlah elemen yang terbatas (berbeda dengan himpunan di matematika yang mana jumlahnya bisa sampai tak terhingga, misal himpunan seluruh bilangan bulat).

Himpunan pada matematika juga memiliki operasi untuk mengecek suatu keanggotaan pada himpunan (misalkan, apakah angka 36 merupakan anggota himpunan bilangan bulat?). Begitu juga himpunan sebagai struktur data program komputer, ia dapat mengecek keanggotaan (keberadaan) suatu data dalam himpunan tersebut, dengan kompleksitas yang relatif singkat.

Pada umumnya, himpunan direpresentasikan dalam bentuk binary search tree supaya proses menambah, menghapus, dan mencari elemen bisa dilakukan seefisien mungkin (kompleksitas O(log N)).

Dalam Java, struktur data Map terletak dalam paket `<java.util>`.

## Deklarasi

Sebagai contoh:
```java
Set<Integer> favNumbers = new HashSet<>();
```
Mendeklarasikan himpunan `fav_numbers` dengan tipe anggota elemen berupa `int`.

## Operasi

### Insertion

Memasukkan elemen angka `36` ke dalam himpunan `fav_numbers`:
```java
favNumbers.add(36);
```

### Access

Mengecek apakah angka `36` ada dalam himpunan `fav_numbers`:
```java
if (favNumbers.contains(36)) {
    System.out.println("Angka 36 merupakan salah satu angka favorit saya");
}

```

atau menggunakan iterator:
```java
Iterator<Integer> it = favNumbers.iterator();
while (it.hasNext()) {
    Integer num = it.next();
    if (num == 36) {
        it.remove(); // Hapus elemen yang ditunjuk oleh iterator
        break; // Keluar dari loop setelah elemen dihapus
    }
}

```

### Removal

Menghapus keanggotaan angka `36` dari himpunan `fav_numbers`:
```java
favNumbers.remove(36);
```

atau menggunakan iterator:
```java
Iterator<Integer> it = favNumbers.iterator();
while (it.hasNext()) {
    Integer num = it.next();
    if (num == 36) {
        it.remove(); // Hapus elemen yang ditunjuk oleh iterator
        break; // Keluar dari loop setelah elemen dihapus
    }
}

```

### Iteration

Iterasi seluruh anggota elemen pada himpunan `fav_numbers`:
```java 
for (Integer num : favNumbers) {
    System.out.println("Angka favorit: " + num);
}

```

## Selengkapnya

- [Java](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)
