package bakjoon_1351;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//14328kb	128ms
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        HashMap<Long, Long> hashmap = new HashMap<>();
        hashmap.put(0L,1L);
        hashmap.put(1L,2L);

        bw.write(String.valueOf(GetAnswer(n,p,q,hashmap)));
        bw.flush();
        br.close();
        bw.close();
    }

    static long GetAnswer(long n, long p, long q, HashMap<Long, Long> hashmap)
    {
        if(hashmap.containsKey(n)) {
            return hashmap.get(n);
        }

        long value = GetAnswer(n/p, p, q,hashmap) + GetAnswer(n/q, p,q,hashmap);
        hashmap.put(n, value);
        return value;

    }
}
