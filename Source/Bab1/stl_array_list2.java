package Bab1;
import java.util.ArrayList;

public class stl_array_list2 {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 50};
        ArrayList<Integer> list2 = new ArrayList<>();

        // Mengisi ArrayList dengan elemen dari array a
        for (int i : a) {
            list2.add(i);
        }

        // Menampilkan elemen-elemen ArrayList
        System.out.println("Sebelum dihapus:");
        for (int value : list2) {
            System.out.print(value + " ");
        }

        // Menghapus elemen pertama dan elemen-elemen dengan nilai 50
        list2.remove(0); // Menghapus elemen pertama
        list2.removeIf(n -> n == 50); // Menghapus semua kemunculan nilai 50 dalam ArrayList

        // Menampilkan elemen-elemen ArrayList setelah dihapus
        System.out.println("\nSetelah dihapus:");
        for (int value : list2) {
            System.out.print(value + " ");
        }
    }
}
