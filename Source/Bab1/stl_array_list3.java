package Bab1;
import java.util.ArrayList;
import java.util.function.Predicate;

public class stl_array_list3 {
    static boolean sama(int previous, int next) {
        return previous == next;
    }

    public static void main(String[] args) {
        int[] a = {10, 10, 20, 20, 20, 20, 30, 30, 30, 40, 40, 40, 50};
        ArrayList<Integer> list3 = new ArrayList<>();

        // Mengisi ArrayList dengan elemen dari array a
        for (int i : a) {
            list3.add(i);
        }

        // Menampilkan elemen-elemen ArrayList sebelum menghapus duplikat
        System.out.println("Sebelum elemen duplikat dihapus:");
        for (int value : list3) {
            System.out.print(value + " ");
        }

        // Menghapus nilai duplikat
        Predicate<Integer> predicate = (previous) -> {
            int index = list3.indexOf(previous);
            return index != list3.lastIndexOf(previous);
        };
        list3.removeIf(predicate);

        // Menampilkan elemen-elemen ArrayList setelah menghapus duplikat
        System.out.println("\nSetelah elemen duplikat dihapus:");
        for (int value : list3) {
            System.out.print(value + " ");
        }
    }
}
