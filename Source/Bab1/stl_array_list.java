package Bab1;
import java.util.ArrayList;

public class stl_array_list {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        ArrayList<Integer> list1 = new ArrayList<>();

        // Mengisi ArrayList dengan elemen dari array a
        for (int i : a) {
            list1.add(i);
        }

        // Iterator maju
        System.out.println("Iterator maju:");
        for (int value : list1) {
            System.out.print(value + " ");
        }
    }
}
