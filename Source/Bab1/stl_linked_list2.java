package Bab1;
import java.util.LinkedList;
import java.util.ListIterator;

public class stl_linked_list2 {
    public static void main(String[] args) {
        LinkedList<Integer> angka = new LinkedList<>();
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        // Menampilkan elemen maju
        System.out.println("Iterator maju:");
        ListIterator<Integer> it = angka.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Menampilkan elemen mundur
        System.out.println("Iterator mundur:");
        ListIterator<Integer> it1 = angka.listIterator(angka.size());
        while (it1.hasPrevious()) {
            System.out.print(it1.previous() + " ");
        }
    }
}
