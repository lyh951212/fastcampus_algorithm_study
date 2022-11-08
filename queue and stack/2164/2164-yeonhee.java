package stack_queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
//29540kb,	220ms
public class bakjoon_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> numQ = new ArrayDeque<>();
        for(int i = 0 ; i < n; ++i)
            numQ.add(i+1);

        while(numQ.size() > 1)
        {
            int front = numQ.poll();
            // 맨 위 카드를 버리고 나서 나머지가 2개 이상이면 맨앞카드를 맨뒤로 이동
            if(numQ.size() > 1) {
                numQ.add(numQ.poll());
            }
        }
        bw.write(String.valueOf(numQ.peek()));
        bw.flush();
        br.close();
        bw.close();
    }
}
