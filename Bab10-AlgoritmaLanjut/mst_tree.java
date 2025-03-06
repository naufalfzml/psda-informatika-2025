import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sisi {
    int desa1;
    int desa2;
    int panjangJalan;

    Sisi(int desa1, int desa2, int panjangJalan) {
        this.desa1 = desa1;
        this.desa2 = desa2;
        this.panjangJalan = panjangJalan;
    }
}

public class mst_tree {

    // Temukan indeks desa dengan jarak minimum
    static int temukanDesaMinimum(int[] jarak, boolean[] sptSet, int jumlahDesa) {
        int minJarak = Integer.MAX_VALUE;
        int minDesa = -1;

        for (int desa = 0; desa < jumlahDesa; desa++) {
            if (!sptSet[desa] && jarak[desa] < minJarak) {
                minJarak = jarak[desa];
                minDesa = desa;
            }
        }

        return minDesa;
    }

    // Algoritma Prim untuk mencari Minimum Spanning Tree
    static List<Sisi> primMST(int[][] graph, int jumlahDesa) {
        List<Sisi> mst = new ArrayList<>(); // Minimum Spanning Tree
        int[] jarak = new int[jumlahDesa]; // Jarak minimum dari MST
        boolean[] sptSet = new boolean[jumlahDesa]; // Subset MST

        // Inisialisasi jarak
        Arrays.fill(jarak, Integer.MAX_VALUE);

        // Mulai dari desa pertama
        jarak[0] = 0;

        for (int count = 0; count < jumlahDesa - 1; count++) {
            int u = temukanDesaMinimum(jarak, sptSet, jumlahDesa);

            sptSet[u] = true;

            for (int v = 0; v < jumlahDesa; v++) {
                if (graph[u][v] != 0 && !sptSet[v] && graph[u][v] < jarak[v]) {
                    jarak[v] = graph[u][v];
                }
            }
        }

        // Konstruksi MST berdasarkan jarak minimum
        for (int desa = 1; desa < jumlahDesa; desa++) {
            for (int v = 0; v < jumlahDesa; v++) {
                if (graph[desa][v] == jarak[desa]) {
                    mst.add(new Sisi(desa, v, jarak[desa]));
                    break;
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int jumlahDesa = 6;

        int[][] graph = {
            {0, 4, 2, 0, 0, 0},
            {4, 0, 1, 5, 0, 0},
            {2, 1, 0, 8, 10, 0},
            {0, 5, 8, 0, 2, 6},
            {0, 0, 10, 2, 0, 3},
            {0, 0, 0, 6, 3, 0}
        };

        // Cari Minimum Spanning Tree menggunakan algoritma Prim
        List<Sisi> mst = primMST(graph, jumlahDesa);

        // Hitung panjang jalan terpendek yang dapat diaspal
        int panjangJalanTerpendek = 0;
        for (Sisi s : mst)
            panjangJalanTerpendek += s.panjangJalan;

        System.out.println("Panjang jalan terpendek yang dapat diaspal: " + panjangJalanTerpendek);
    }
}
