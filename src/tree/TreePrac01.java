package tree;

import java.io.*;
import java.util.StringTokenizer;

public class TreePrac01 {
    private static StringBuilder bd = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/tree.txt")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Tree tree = new Tree(new Node('A'));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(data, left, right);
        }
        tree.preorder(tree.root);
        bd.append("\n");
        tree.inorder(tree.root);
        bd.append("\n");
        tree.postorder(tree.root);
        bd.append("\n");
        System.out.println(bd.toString());
    }

    private static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }

    }

    private static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void add(char data, char left, char right) {
            if (root == null) {
                root = new Node(data);
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
                return;
            } else {
                search(root, data, left, right);
            }
        }

        public void search(Node root, char data, char left, char right) {
            if (root.data == data) {
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                if (root.left != null)
                    search(root.left, data, left, right);
                if (root.right != null)
                    search(root.right, data, left, right);
            }
        }

        void preorder(Node node) {
            bd.append(node.data);
            if (node.left != null)
                preorder(node.left);
            if (node.right != null)
                preorder(node.right);
        }

        void postorder(Node node) {
            if (node.left != null)
                postorder(node.left);
            if (node.right != null)
                postorder(node.right);
            bd.append(node.data);
        }

        void inorder(Node node) {
            if (node.left != null)
                inorder(node.left);
            bd.append(node.data);
            if (node.right != null)
                inorder(node.right);
        }
    }
}
