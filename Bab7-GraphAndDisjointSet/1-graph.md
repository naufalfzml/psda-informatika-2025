# 1 - Graf

## Konsep Graf

Graf (atau graf) adalah suatu struktur data yang mendefinisikan **hubungan** antara suatu data dengan data lainnya. Suatu graf terdiri dari sekumpulan simpul (node) dan sisi (edge) yang menghubungkan antara simpul-simpul tersebut. Contoh di bawah ini mengilustrasikan sebuah pertandingan pada tahap grup UEFA Champions League:

![Ilustrasi Graf Berarah](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab7-GraphAndDisjointSet/img/directed-graph.png)

Contoh di atas merupakan contoh graf berjenis **graf berarah (directed graph)** karena setiap sisi (hasil pertandingan) memiliki **arah** dari satu simpul (klub sepak bola) ke simpul lainnya. Berikut contoh lainnya adalah graf Kota Surakarta:

![Ilustrasi Graf Tidak Berarah](https://github.com/Alfurqon02/Praktikum-SDA-2023/blob/main/Bab7-GraphAndDisjointSet/img/undirected-graph.png)

Contoh di atas merupakan contoh graf berjenis **graf tidak berarah (undirected graph)** karena setiap sisi (jarak antar tempat) tidak memiliki arah dari satu simpul (nama tempat) ke simpul lainnya.

Salah satu istilah yang digunakan dalam graf adalah **tetangga**, yang mengacu pada daftar simpul yang terhubung secara langsung dengan sebuah simpul.

## Implementasi

### Menggunakan Matriks Ketetanggaan (Adjacency Matrix)

Pada dasarnya, matriks ketetanggaan memanfaatkan konsep yang mirip dengan array dua dimensi yang merepresentasikan simpul-simpul dalam suatu graf. Mari kita lihat contoh penggunaan matriks ketetanggaan pada graf Liga Champions:

```Java
public enum Klub {
    REAL_MADRID,
    CHELSEA,
    AC_MILAN,
    VALENCIA,
    JUMLAH_KLUB
};

public enum Hasil {
    MENANG,
    SERI,
    KALAH
};

// ...

// matriks ketetanggaan
Hasil pertandingan[JUMLAH_KLUB][JUMLAH_KLUB];

// ...

pertandingan[AC_MILAN][VALENCIA] = MENANG;
pertandingan[VALENCIA][AC_MILAN] = KALAH;

pertandingan[REAL_MADRID][CHELSEA] = SERI;
pertandingan[CHELSEA][REAL_MADRID] = SERI;

// dan seterusnya ...

```

Atau pada graf Kota Surakarta:

```Java
public enum Tempat {
    RUMAH,
    UNIVERSITAS_SEBELAS_MARET,
    RUMAH_SAKIT_DR_MOEWARDI,
    SMP_NEGERI_8_SURAKARTA,
    PECEL_MADIUN_PUCANGSAWIT,
    SMP_NEGERI_4_SURAKARTA,
    SMA_NEGERI_3_SURAKARTA,
    JUMLAH_TEMPAT
};

// ...

// matriks ketetanggaan
double jarak[JUMLAH_TEMPAT][JUMLAH_TEMPAT];

// ...

jarak[RUMAH][UNIVERSITAS_SEBELAS_MARET] = 2.97;
jarak[UNIVERSITAS_SEBELAS_MARET][RUMAH] = 2.97;

jarak[UNIVERSITAS_SEBELAS_MARET][RUMAH_SAKIT_DR_MOEWARDI] = 2.86;
jarak[RUMAH_SAKIT_DR_MOEWARDI][UNIVERSITAS_SEBELAS_MARET] = 2.86;

jarak[PECEL_MADIUN_PUCANGSAWIT][SMA_NEGERI_3_SURAKARTA] = 2.28;
jarak[SMA_NEGERI_3_SURAKARTA][PECEL_MADIUN_PUCANGSAWIT] = 2.28;

// memberikan nilai 0 karena itu merupakan jarak ke dirinya sendiri
jarak[RUMAH][RUMAH] = 0.0;

// memberikan nilai negatif karena tidak ada jalur langsung dari RUMAH ke SMA NEGERI 3 Surakarta
jarak[RUMAH][SMA_NEGERI_3_SURAKARTA] = -1.0;
jarak[SMA_NEGERI_3_SURAKARTA][RUMAH] = -1.0;

// dan seterusnya ...

```

### Menggunakan Daftar Ketetanggaan (Adjacency List)

Daftar ketetanggaan adalah salah satu cara lain untuk merepresentasikan sebuah graf. Pada dasarnya, daftar ketetanggaan adalah sebuah array yang berisi semua simpul dalam graf, dan setiap elemennya berisi daftar tetangga serta sisi yang terhubung. Mari kita lihat contoh penggunaan daftar ketetanggaan pada graf Liga Champions:

```Java
class Pertandingan {
    Klub lawan;
    Hasil hasil;

    Pertandingan(Klub _lawan, Hasil _hasil) {
        lawan = _lawan;
        hasil = _hasil;
    }
};

// ...

// daftar ketetanggaan
List<Pertandingan>[] pertandingan = new ArrayList[JUMLAH_KLUB];

// ...

pertandingan[AC_MILAN].add(new Pertandingan(Klub.VALENCIA, Hasil.MENANG));
pertandingan[VALENCIA].add(new Pertandingan(Klub.AC_MILAN, Hasil.KALAH));

pertandingan[REAL_MADRID].add(new Pertandingan(Klub.CHELSEA, Hasil.SERI));
pertandingan[CHELSEA].add(new Pertandingan(Klub.REAL_MADRID, Hasil.SERI));

// dan seterusnya ...
```

Atau pada graf Kota Surakarta:

```Java
class Jarak {
    Tempat tujuan;
    double jarak;

    Jarak(Tempat _tujuan, double _jarak) {
        tujuan = _tujuan;
        jarak = _jarak;
    }
};

// ...

// daftar ketetanggaan
List<Jarak>[] jarak = new ArrayList[JUMLAH_TEMPAT];

// ...

jarak[RUMAH].add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET, 2.97));
jarak[UNIVERSITAS_SEBELAS_MARET].add(new Jarak(Tempat.RUMAH, 2.97));

jarak[UNIVERSITAS_SEBELAS_MARET].add(new Jarak(Tempat.RUMAH_SAKIT_DR_MOEWARDI, 2.86));
jarak[RUMAH_SAKIT_DR_MOEWARDI].add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET, 2.86));

jarak[PECEL_MADIUN_PUCANGSAWIT].add(new Jarak(Tempat.SMA_NEGERI_3_SURAKARTA, 2.28));
jarak[SMA_NEGERI_3_SURAKARTA].add(new Jarak(Tempat.PECEL_MADIUN_PUCANGSAWIT, 2.28));

// dan seterusnya ...
```

### Menggunakan Daftar Sisi (Edge List)

Daftar sisi juga dapat digunakan untuk merepresentasikan sebuah graf. Pada dasarnya, daftar sisi adalah sebuah list yang berisi semua sisi dalam graf. Mari kita lihat contoh penggunaan daftar sisi pada graf Liga Champions:

```Java
class Pertandingan {
    Klub pemain;
    Klub lawan;
    Hasil hasil;

    Pertandingan(Klub _pemain, Klub _lawan, Hasil _hasil) {
        pemain = _pemain;
        lawan = _lawan;
        hasil = _hasil;
    }
};

// daftar sisi
List<Pertandingan> pertandingan = new ArrayList<>();

// ...

pertandingan.add(new Pertandingan(Klub.AC_MILAN, Klub.VALENCIA, Hasil.MENANG));
pertandingan.add(new Pertandingan(Klub.VALENCIA, Klub.AC_MILAN, Hasil.KALAH));

pertandingan.add(new Pertandingan(Klub.REAL_MADRID, Klub.CHELSEA, Hasil.SERI));
pertandingan.add(new Pertandingan(Klub.CHELSEA, Klub.REAL_MADRID, Hasil.SERI));
```

Atau pada graf Kota Surakarta:

```Java
class Jarak {
    Tempat asal;
    Tempat tujuan;
    double jarak;

    Jarak(Tempat _asal, Tempat _tujuan, double _jarak) {
        asal = _asal;
        tujuan = _tujuan;
        jarak = _jarak;
    }
};

// daftar sisi
List<Jarak> jarak = new ArrayList<>();

// ...

jarak.add(new Jarak(Tempat.RUMAH, Tempat.UNIVERSITAS_SEBELAS_MARET, 2.97));
jarak.add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET, Tempat.RUMAH, 2.97));

jarak.add(new Jarak(Tempat.UNIVERSITAS_SEBELAS_MARET, Tempat.RUMAH_SAKIT_DR_MOEWARDI, 2.86));
jarak.add(new Jarak(Tempat.RUMAH_SAKIT_DR_MOEWARDI, Tempat.UNIVERSITAS_SEBELAS_MARET, 2.86));

jarak.add(new Jarak(Tempat.PECEL_MADIUN_PUCANGSAWIT, Tempat.SMA_NEGERI_3_SURAKARTA, 2.28));
jarak.add(new Jarak(Tempat.SMA_NEGERI_3_SURAKARTA, Tempat.PECEL_MADIUN_PUCANGSAWIT, 2.28));

```

### Kompleksitas

Berikut adalah tabel perbandingan kompleksitas ketika menggunakan adjacency matrix, adjacency list, atau edge list (dengan V sebagai jumlah simpul/node, E sebagai jumlah sisi, dan K sebagai jumlah tetangga suatu simpul):

| Tindakan                 | Adjacency Matrix | Adjacency List | Edge List |
| ------------------------ | ---------------- | -------------- | --------- |
| Menambahkan sisi         | O(1)             | O(1)           | O(1)      |
| Menghapus sisi           | O(1)             | O(K)           | O(E)      |
| Memeriksa keterhubungan  | O(1)             | O(K)           | O(E)      |
| Melakukan iterasi tetangga | O(V)             | O(K)           | O(E)      |
| Penggunaan memori        | O(V^2)           | O(E)           | O(E)      |

Pilihan implementasi graf tergantung pada kebutuhan spesifik Anda. Jika jumlah simpul relatif kecil dan Anda perlu sering melakukan pengecekan keterhubungan, adjacency matrix mungkin lebih efisien. Namun, jika jumlah simpul besar dan Anda lebih sering melakukan operasi penambahan atau penghapusan sisi, adjacency list atau edge list dapat lebih efisien.

**Catatan**: Implementasi di atas menggunakan C++ sebagai contoh, tetapi konsep ini dapat diterapkan pada bahasa pemrograman lainnya dengan cara yang serupa.
