package Bab4;
import java.util.HashSet;

public class set3 {
    public static void main(String[] args) {
        HashSet<Integer> favNumbers = new HashSet<>();
        favNumbers.add(10);
        favNumbers.add(20);
        favNumbers.add(10);
        favNumbers.add(30);
        favNumbers.add(40);
        favNumbers.add(50);

        System.out.println("Sebelum dihapus: ");
        for (int number : favNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        favNumbers.remove(10);
        favNumbers.remove(40);

        System.out.println("Setelah dihapus: ");
        for (int number : favNumbers) {
            System.out.print(number + " ");
        }
    }
}