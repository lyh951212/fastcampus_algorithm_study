package bakjoon_11286;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//25924kb	352ms
class Value implements Comparable<Value>{
    int value;
    int absValue;

    Value(int value){
        this.value = value;
        this.absValue = Math.abs(value);
    }

    @Override
    public int compareTo(Value o) {
        if(absValue == o.absValue)
            return value - o.value;
        return absValue - o.absValue;
    }
}
public class yeonhee_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Value> pq = new PriorityQueue<>(n);
        for(int i = 0 ; i < n ; ++i)
        {
            int input = Integer.parseInt(br.readLine());
            if(0 == input)
            {
                int val = 0;
                if(pq.isEmpty())
                    bw.write(String.valueOf(0 + "\n"));
                else
                {
                    Value v = pq.poll();
                    bw.write(String.valueOf(v.value + "\n"));
                }
            }
            else
            {
                Value v = new Value(input);
                pq.add(v);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
