package bakjoon_1991;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//14208kb	124ms
public class yeonhee_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        HashMap<Character, Character[]> tree = new HashMap<>(n);
        for(int i = 0; i < n ; ++i)
        {
            st = new StringTokenizer(br.readLine());
            Character key = st.nextToken().toCharArray()[0];
            Character left = st.nextToken().toCharArray()[0];
            Character right = st.nextToken().toCharArray()[0];

            tree.put(key, new Character[]{left, right});
        }

        ArrayList<Character> answer = new ArrayList<>(n);
        preorderPrint('A', tree, answer);
        for(Character c : answer)
            bw.write(c);
        bw.write("\n");

        answer.clear();
        inorderPrint('A', tree, answer);
        for(Character c : answer)
            bw.write(c);
        bw.write("\n");

        answer.clear();
        postorderPrint('A', tree, answer);
        for(Character c : answer)
            bw.write(c);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void preorderPrint(Character findNode, HashMap<Character, Character[]> tree, ArrayList<Character> answer){
        Character[] childNodes =tree.get(findNode);
        if(null == childNodes)
            return;

        answer.add(findNode);
        // 왼쪽 자식이 없으면 return
        if(childNodes[0].equals("."))
            return;
        preorderPrint(childNodes[0], tree, answer);

        if(childNodes[1].equals("."))
            return;
        preorderPrint(childNodes[1], tree, answer);
    }

    public static void inorderPrint(Character findNode, HashMap<Character, Character[]> tree, ArrayList<Character> answer){
        Character[] childNodes =tree.get(findNode);
        if(null == childNodes)
            return;

        // 왼쪽 자식이 없으면 return
        if(childNodes[0].equals("."))
            return;
        inorderPrint(childNodes[0], tree, answer);

        answer.add(findNode);

        if(childNodes[1].equals("."))
            return;
        inorderPrint(childNodes[1], tree, answer);
    }

    public static void postorderPrint(Character findNode, HashMap<Character, Character[]> tree, ArrayList<Character> answer){
        Character[] childNodes =tree.get(findNode);
        if(null == childNodes)
            return;
        // 왼쪽 자식이 없으면 return
        if(childNodes[0].equals("."))
            return;
        postorderPrint(childNodes[0], tree, answer);

        if(childNodes[1].equals("."))
            return;
        postorderPrint(childNodes[1], tree, answer);

        answer.add(findNode);
    }
}
