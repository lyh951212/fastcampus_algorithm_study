package bakjoon_1991;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 *  메모리 : 14116 KB
 *  시간 : 124 ms
 * */

class Node {
    char left, right; // 왼쪽, 오른쪽 자식 저장

    public Node(char left, char right){
        this.left = left;
        this.right = right;
    }
}
public class moon_1991 {
    private static int N;
    private static ArrayList<Node>[] list;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 이진 트리 노드의 개수
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];

        for(int i=0; i<N; i++) list[i] = new ArrayList<>();

        // 노드 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            list[a-'A'].add(new Node(b, c));
        }
        // 전위 순회
        preOrder(0);
        sb.append('\n');

        // 중위 순회
        inOrder(0);
        sb.append('\n');

        // 후위 순회
        postOrder(0);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    // 전위 순회 (루트 - 왼쪽 - 오른쪽)
    public static void preOrder(int start) {
       for(Node node : list[start]){
            // 현재 노드의 왼쪽과 오른쪽 자식
            char left = node.left;
            char right = node.right;

            // 먼저 현재 노드를 저장 후, 왼쪽과 오른쪽 노드로 이동
            sb.append((char) (start+'A'));
            if(left != '.') preOrder(left-'A');
            if(right != '.') preOrder(right-'A');
       }
    }

    // 중위 순회 (왼쪽 - 루트 - 오른쪽)
    public static void inOrder(int start){
        for(Node node : list[start]){
            char left = node.left;
            char right = node.right;

            // 먼저 왼쪽 노드로 계속 이동 후 저장, 그리고 루트, 오른쪽 저장
            if(left != '.') inOrder(left-'A');
            sb.append((char) (start+'A'));
            if(right != '.') inOrder(right-'A');
        }
    }

    // 후위 순회 (왼쪽 - 오른쪽 - 루트)
    public static void postOrder(int start){
        for(Node node : list[start]){
            char left = node.left;
            char right = node.right;

            // 먼저 왼쪽 노드로 계속 이동 후 저장, 그리고 오른쪽, 루트 저장
            if(left != '.') postOrder(left-'A');
            if(right != '.') postOrder(right-'A');
            sb.append((char) (start+'A'));
        }
    }
}
