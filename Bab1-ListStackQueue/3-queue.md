# 3 - Queue

Queue adalah struktur data FIFO (first-in-first-out) atau FCFS (first-come-first-serve) yang artinya elemen yang dimasukkan pertama, ialah yang pertama kali harus keluar, sama halnya dengan antrean. Perhatikan contoh ilustrasi di bawah:

![Ilustrasi](https://img.freepik.com/free-vector/people-waiting-queue-bank-machine_74855-4458.jpg?size=626&ext=jpg&ga=GA1.2.1411813280.1638403200) 

Dalam bahasa Java, queue dapat diakses melalui header `Queue` dan memanfaatkan linked list sebagai tempat penyimpanannya.

## 2.1. Deklarasi

Contoh:
```java
Queue<String> atm = new LinkedList<>();
```

## 2.2. Operasi

### Push atau Enqueue

Memasukkan elemen ke bagian belakang antrean:
```java
atm.add("John Nash");
```

### Front atau Head

Mengakses elemen yang berada di antrean paling depan:
```java
String depan = atm.peek();
```

### Back atau Tail

Mengakses elemen yang berada di antrean paling belakang:
```java
String belakang = atm.getLast();
```

### Pop atau Dequeue

Mengeluarkan elemen yang berada di antrean paling depan:
```java
atm.poll();
```

## Selengkapnya

- [Java Queue]([https://en.cppreference.com/w/cpp/container/queue](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html))
