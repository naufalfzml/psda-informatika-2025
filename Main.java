import java.util.LinkedList;
import java.util.Queue;

// Java program to delete element in binary tree
public class Main {

    /* A binary tree node has key, pointer to left
    child and a pointer to right child */
    static class Node {
        int key;
        Node left, right;
    }

    /* function to create a new node of tree and
    return pointer */
    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    /* function to delete the given deepest node
    (d_node) in binary tree */
    static void deletDeepest(Node root, Node d_node) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Do level order traversal until last node
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == d_node) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == d_node) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == d_node) {
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }
    }

    /* function to delete element in binary tree */
    static Node deletion(Node root, int key) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (root.key == key)
                return null;
            else
                return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;
        Node key_node = null;

        // Do level order traversal to find deepest
        // node(temp) and node to be deleted (key_node)
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.key == key)
                key_node = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (key_node != null) {
            int x = temp.key;
            deletDeepest(root, temp);
            key_node.key = x;
        }
        return root;
    }

    // Driver code
    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(11);
        root.left.left = newNode(7);
        root.left.right = newNode(12);
        root.right = newNode(9);
        root.right.left = newNode(15);
        root.right.right = newNode(8);

        System.out.print("Inorder traversal before deletion : ");
        inorder(root);
        System.out.println();

        int key = 11;
        root = deletion(root, key);

        System.out.print("Inorder traversal after deletion : ");
        inorder(root);
    }
}
