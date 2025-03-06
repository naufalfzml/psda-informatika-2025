package Bab1;
import java.util.Stack;

public class stl_stack {
    public static void main(String[] args) {
        Stack<Integer> usia = new Stack<>();

        // Menambah 3 elemen: 10, 20, 30
        for (int i = 0; i < 3; i++) {
            usia.push((i + 1) * 10);
        }

        System.out.println("Mengambil isi stack: ");
        for (int i = 0; i < 3; i++) {
            int data = usia.peek(); // Mengakses nilai elemen teratas (paling atas)
            System.out.println(data);
            usia.pop();
        }
    }
}
