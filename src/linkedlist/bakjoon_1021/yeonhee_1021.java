package bakjoon_1021;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

//14272kb,	124ms
public class yeonhee_1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());

        ArrayList<Integer> numbersArr = new ArrayList<>(n);
        for(int i = 0 ; i < n; ++i )
        {
            numbersArr.add(i+1);
        }

        Queue<Integer> orderQ = new ArrayDeque<>(m);
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; ++i )
        {
            orderQ.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while(false == orderQ.isEmpty())
        {
            Integer firstNum = orderQ.peek();
            if(Objects.equals(numbersArr.get(0), firstNum))
            {
                numbersArr.remove(0);
                orderQ.poll();
                continue;
            }

            int idx = numbersArr.indexOf(firstNum);
            // 앞쪽에 있다 -> 2번
            if(idx <= (numbersArr.size())/2)
            {
                numbersArr.add(numbersArr.remove(0));
            }
            // 뒤쪽에 있다 -> 3번
            else
            {
                numbersArr.add(0, numbersArr.remove(numbersArr.size()-1));
            }
            ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
