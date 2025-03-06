package Bab1;
import java.util.LinkedList;

public class stl_linked_list3 {
    public static void main(String[] args) {
        LinkedList<Integer> angka = new LinkedList<>();
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        // Menampilkan elemen sebelum penggantian
        System.out.println("Sebelum diganti:");
        for (int value : angka) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Menghapus dua elemen terakhir
        angka.removeLast();
        angka.removeLast();

        // Menampilkan elemen setelah penggantian
        System.out.println("Setelah diganti:");
        for (int value : angka) {
            System.out.print(value + " ");
        }
    }
}
