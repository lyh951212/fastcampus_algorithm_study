import java.io.*;
import java.util.*;

/**
 *  메모리 : 14336 KB
 *  시간 : 132 ms
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 큐의 크기
        int N = Integer.parseInt(st.nextToken());
        // 뽑아내려고 하는 수의 개수
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        // ArrayList 선언
        ArrayList<Integer> list = new ArrayList<>();

        // 리스트에 값 추가
        for(int i=1; i<=N; i++) list.add(i);

        // 지민이가 뽑아내려고 하는 수의 위치를 순서대로 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int location = Integer.parseInt(st.nextToken());

            while(true) {
                // 지민이가 뽑아내려고 하는 수의 위치가 리스트에 어느 위치에 있는지 탐색
                int idx = list.indexOf(location);

                // 찾으려고 하는 값의 위치가 리스트 맨 앞에 위치할 경우 종료
                if(idx == 0) break;

                // 찾으려고 하는 값의 위치가 (리스트 크기 / 2)보다 크면 (오른쪽으로 한 칸 이동시키는 연산하는 게 더 효율적)
                if(idx > list.size()/2) {
                    // 현재 리스트의 마지막 값을 삭제 후 제일 앞에 추가
                    list.add(0, list.remove(list.size()-1));
                    count++;
                } else {
                    // 현재 리스트의 처음 값을 삭제 후 마지막에 추가
                    list.add(list.remove(0));
                    count++;
                }
            }

            // 리스트 맨 앞 삭제
            list.remove(0);
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();
    }
}
