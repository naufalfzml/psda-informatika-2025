package Bab9;
import java.util.Random;

public class bogosort {
    // To check if array is sorted or not
    static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // To generate permutation of the array
    static void shuffle(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(a.length);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    // Sorts array a[0..n-1] using Bogo sort
    static void bogosort(int[] a) {
        // if array is not sorted then shuffle
        // the array again
        while (!isSorted(a)) {
            shuffle(a);
        }
    }

    // prints the array
    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        bogosort(a);
        System.out.println("Sorted array:");
        printArray(a);
    }
}
