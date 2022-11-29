package bakjoon_2002;

import java.io.*;
import java.util.*;

// 14284kb,	136ms
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<String> in = new ArrayDeque<>(n);
        Queue<String> out = new ArrayDeque<>(n);
        for(int i = 0; i < n ; ++i)
            in.add(br.readLine());

        for(int i = 0; i < n ; ++i)
            out.add(br.readLine());

        int ans = 0;
        while(!in.isEmpty())
        {
            if(in.peek().equals(out.peek()))
            {
                in.poll();
                out.poll();
                continue;
            }

            ans++;
            in.remove(out.poll());
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
