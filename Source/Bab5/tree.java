package Bab5;
import java.util.ArrayList;
import java.util.List;

class Node {
    private int m_data;
    private List<Node> m_children;

    // Constructor
    public Node(int data) {
        m_data = data;
        m_children = new ArrayList<>();
    }

    // Method untuk menambahkan child ke parentnya
    public void insert(Node node) {
        m_children.add(node);
    }

    // Method untuk menghapus node berdasarkan indeks
    public boolean deleteNodeIndex(int index) {
        if (m_children.isEmpty() || index >= m_children.size()) {
            return false;
        } else {
            m_children.remove(index);
            return true;
        }
    }

    // Method untuk traversal preorder
    private void _preOrder(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println("> " + m_data);
        for (Node child : m_children) {
            child._preOrder(depth + 1);
        }
    }

    public void preOrder() {
        System.out.println("Preorder Traversal: ");
        _preOrder(0);
    }

    // Method untuk traversal postorder
    private void _postOrder(int depth) {
        for (Node child : m_children) {
            child._postOrder(depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println("> " + m_data);
    }

    public void postOrder() {
        System.out.println("Postorder Traversal: ");
        _postOrder(0);
    }
}

public class tree{
    public static void main(String[] args) {
        // Deklarasi objek node
        Node root = new Node(2);
        Node child_0 = new Node(7);
        Node child_1 = new Node(5);
        Node child_2 = new Node(2);
        Node child_3 = new Node(10);
        Node child_4 = new Node(6);
        Node child_5 = new Node(9);

        // Memasukkan child ke parentnya
        child_0.insert(child_2);
        child_0.insert(child_3);
        child_0.insert(child_4);
        child_1.insert(child_5);
        root.insert(child_0);
        root.insert(child_1);

        root.preOrder();
        root.postOrder();
    }
}
