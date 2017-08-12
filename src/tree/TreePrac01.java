package tree;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TreePrac01 {
    private static HashMap<String, Tree> treeHashMap = new HashMap<>();
    private static StringBuilder bd = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/tree.txt")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Tree root = new Tree("A", null, null);
        treeHashMap.put("A", root);
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            if (!treeHashMap.containsKey(node)) {
                Tree newTree = new Tree(node, null, null);
                treeHashMap.put(node, newTree);
            }
            if (!left.equals(".")) {
                Tree newLeft = new Tree(left, null, null);
                treeHashMap.get(node).left = newLeft;
                treeHashMap.put(left, newLeft);
            }
            if (!right.equals(".")) {
                Tree newRight = new Tree(right, null, null);
                treeHashMap.get(node).right = newRight;
                treeHashMap.put(right, newRight);
            }
        }
        root.preorder();
        bd.append("\n");
        root.inorder();
        bd.append("\n");
        root.postorder();
        bd.append("\n");
        System.out.println(bd.toString());
    }

    private static class Tree {
        String root;
        Tree left;
        Tree right;


        public Tree(String root, Tree left, Tree right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        void preorder() {
            bd.append(this.root);
            if (this.left != null)
                this.left.preorder();
            if (this.right != null)
                this.right.preorder();
        }

        void postorder() {
            if (this.left != null)
                this.left.postorder();
            if (this.right != null)
                this.right.postorder();
            bd.append(this.root);
        }

        void inorder() {
            if (this.left != null)
                this.left.inorder();
            bd.append(root);
            if (this.right != null)
                this.right.inorder();

        }
    }
}
