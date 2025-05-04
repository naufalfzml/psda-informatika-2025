# AVL Tree
- [AVL Tree](#avl-tree)
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
AVL Tree adalah Binary Tree yang dapat melakukan *self balancing* dengan meninjau selisih *height* subtree yaitu **harus tidak lebih dari 1**. Proses *self balancing* dilakukan dengan melakukan *rotating*.

## Aturan
```
balance factor = height of left subtree - height of right subtree
bf = hl - hr = {-1, 0, 1}
```

## Algoritma
>**Note:** perhitungan *height* dan *balance factor (bf)* pada *node* dilakukan dari *node* paling bawah

>**Note:** *rotation* dilakukan di antara *node* yang memiliki tanda *bf* yang sama dan *node* yang mengarah pada *subtree* tempat *node* baru diletakkan

### Insertion
1. **Mencari lokasi *node* baru** dengan membandingkan *node* baru dengan *root node*, lalu ke *children node* hingga mencapai pada lokasi yang sesuai
2. **Menganalisis balance factor**:
   - Jika ditemukan *balance factor* yang bernilai {2, -2}, maka dilakukan **rotasi**
3. **Mengulangi langkah 2**

### Deletion
1. **Mencari lokasi *node* yang akan dihapus** dengan membandingkan *node* yang dicari dengan *node-node* di dalam tree
2. **Mencari *node successor* (*node* pewaris)** yaitu *node* dengan nilai terkecil pada *subtree* sebelah kanan *node* yang akan dihapus
3. **Menghapus node** yang akan dihapus dan **mengganti *node* yang dihapus dengan *node successor***
4. **Melakukan *re-balancing***:
   - Menganalisis *balance factor*
   - Jika ditemukan *balance factor* yang bernilai {2,-2} maka dilakukan **rotasi**
   - Mengulangi proses menganalisis *balance factor* hingga semua *balance factor* pada *tree* memenuhi aturan

## Kelebihan
- Mampu melakukan *self-balancing*
- Kompleksitas waktu untuk *insertion, searching,* dan *deletion* yaitu **O(log n)**
- Kecepatan *searching* lebih cepat daripada Red Black Tree
## Kekurangan
- Melakukan *self-balancing* setiap kali melakukan proses operasi *insertion* dan *deletion*
- Sehingga proses *insertion* dan *deletion* lebih lambat daripada Red Black Tree
## Contoh

## Implementasi
```java
// Java program to insert a node in AVL tree 
import java.util.*;

class Node { 
    int key; 
    Node left; 
    Node right; 
    int height; 

    Node(int k) { 
        key = k; 
        left = null; 
        right = null; 
        height = 1; 
    }
} 

class GfG {

    // A utility function to get the
    // height of the tree 
    static int height(Node N) { 
        if (N == null) 
            return 0; 
        return N.height; 
    } 

    // A utility function to right rotate
    // subtree rooted with y 
    static Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 

        // Perform rotation 
        x.right = y; 
        y.left = T2; 

        // Update heights 
        y.height = 1 + Math.max(height(y.left), 
                                height(y.right)); 
        x.height = 1 + Math.max(height(x.left), 
                                height(x.right)); 

        // Return new root 
        return x; 
    } 

    // A utility function to left rotate 
    // subtree rooted with x 
    static Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 

        // Perform rotation 
        y.left = x; 
        x.right = T2; 

        // Update heights 
        x.height = 1 + Math.max(height(x.left),
                                height(x.right)); 
        y.height = 1 + Math.max(height(y.left), 
                                height(y.right)); 

        // Return new root 
        return y; 
    } 

    // Get balance factor of node N 
    static int getBalance(Node N) { 
        if (N == null) 
            return 0; 
        return height(N.left) - height(N.right); 
    } 

    // Recursive function to insert a key in
    // the subtree rooted with node 
    static Node insert(Node node, int key) { 
      
        // Perform the normal BST insertion
        if (node == null) 
            return new Node(key); 

        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else // Equal keys are not allowed in BST 
            return node; 

        // Update height of this ancestor node 
        node.height = 1 + Math.max(height(node.left), 
                                   height(node.right)); 

        // Get the balance factor of this ancestor node 
        int balance = getBalance(node); 

        // If this node becomes unbalanced,
        // then there are 4 cases 

        // Left Left Case 
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 

        // Right Right Case 
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 

        // Left Right Case 
        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 

        // Right Left Case 
        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 

        // Return the (unchanged) node pointer 
        return node; 
    } 

    // A utility function to print preorder 
    // traversal of the tree 
    static void preOrder(Node root) { 
        if (root != null) { 
            System.out.print(root.key + " "); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 

    // Driver code 
    public static void main(String[] args) { 
        Node root = null; 
        
        // Constructing tree given in the above figure 
        root = insert(root, 10); 
        root = insert(root, 20); 
        root = insert(root, 30); 
        root = insert(root, 40); 
        root = insert(root, 50); 
        root = insert(root, 25); 
        
        /* The constructed AVL Tree would be 
                  30 
                /   \ 
              20     40 
             /  \      \ 
           10   25     50 
        */
        System.out.println("Preorder traversal : "); 
        preOrder(root); 
    } 
}
```