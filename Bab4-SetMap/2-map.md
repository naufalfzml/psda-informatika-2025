# 2 - Map

## Konsep Map

Map (atau **pemetaan**) adalah struktur data yang *memetakan* suatu nilai ke nilai lain. Sederhananya, suatu nilai yang berada dalam dalam map berkorespondensi dengan nilai lain (bisa dengan tipe data yang berbeda).

Dalam praktiknya, map sering digunakan sebagai solusi pengganti indeks berbasis integer pada array (misalnya diganti menjadi indeks berbasis string).

Seperti halnya set, map juga umumnya direpresentasikan dalam bentuk binary search tree supaya proses menambah, menghapus, dan mencari elemen bisa dilakukan seefisien mungkin (kompleksitas O(log N)).

Dalam Java, struktur data Map terletak dalam paket `<java.util>`.

## Deklarasi

Mendeklarasikan map yang memetakan string ke suatu struct `Mahasiswa`:
```java
Map<String, Mahasiswa> dataMhs = new HashMap<>();
```

## Operasi

### Assignment

Mengaitkan mahasiswa dengan indeks **L0122116** dengan obyek dari struct pada map `dataMhs`:
```java
Mahasiswa mhs = new Mahasiswa();
mhs.setNama("Farhan Cahya Permana");
mhs.setProdi("Informatika");
mhs.setAngkatan(2023);
dataMhs.put("L0123051", mhs);

```

### Access

Mendapatkan obyek mahasiswa dengan indeks **L0122116** dari map `dataMhs`:
```java
Mahasiswa mhs = dataMhs.get("L0123051");
System.out.println("Nama: " + mhs.getNama());
System.out.println("Prodi: " + mhs.getProdi());
System.out.println("Angkatan: " + mhs.getAngkatan());
```

Untuk memaninpulasi obyek mahasiswa dengan indeks **L0122116** dalam map `dataMhs`:
```java
dataMhs.get("L0123051").setNama("Farhan");

// atau menggunakan reference:

Mahasiswa mhs = dataMhs.get("L0123051");
mhs.setNama("Farhan");
```

Mengecek apakah mahasiswa dengan indeks **L0122116** berada dalam `dataMhs`:
```java
if (dataMhs.containsKey("L0123051")) {
    System.out.println("L0123051 merupakan mahasiswa UNS");
} else {
    System.out.println("L0123051 bukan merupakan mahasiswa UNS");
}

```

### Removal

Menghapus **L0122116** dari `dataMhs`:
```java
dataMhs.remove("L0123051");
```

### Iteration

Iterasi seluruh elemen `dataMhs`:
```java
for (Map.Entry<String, Mahasiswa> entry : dataMhs.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue().getNama());
}

```

## Selengkapnya

- [Java Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
