import java.io.*;
import java.util.*;

/**
 *  메모리 : 14392 KB
 *  시간 : 140 ms
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 차의 대수
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();

        // 대근이가 적은 차량 번호 목록 입력
        for(int i=0; i<N; i++) hashMap.put(br.readLine(), i);

        int[] arr = new int[N];

        // 영식이가 적은 차량 번호 목록을 입력받는데, 그 차량이 처음에 터널에 들어갔을 때 순서를 배열에 저장
        for(int i=0; i<N; i++){
            arr[i] = hashMap.get(br.readLine());
        }

        // 터널에 먼저 빠져나간 차량 번호부터 하나씩 순서 비교
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                // 만약 터널에 먼저 빠져나간 차량 번호의 순서의 값이 뒷 차량 번호의 순서 값보다 크다면 (추월했다는 의미)
                if(arr[i] > arr[j]) {
                    // count
                    answer++;
                    break;
                }
            }
        }

        bw.write(answer+"");
        bw.flush();

        bw.close();
        br.close();
    }
}
