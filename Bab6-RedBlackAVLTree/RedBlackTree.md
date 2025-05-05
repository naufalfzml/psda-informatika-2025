# Red Black Tree
- [Red Black Tree](#red-black-tree)
  - [Pengertian](#pengertian)
  - [Aturan](#aturan)
  - [Algoritma](#algoritma)
    - [Insertion](#insertion)
    - [Deletion](#deletion)
  - [Kelebihan](#kelebihan)
  - [Kekurangan](#kekurangan)
  - [Contoh](#contoh)
  - [Implementasi](#implementasi)

## Pengertian
Red Black Tree adalah Binary Tree yang dapat melakukan *self balancing* dengan meninjau jumlah *black node* untuk setiap *subtree* yaitu harus sama. Hal ini menyebabkan Red Black Tree memiliki panjang *subtree* maksimal yaitu dua kali panjang *subtree* terpendek
## Aturan
- Setiap *node* berwarna **merah** atau **hitam**
- ***Root*** dan ***null leaf*** selalu berwarna **hitam**
- *Node* merah tidak boleh punya *child node* merah (**tidak ada dua merah berurutan**)
- Setiap *path* dari *root* ke *leaf* mengandung **jumlah *node* hitam yang sama** (*black height*)

## Algoritma
### Insertion
1. Memasukkan *node* baru dan memberi warna merah
2. Mencari posisi *node* baru:
   - Jika ditemukan warna ***parent* hitam**, ***insertion* berhasil**
   - Jika ditemukan warna ***parent* merah**, terjadi pelanggaran aturan (**aturan 3**), maka perlu melakukan **pemeriksaan *uncle node***:
     - **Jika *uncle* merah, maka melakukan ***passing blackness***** → mengubah warna *parent* dan *uncle* menjadi hitam untuk diteruskan ke atas (hingga warna *root* menjadi merah), lalu:
       - **Melakukan pemeriksaan *parent* dan *child node***. Jika ditemukan warna merah-merah, perlu melakukan pemeriksaan *uncle* lagi dari awal
       - **Mengubah kembali warna *root* menjadi hitam**
     - **Jika *uncle null* atau hitam, maka melakukan rotasi**, lalu menyesuaikan warna *parent* dengan *uncle* (berwarna hitam)

### Deletion
1. **Mencari posisi *node*** yang akan dihapus
2. **Mencari *node* pengganti** dengan mencari *child* *node* terbesar yang berada di *subtree* sebelah kiri
   - **Jika *node* pengganti berwarna merah, proses deletion dapat dilakukan tanpa masalah**
   - **Jika *node* pengganti berwarna hitam, dilakukan pemeriksaan *sibling node***:
     - Jika *sibling node* berwarna merah, dilakukan rotasi dan ubah warna lalu hapus *node* yang akan dihapus 
     - Jika *sibling node* berwarna hitam dan anak-anaknya berwarna hitam, ubah warna *sibling node* menjadi warna merah lalu hapus *node* yang akan dihapus
     - Jika *sibling node* berwarna hitam dan ada salah satu anak nya yang berwarna merah, lakukan rotasi dan ubah warna lalu hapus *node* yang akan dihapus
## Kelebihan
- Mampu melakukan *self-balancing*
- Kompleksitas waktu untuk *insertion, searching,* dan *deletion* yaitu **O(log n)**
- Kecepatan *insertion* dan *deletion* lebih cepat daripada AVL Tree
- Cocok untuk menyimpan data yang berubah secara dinamis
## Kekurangan
- Struktur *tree* tidak terlalu seimbang dengan maksimal toleransi perbedaan ketinggian antara *subtree*-nya yaitu dua kali dari ketinggian *subtree* terpendek
- Sehingga proses *searching* akan menjadi lebih lambat daripada AVL Tree
## Contoh
## Implementasi
```java
// Java Program implement 
// Red-Black Tree

enum Color {
    RED, BLACK
}

// Node Class
class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    Color color;

    // Constructor to create a new node
    Node(T data) {
        this.data = data;
      
          // New nodes are always red when inserted
        this.color = Color.RED; 
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root;
    private final Node<T> TNULL; // Sentinel node for null references

    // Constructor to initialize the Red-Black Tree
    public RedBlackTree() {
        TNULL = new Node<>(null);
        TNULL.color = Color.BLACK;
        root = TNULL;
    }

    // Preorder traversal helper function
    private void preOrderHelper(Node<T> node) {
        if (node != TNULL) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // Function to start preorder traversal
    public void preorder() {
        preOrderHelper(this.root);
    }

    // Inorder traversal helper function
    private void inOrderHelper(Node<T> node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    // Function to start inorder traversal
    public void inorder() {
        inOrderHelper(this.root);
    }

    // Postorder traversal helper function
    private void postOrderHelper(Node<T> node) {
        if (node != TNULL) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Function to start postorder traversal
    public void postorder() {
        postOrderHelper(this.root);
    }

    // Function to perform left rotation
    private void leftRotate(Node<T> x) {
        Node<T> y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Function to perform right rotation
    private void rightRotate(Node<T> x) {
        Node<T> y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Function to insert a new node
    public void insert(T key) {
        Node<T> node = new Node<>(key);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;
        node.color = Color.RED; // New node must be red

        Node<T> y = null;
        Node<T> x = this.root;

        // Find the correct position to insert the new node
        while (x != TNULL) {
            y = x;
            if (node.data.compareTo(x.data) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data.compareTo(y.data) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        // Fix the tree if the properties are violated
        if (node.parent == null) {
            node.color = Color.BLACK;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // Function to fix violations after insertion
    private void fixInsert(Node<T> k) {
        Node<T> u;
        while (k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = Color.BLACK;
    }

    // Main function to test the Red-Black Tree implementation
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(55);
        tree.insert(40);
        tree.insert(65);
        tree.insert(60);
        tree.insert(75);
        tree.insert(57);

        System.out.println("Preorder traversal:");
        tree.preorder();

        System.out.println("\nInorder traversal:");
        tree.inorder();

        System.out.println("\nPostorder traversal:");
        tree.postorder();
    }
}
```