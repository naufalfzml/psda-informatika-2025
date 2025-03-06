# 1 - Konsep List

List adalah struktur data yang berguna untuk menampung banyak elemen. Terdapat dua contoh implementasinya, yaitu **array list** dan **linked list**.

### Array List

Kelebihan:

- Akses Elemen Cepat: ArrayList menyediakan akses ke elemen secara acak (random access) dengan menggunakan indeks, yang membuat operasi seperti get() dan set() memiliki kompleksitas           waktu O(1).
- Iterasi Cepat: ArrayList cocok untuk iterasi linier dari elemen, karena memiliki implementasi array yang berurutan.

Kekurangan:

- Memerlukan Alokasi Memori Lebih Besar: ArrayList memerlukan alokasi memori yang lebih besar karena menyimpan elemen dalam array kontigu.

- Penambahan dan penghapusan elemen membutuhkan waktu yang lebih lama dari linked list karena setiap elemen harus digeser setelah adanya penambahan atau penghapusan elemen baru. Kompleksitas waktunya adalah O(n) dengan n adalah jumlah elemen yang harus digeser.

### Linked List

Kelebihan:

- Penambahan/Penghapusan Cepat di Tengah: LinkedList dapat menambah dan menghapus elemen dengan cepat di tengah list karena hanya memerlukan manipulasi referensi antara node.

- Memerlukan Alokasi Memori yang Fleksibel: LinkedList hanya memerlukan alokasi memori yang tepat untuk setiap elemen, yang membuatnya lebih fleksibel dalam pengelolaan memori.

- Lalu linked list memiliki kelebihan yaitu proses memasukkan dan mengeluarkan elemen membutuhkan waktu yang singkat (kompleksitas O(1)) dan dapat menggunakan memori seefisien mungkin         (kompleksitas O(N)), namun untuk mengakses elemen di posisi tertentu membutuhkan waktu yang lebih lama (kompleksitas O(N)).

Kekurangan:

- Akses Elemen Lambat: LinkedList tidak menyediakan akses acak, sehingga operasi seperti get() memiliki kompleksitas waktu O(n) karena harus melakukan iterasi dari awal atau akhir untuk mencapai elemen yang diinginkan.

- Iterasi Lambat: Iterasi di LinkedList memerlukan navigasi melalui setiap node, yang dapat memakan waktu lebih lama daripada ArrayList.

Dalam bahasa Java, array list diimplementasikan dengan tipe data **List<tipe_data>** yang berada dalam header `<java.util.*>`. `<java.util.*>` sendiri mencakup banyak hal seperti List, Stack, Queue, dll. Jika anda hanya membutuhkan list secara spesifik, anda dapat menggunakan `<java.util.list>`.

## 1.1. Array List (ArrayList<tipe_data>)

### Deklarasi

Contoh:
```java
list<Integer> number = new ArrayList<Integer>();
```

### Operasi

Menambahkan elemen di akhir:
```java
number.add(obj);
```

Secara default, keyword add menambahkan elemen terbaru di paling belakang. Namun ada cara lain untuk menambahkan elemen pada index terakhir dengan cara mendapatkan ukuran List tersebut terlebih dahulu. 

Contoh:
```java
number.add(list.size(), obj);
```

Menambahkan elemen di indeks ke-2:
```java
number.add(2, obj);
```

Menghapus elemen di indeks terakhir:
```java
number.remove(list.size() - 1);
```

Menghapus elemen di indeks ke-2:
```java
number.remove(2);
```

Jika anda ingin menghapus nilai 2 secara spesifik (bukan index, namun elemen yang bernilai 2) maka anda dapat menggunakan ini:
```java
number.remove(Integer.valueOf(2));
```

Mengakses elemen di indeks ke-2:
```java
number.get(2);
```

Iterasi seluruh elemen:
```java
for (int i = 0; i < number.size(); i++) {
    System.out.println("number: [" + i + "] : " + number.get(i));
}
```

## 1.2. Linked List (LinkedList<tipe_data>)

### Deklarasi

Contoh:
```java
List<obj> number = new LinkedList<obj>();
```

### Operasi

Menambahkan elemen di awal:
```java
number.addFirst(obj);
```

Menambahkan elemen di akhir:
```java
number.add(obj);
```

Menambahkan elemen di posisi ke-3:
```java
number.add(3, obj);
```

Menghapus elemen di awal (kompleksitas O(1)):
```java
number.removeFirst();
```

Menghapus elemen di akhir (kompleksitas O(1)):
```java
number.removeLast();
```

Mengakses elemen di posisi ke-3:
```java
number.get(3);
```

Menghapus elemen di posisi ke-3:
```java
number.remove(3);
```

Iterasi seluruh elemen:
```java
for (int i = 0; i < number.size(); i++) {
    System.out.println("number: [" + i + "] : " + number.get(i));
}
```

## Selengkapnya

- [Java ArrayList](https://www.geeksforgeeks.org/arraylist-in-java/)
- [Java LinkedList]([https://en.cppreference.com/w/cpp/container/list](https://www.geeksforgeeks.org/linked-list-in-java/))
- [Java Iterator]([https://en.cppreference.com/w/cpp/named_req/BidirectionalIterato](https://www.geeksforgeeks.org/iterators-in-java/)https://www.geeksforgeeks.org/iterators-in-java/)
