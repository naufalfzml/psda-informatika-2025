# Selection Sort

## Konsep
Selection sort adalah algoritma pengurutan sederhana yang bekerja dengan mencari elemen terkecil dari daftar dan menukar elemen tersebut dengan elemen pertama. Kemudian, mencari elemen terkecil kedua dari daftar yang belum terurut dan menukar elemen tersebut dengan elemen kedua. Proses ini berlanjut hingga seluruh daftar terurut. Algoritma ini dinamakan "selection sort" karena pada setiap langkahnya, algoritma memilih elemen terkecil dari sisa daftar yang belum terurut dan memindahkannya ke posisi yang sesuai.

![Ilustrasi Selection Sort](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab8-Sorting/img/selectionsort.png)

[Ilustrasi Selection Sort](https://visualgo.net/en/sorting)

### Kelebihan
- Sederhana dan mudah dipahami
- Dapat menjaga urutan relatif dari elemen elemen yang sama

### Kekurangan
- Kompleksitas waktu yang tinggi "O(n^2)"
- Tidak efisien untuk data yang hampir terurut
- Penggunaan memori yang tidak efisien

### Contoh Penerapan
<!-- 
```java
public class Main {
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 2, 8, 1, 4};
        int size = array.length;

        selectionSort(array);

        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
``` -->

## Tambahan
[Visualisasi Selection Sort](https://www.hackerearth.com/practice/algorithms/sorting/selection-sort/visualize/)
