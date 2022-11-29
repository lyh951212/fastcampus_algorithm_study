package bakjoon_3190;

import java.io.*;
import java.util.*;

/**
 *  메모리 : 15160 KB
 *  시간 : 152 ms
 * */

// 다른 분꺼 참고해서 풀었습니다........
public class moon_3190 {
    // x축과 y축 이동
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보드의 크기
        int N = Integer.parseInt(br.readLine());
        // 사과의 개수
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        HashMap<Integer, Character> hashMap = new HashMap<>();

        // 뱀의 머리 위치 저장
        LinkedList<int[]> snake = new LinkedList<>();

        // 초기 뱀의 위치
        snake.add(new int[] {0 ,0});

        // 사과 위치 입력
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            // 사과
            arr[a][b] = 1;
        }

        // 뱀의 방향 변환 횟수
        int L = Integer.parseInt(br.readLine());

        // 뱀의 방향 변환 정보 입력
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 시간
            char C = st.nextToken().charAt(0); // 방향 정보

            hashMap.put(X, C);
        }

        // 현재 위치, 다음 위치
        int currentX = 0, currentY = 0;
        int nextX, nextY;

        // 시간과 방향
        int time = 0;
        int dir = 0;

        while(true){
            time++;

            boolean flag = false;

            // 뱀의 머리 이동
            nextX = currentX + dx[dir];
            nextY = currentY + dy[dir];

            // 뱀이 자기자신과 부딪히면 flag를 true로
            for(int i=0; i<snake.size(); i++){
                int[] body = snake.get(i);
                if(nextY == body[0] && nextX == body[1]) {
                    flag = true;
                    break;
                }
            }

            // 뱀이 보드 크기를 벗어나면 종료
            if(nextX<0 || nextY<0 || nextX>=N || nextY>=N || flag) break;


            // 사과가 있을 경우
            if(arr[nextY][nextX] == 1){
                // 사과를 먹음
                arr[nextY][nextX] = 0;
                // 리스트에 뱀의 머리 정보 추가
                snake.add(new int[] {nextY, nextX});
            // 사과가 없을 경우
            } else {
                // 리스트에 뱀의 머리 정보 추가
                snake.add(new int[] {nextY, nextX});
                // 뱀의 꼬리 삭제
                snake.remove(0);
            }

            // 현재 위치 갱신
            currentX = nextX;
            currentY = nextY;

            // 뱀 방향이 바뀔 시간이 됐으면
            if(hashMap.containsKey(time)){
                // D일 경우, 오른쪽으로 90도 회전
                if(hashMap.get(time).equals('D')){
                    dir++;
                    if(dir==4) dir = 0;
                // L일 경우, 왼쪽으로 90도 회전
                } else if(hashMap.get(time).equals('L')){
                    dir--;
                    if(dir==-1) dir = 3;
                }
            }
        }

        bw.write(time+"");
        bw.flush();

        bw.close();
        br.close();
    }
}
