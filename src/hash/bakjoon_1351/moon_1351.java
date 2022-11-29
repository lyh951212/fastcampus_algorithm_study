package hash.bakjoon_1351;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *  메모리 : 14440 KB
 *  시간 : 128 ms
 * */

public class moon_1351 {
    public static HashMap<Long, Long> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // A0 값을 처음에 저장
        hashMap.put(0L, 1L);

        bw.write(recur(N, P, Q)+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // 재귀 함수
    public static long recur(long n, int p, int q){
        // HashMap n 값이 있다면 값 반환
        if(hashMap.containsKey(n)) return hashMap.get(n);

        // 가우스 함수
        long value1 = (long) Math.floor(n/p);
        long value2 = (long) Math.floor(n/q);

        // HashMap에 N의 값을 저장하기 위해 재귀적으로 호출
        hashMap.put(n, recur(value1, p, q) + recur(value2, p, q));

        // 값 반환
        return hashMap.get(n);
    }
}
