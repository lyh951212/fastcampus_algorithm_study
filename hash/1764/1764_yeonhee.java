package heap;

import java.io.*;
import java.util.*;

//26728kb	332ms
public class bakjoon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> notHearList = new HashSet<>(n);
        for(int i = 0; i < n ; ++i)
        {
            notHearList.add(br.readLine());
        }

        TreeSet<String> ans = new TreeSet<>();
        for(int i = 0; i < m ; ++i)
        {
            String notSee = br.readLine();
            if(notHearList.contains(notSee))
                ans.add(notSee);
        }

        // 정렬은 자동으로 된다
        bw.write(ans.size()+"\n");
        for(String name : ans)
            bw.write(name +"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
