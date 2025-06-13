import java.util.*;

class Edge {
    int tujuan;
    int bobot;

    Edge(int tujuan, int bobot) {
        this.tujuan = tujuan;
        this.bobot = bobot;
    }
}

public class dijkstra {

    // Fungsi Dijkstra untuk mencari rute terpendek dari rumah ke sekolah
    static int[] dijkstra(List<List<Edge>> graph, int rumah, int jumlahVertex) {
        // Array jarak minimum dari rumah ke setiap vertex
        int[] jarak = new int[jumlahVertex];
        Arrays.fill(jarak, Integer.MAX_VALUE);

        // Inisialisasi jarak rumah ke dirinya sendiri dengan 0
        jarak[rumah] = 0;

        // Priority queue untuk memilih vertex dengan jarak minimum
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Masukkan rumah ke priority queue
        pq.offer(new int[]{0, rumah});

        while (!pq.isEmpty()) {
            // Ambil vertex dengan jarak minimum dari priority queue
            int[] current = pq.poll();
            int u = current[1];

            // Iterasi melalui semua tetangga vertex u
            for (Edge edge : graph.get(u)) {
                int v = edge.tujuan;
                int bobot = edge.bobot;

                // Perbarui jarak minimum jika ditemukan jarak yang lebih pendek
                if (jarak[u] + bobot < jarak[v]) {
                    jarak[v] = jarak[u] + bobot;
                    pq.offer(new int[]{jarak[v], v});
                }
            }
        }

        return jarak;
    }

    public static void main(String[] args) {
        int jumlahVertex = 7;
        int rumah = 0;
        int sekolah = 6;

        // Representasi graph menggunakan adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < jumlahVertex; i++) {
            graph.add(new ArrayList<>());
        }

        // Inisialisasi graph dengan sisi-sisi dan bobotnya
        graph.get(0).add(new Edge(1, 2)); // Rumah -> Vertex 1, bobot 2
        graph.get(0).add(new Edge(2, 4)); // Rumah -> Vertex 2, bobot 4
        graph.get(1).add(new Edge(2, 1)); // Vertex 1 -> Vertex 2, bobot 1
        graph.get(1).add(new Edge(3, 7)); // Vertex 1 -> Vertex 3, bobot 7
        graph.get(2).add(new Edge(4, 3)); // Vertex 2 -> Vertex 4, bobot 3
        graph.get(3).add(new Edge(5, 1)); // Vertex 3 -> Vertex 5, bobot 1
        graph.get(4).add(new Edge(6, 5)); // Vertex 4 -> Sekolah, bobot 5
        graph.get(5).add(new Edge(6, 2)); // Vertex 5 -> Sekolah, bobot 2

        // Panggil fungsi Dijkstra untuk mencari rute terpendek dari rumah ke sekolah
        int[] jarak = dijkstra(graph, rumah, jumlahVertex);

        // Cetak jarak terpendek dari rumah ke sekolah
        System.out.println("Jarak terpendek dari rumah ke sekolah: " + jarak[sekolah]);
    }
}
