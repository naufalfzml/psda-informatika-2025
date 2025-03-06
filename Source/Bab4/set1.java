package Bab4;
import java.util.HashSet;
import java.util.Iterator;

public class set1 {
    public static void main(String[] args) {
        HashSet<Integer> favNumbers = new HashSet<>();
        favNumbers.add(10);
        favNumbers.add(20);
        favNumbers.add(30);
        favNumbers.add(40);
        favNumbers.add(50);

        System.out.println("Penelurusan maju:");
        Iterator<Integer> iterator = favNumbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
