package bakjoon_1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class chan_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // create root node
        Node root = new Node(st.nextToken());
        createLeftAndRight(st, root);

        // create a tree
        for (int i = 0; i < total - 1; i++) {
            st = new StringTokenizer(br.readLine());
            Node findNode = search(st.nextToken(), root);
            createLeftAndRight(st, findNode);
        }

        preorder(root, bw);
        bw.write("\n");
        inorder(root, bw);
        bw.write("\n");
        postorder(root, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void preorder(Node root, BufferedWriter bw) throws IOException {
        if (root == null) {
            return;
        }
        bw.write(root.val);
        preorder(root.left, bw);
        preorder(root.right, bw);
    }

    public static void inorder(Node root, BufferedWriter bw) throws IOException {
        if (root == null) {
            return;
        }
        inorder(root.left, bw);
        bw.write(root.val);
        inorder(root.right, bw);
    }

    public static void postorder(Node root, BufferedWriter bw) throws IOException {
        if (root == null) {
            return;
        }
        postorder(root.left, bw);
        postorder(root.right, bw);
        bw.write(root.val);
    }

    public static void createLeftAndRight(StringTokenizer st, Node root) {
        String left = st.nextToken();
        if (left.equals(".")) {
            root.left = null;
        } else {
            root.left = new Node(left);
        }
        String right = st.nextToken();
        if (right.equals(".")) {
            root.right = null;
        } else {
            root.right = new Node(right);
        }
    }

    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static Node search(String val, Node node) {
        if (node != null) {
            if (node.val.equals(val)) {
                return node;
            } else {
                Node foundNode = search(val, node.left);
                if (foundNode == null) {
                    foundNode = search(val, node.right);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }
}

