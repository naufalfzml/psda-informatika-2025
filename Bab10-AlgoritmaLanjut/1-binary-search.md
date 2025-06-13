# 1 - Binary Search

Struktur Data Terkait : **Array List**

## Konsep

Binary search adalah suatu algoritma searching / pencarian efektif yang memiliki kompleksitas waktu O(log N). Satu-satunya syarat yang harus dimiliki oleh algoritma ini adalah elemen-elemennya di dalam array yang **harus sudah terurut**.

Cara kerja algoritma ini adalah membagi terus area pencarian menjadi dua bagian dan mencarinya di bagian yang memiliki kemungkinan terdapat elemen yang dicari sedangkan bagian yang lain diabaikan (lantas algoritma ini dikategorikan memiliki kompleksitas O(log N)).

Cara menentukan bagian area yang tepat adalah membandingkan urutan nilai yang dicari dengan nilai pada tengah-tengah area, kemudian cek:

- Apabila nilai yang dicari memiliki urutan lebih kecil dari nilai tengah maka bagian kirilah yang akan dipilih
- Kemudian apabila nilai yang dicari memiliki urutan lebih besar dari nilai tengah maka bagian kananlah yang akan dipilih
- Selebihnya apabila nilai yang dicari sama dengan nilai tengah maka elemen tersebut sudah ditemukan.

Pencarian dihentikan apabila area yang dicari sudah tidak memiliki elemen lagi (alias elemen tidak ditemukan).

Berikut adalah visualisasinya:

![visualisasi](https://d18l82el6cdm1i.cloudfront.net/uploads/bePceUMnSG-binary_search_gif.gif)

## Implementasi

```java

```