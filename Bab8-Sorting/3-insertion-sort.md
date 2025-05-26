# Insertion Sort

## Konsep
Insertion sort adalah algoritma pengurutan sederhana yang bekerja dengan membagi daftar menjadi dua bagian: bagian terurut dan bagian belum terurut. Algoritma ini memproses satu elemen pada satu waktu dan memasukkannya ke posisi yang tepat dalam bagian terurut. Algoritma ini lebih efisien daripada bubble sort dan selection sort dalam beberapa kasus.

![Ilustrasi Insertion Sort](img/insertion-sort_example-1.svg)

![Ilustrasi Insertion Sort](img/insertion-sort.gif)

[Ilustrasi Insertion Sort](https://visualgo.net/en/sorting)

### Kelebihan
- Sederhana dan mudah dipahami
- Efisien untuk jumlah data yang hampir terurut
- Dapat menjaga urutan relatif dari elemen yang bernilai sama

### Kekurangan
- Kompleksitas waktu yang tinggi "O(n^2)"
- Tidak efisien untuk reverse sorting (pengurutan terbalik)
- Penggunaan memori yang tidak efisien

### Contoh Penerapan
```java
public class Main {
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {23, 56, 9, 103, 77};
        int size = array.length;

        insertionSort(array);

        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
```

## Tambahan
[Visualisasi Insertion Sort](https://www.hackerearth.com/practice/algorithms/sorting/insertion-sort/visualize/)
