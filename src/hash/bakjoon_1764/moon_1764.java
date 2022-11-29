package hash.bakjoon_1764;

import java.io.*;
import java.util.*;

/**
 *  메모리 : 26948 KB
 *  시간 : 344 ms
 * */

public class moon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 듣도 못한 사람의 수 입력
        int N = Integer.parseInt(st.nextToken());
        // 보도 못한 사람의 수 입력
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람을 저장하기 위한 HashSet
        HashSet<String> nHashSet = new HashSet<>();
        // 결과값을 저장하기 위한 TreeSet (오름차순 정렬하기 위해)
        TreeSet<String> answer = new TreeSet<>();

        // 듣도 못한 사람 입력
        for(int i=0; i<N; i++) nHashSet.add(br.readLine());

        // 보도 못한 사람을 입력하면서 듣도 못한 사람과 중복되는지 확인 후 TreeSet 에 저장
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(nHashSet.contains(name)) answer.add(name);
        }

        // 듣도 보도 못한 사람의 수 출력
        bw.write(answer.size()+"\n");

        Iterator<String> it = answer.iterator();

        // 듣도 보도 못한 사람을 출력
        while(it.hasNext()) bw.write(it.next()+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
