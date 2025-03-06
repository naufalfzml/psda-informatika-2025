package Bab4;
import java.util.HashSet;
import java.util.Iterator;

public class set2 {
    public static void main(String[] args) {
        HashSet<Integer> favNumbers = new HashSet<>();
        favNumbers.add(10);
        favNumbers.add(20);
        favNumbers.add(30);
        favNumbers.add(40);
        favNumbers.add(50);

        System.out.println("Sebelum ditambah: ");
        for (Iterator<Integer> it = favNumbers.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Iterator<Integer> itr = favNumbers.iterator();
        favNumbers.add(60);
        for (int i = 0; i < 2; i++) {
            if (itr.hasNext()) {
                itr.next();
            }
        }
        favNumbers.add(70);

        System.out.println("Setelah ditambah: ");
        for (Iterator<Integer> it = favNumbers.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
    }
}