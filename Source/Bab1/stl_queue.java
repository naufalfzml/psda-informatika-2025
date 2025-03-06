package Bab1;
import java.util.LinkedList;
import java.util.Queue;

public class stl_queue{
    public static void main(String[] args) {
        Queue<String> atm = new LinkedList<>();

        // Push atau Enqueue - Memasukkan elemen ke bagian belakang antrean
        atm.add("John Nash");

        // Front atau Head - Mengakses elemen yang berada di antrean paling depan
        String depan = atm.peek();
        System.out.println("Elemen di depan antrean: " + depan);

        // Back atau Tail - Mengakses elemen yang berada di antrean paling belakang
        String belakang = ((LinkedList<String>) atm).getLast();
        System.out.println("Elemen di belakang antrean: " + belakang);

        // Pop atau Dequeue - Mengeluarkan elemen yang berada di antrean paling depan
        atm.poll();
    }
}