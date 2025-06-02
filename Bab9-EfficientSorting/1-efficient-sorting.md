# Efficient Sorting

## Apa itu Efficient Sorting Algorithm?

Pada praktikum sebelumnya, teman-teman sudah belajar mengenai algoritma sorting yang simpel, seperti _insertion sort_, _selection sort_, dan _bubble sort_. Karakteristik dari algoritma sorting simpel di atas adalah kodenya yang simpel sehingga (relatif) lebih mudah dipahami, kompleksitas waktu yang (relatif) buruk, dan performanya yang kurang baik untuk data besar dan tidak tersortir dengan baik.

Oleh karena itu, penggunaan algoritma sorting sederhana hanya diperuntukkan untuk penggunaan-penggunaan yang sederhana pula, yaitu pada data berjumlah kecil atau sudah hampir tersortir.

Untuk penggunaan yang lebih _advanced_, diperlukan algoritma sorting yang lebih efisien. Dalam materi ini, akan dibahas 2 algoritma sorting yang sangat efisien dan digunakan secara luas, yaitu _quicksort_ dan _mergesort_.

## Quicksort

### Definisi

_Quicksort_ adalah algoritma pertama yang akan kita pelajari pada praktikum kali ini. _Quicksort_ adalah algoritma pengurutan _divide-and-conquer_ rekursif yang bekerja dengan memilih sebuah elemen _pivot_, dan membagi/mempartisi elemen lainnya, berdasarkan dari perbandingan nilai antara elemen tersebut dan elemen _pivot_.

### Kompleksitas Waktu dan Memori

-   Best Case: `O(n log n)` menggunakan _simple partition_
-   Average Case: `O(n log n)`
-   Worst Case: `O(n^2)`
-   Kompleksitas memori: secara garis besar `O(log n)`

### Pseudocode

Algoritma _quicksort_ dapat digambarkan dengan pseudocode di bawah.

```
quicksort(arr[], start, end)
    if start >= end
        return
    else
        p := partition(arr)
        quicksort(arr, start, p-1)
        quicksort(arr, p+1, end)
```

Algoritma _partition_ akan kita lompati untuk sekarang, yang memiliki fungsi:

-   Menentukan `pivot`, dapat mengambil nilai arbitrer atau random,
-   Meletakkan `pivot` ke posisinya dengan menukar posisi `pivot` dengan posisi yang seharusnya,
-   Mengurutkan bagian kanan dan kiri dari elemen `pivot`.

### Contoh Lengkap

Contoh lengkap dan simulasi grafis _quicksort_ dapat dilihat di [situs ini](https://visualgo.net/en/sorting), dan pilih _quicksort_.

## Mergesort

### Definisi

Algoritma sorting _Mergesort_ merupakan algoritma divide-and-conquer yang membagi set permasalahan yang akan diurutkan menjadi unit terkecil, lalu membandingkan masing-masing unit dengan unit di sebelahnya dan mengurutkannya. Langkah ini diulang terus-menerus hingga didapatkan hasil akhir berupa set permasalahan yang sudah terurut.

### Kompleksitas Waktu dan Memori

-   Best Case: `O(n log n)`
-   Average Case: `O(n log n)`
-   Worst Case: `O(n log n)`
-   Kompleksitas memori: `O(n)`

### Pseudocode

```
mergeSort(arr):
    if length of arr <= 1:
        return

    middle = length of arr / 2
    leftArr = new array of size middle
    rightArr = new array of size (length - middle)

    for i from 0 to length - 1:
        if i < middle:
            leftArr[i] = arr[i]
        else:
            rightArr[i - middle] = arr[i]

    mergeSort(leftArr)
    mergeSort(rightArr)
    merge(leftArr, rightArr, arr)
```

### Fungsi MergeSort(array)
```java
public static void mergeSort(int[] arr) {
        int length = arr.length;
        if(length <= 1) return; //apabila sudah tidak bisa dibagi

        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int i = 0; // untuk array kiri
        int j = 0; // untuk array kanan

        for(; i < length ; i++){
            if(i < middle){
                leftArr[i] = arr[i];
            } else{
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }
```

### Fungsi Merge(leftArr, rightArr, arr)
```java
private static void merge(int[] leftArr, int[] rightArr, int[] arr) {

        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int i = 0, l = 0, r = 0;

        // proses merging
        while (l < leftSize && r < rightSize) { 
            if(leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            } else{
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        while (l < leftSize) { 
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while (r < rightSize) { 
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }
```

### Contoh Lengkap

Contoh lengkap dan simulasi grafis _mergesort_ dapat dilihat di [situs ini](https://visualgo.net/en/sorting), dan pilih _mergesort_, atau perhatikan gif di bawah ini.

<div align="center">
<img src="https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif"></img>
</div>

## Perbandingan Quicksort dan Mergesort

-   Persamaan

    -   Keduanya merupakan algoritma pengurutan yang sangat efisien dan banyak digunakan untuk implementasi yang luas
    -   Merupakan algoritma divide-and-conquer yang membagi masalah besar menjadi banyak masalah-masalah kecil (submasalah)
    -   Dengan implementasi yang ideal, memiliki kompleksitas best case dan average case yang sepadan

-   Perbedaan

    -   _Mergesort_ memiliki kompleksitas worst case yang lebih baik yaitu `O(n log n)` daripada _quicksort_ `O(n^2)`
    -   _Mergesort_ memiliki kompleksitas ruang yang sedikit lebih buruk karena bukan merupakan algoritma pengurutan _in-place_, berbeda dengan _quicksort_
    -   _Quicksort_ bekerja lebih baik pada data yang kecil, sedangkan _mergesort_ tidak berbeda jauh performanya untuk data kecil maupun besar
