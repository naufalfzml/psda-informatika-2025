import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Representasi struktur graph
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

public class mst_kruskal {

    // Fungsi untuk membandingkan panjang jalan pada sisi
    static Comparator<Sisi> perbandinganPanjangJalan = new Comparator<Sisi>() {
        @Override
        public int compare(Sisi s1, Sisi s2) {
            return s1.panjangJalan - s2.panjangJalan;
        }
    };

    // Temukan subset dari sebuah desa
    static int temukanSubset(int[] subset, int desa) {
        if (subset[desa] != desa) {
            subset[desa] = temukanSubset(subset, subset[desa]);
        }
        return subset[desa];
    }

    // Gabungkan dua subset menjadi satu subset
    static void gabungkanSubset(int[] subset, int desa1, int desa2) {
        int desa1Subset = temukanSubset(subset, desa1);
        int desa2Subset = temukanSubset(subset, desa2);
        subset[desa1Subset] = desa2Subset;
    }

    // Algoritma Kruskal untuk mencari Minimum Spanning Tree
    static List<Sisi> kruskalMST(List<Sisi> graph, int jumlahDesa) {
        List<Sisi> mst = new ArrayList<>(); // Minimum Spanning Tree
        int[] subset = new int[jumlahDesa];

        // Inisialisasi subset untuk setiap desa
        for (int desa = 0; desa < jumlahDesa; desa++) {
            subset[desa] = desa;
        }

        // Urutkan sisi berdasarkan panjang jalan dari terkecil ke terbesar
        Collections.sort(graph, perbandinganPanjangJalan);

        // Proses setiap sisi secara berurutan
        for (Sisi s : graph) {
            int desa1Subset = temukanSubset(subset, s.desa1);
            int desa2Subset = temukanSubset(subset, s.desa2);

            // Jika sisi ini tidak membentuk siklus, tambahkan ke MST
            if (desa1Subset != desa2Subset) {
                mst.add(s);
                gabungkanSubset(subset, desa1Subset, desa2Subset);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int jumlahDesa = 6;
        int jumlahJalan = 9;

        List<Sisi> graph = new ArrayList<>();
        graph.add(new Sisi(0, 1, 4));
        graph.add(new Sisi(0, 2, 2));
        graph.add(new Sisi(1, 2, 1));
        graph.add(new Sisi(1, 3, 5));
        graph.add(new Sisi(2, 3, 8));
        graph.add(new Sisi(2, 4, 10));
        graph.add(new Sisi(3, 4, 2));
        graph.add(new Sisi(3, 5, 6));
        graph.add(new Sisi(4, 5, 3));

        // Cari Minimum Spanning Tree menggunakan algoritma Kruskal
        List<Sisi> mst = kruskalMST(graph, jumlahDesa);

        // Hitung panjang jalan terpendek yang dapat diaspal
        int panjangJalanTerpendek = 0;
        for (Sisi s : mst) {
            panjangJalanTerpendek += s.panjangJalan;
        }

        System.out.println("Panjang jalan terpendek yang dapat diaspal: " + panjangJalanTerpendek);
    }
}
