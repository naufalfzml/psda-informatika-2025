package Bab4;
import java.util.HashMap;
import java.util.Map;

public class map1 {
    public static void main(String[] args) {
        class Mahasiswa {
            String nama;
            String prodi;
            int angkatan;
        }

        Map<String, Mahasiswa> data_mhs = new HashMap<>();
        Mahasiswa mhs = new Mahasiswa();
        mhs.nama = "Bella Aster Kevia";
        mhs.prodi = "Informatika";
        mhs.angkatan = 2025;
        data_mhs.put("M0525025", mhs);

        data_mhs.get("M0525025").nama = "Afan";
        mhs = data_mhs.get("M0525025");
        // System.out.println("Nama: " + mhs.nama);
        // System.out.println("Prodi: " + mhs.prodi);
        // System.out.println("Angkatan: " + mhs.angkatan);

        // if (!data_mhs.containsKey("M0525025")) {
        //     System.out.println("M0525025 bukan merupakan mahasiswa UNS");
        // } else {
        //     System.out.println("M0525025 merupakan mahasiswa UNS");
        // }

        // data_mhs.remove("M0525025");
        // mhs = data_mhs.get("M0525025");
        // System.out.println("Nama: " + mhs.nama);
        // System.out.println("Prodi: " + mhs.prodi);
        // System.out.println("Angkatan: " + mhs.angkatan);

        for (Map.Entry<String, Mahasiswa> entry : data_mhs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().prodi);
        }

        // Map<String, Integer> map = new HashMap<>();
        // map.put("pertama", 10);
        // map.put("kedua", 20);
        // map.put("ketiga", 30);

        // System.out.println(map.get("satu"));
    }
}