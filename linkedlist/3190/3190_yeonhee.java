package linked_list;


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//15192kb,	172ms
public class bakjoon_3190 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N           = Integer.parseInt(br.readLine());
        int appleCnt    = Integer.parseInt(br.readLine());

        //{x,y} 형태로 넣어준다.
        ArrayList<Integer[]> applePos = new ArrayList<>();
        for(int i = 0; i < appleCnt;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            applePos.add(new Integer[]{x,y});
        }

        int directionChangeCnt  = Integer.parseInt(br.readLine());
        // move배열에서 인덱스 0 -> 3방향으로 갈수록 시계 방향으로 회전(오른쪽)
        int[][] move            = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int direction           = 0; // move배열의 인덱스
        int[] curDir            = {0,1}; // 현재 뱀이 가는 방향, 디폴트로 오른쪽으로(y좌표 증가) 가니까 {0,1}
        int[] curPos            = {1,1}; // 1,1 에서 뱀이 출발한다. 현재 위치
        HashMap<Integer, String> dirChangeInfo = new HashMap<>();
        for(int i = 0; i < directionChangeCnt;++i)
        {
            StringTokenizer st          = new StringTokenizer(br.readLine());
            int time                    = Integer.parseInt(st.nextToken());
            String dir                  = st.nextToken();
            dirChangeInfo.put(time,dir);
        }

        ArrayList<int[]> snakeBody = new ArrayList<>();
        snakeBody.add(new int[]{1,1});

        int duration = 0;
        while(true)
        {
            int[] snakeHeadPos = snakeBody.get(0);
            if(IsWall(snakeHeadPos, N))
               break;
            //---------------------------------------------
            // 현재 게임 지속하고 있는 시간이 방향이 바뀌는 타이밍이면 curDir 값을 변경해준다.
            if(dirChangeInfo.containsKey(duration))
            {
                String dirStr = dirChangeInfo.get(duration);
                if(dirStr.equals("D")) // 오른쪽 90도
                {
                    // x, y 위치 변경하면서 *1
                    ++direction;
                    if(direction >= 4)
                        direction = 0;
                    curDir   = move[direction];

                }
                else
                {
                    --direction;
                    if(direction < 0)
                        direction = 3;
                    curDir   = move[direction];
                }
            }
            //---------------------------------------------

            // 머리가 자신의 몸과 부딪혔는지 판별
            if(IsSnakeBody(snakeBody, new int[]{snakeHeadPos[0] + curDir[0], snakeHeadPos[1]+curDir[1]})) {
                duration++;
                break;
            }

            // 사과의 위치와 뱀의 머리가 부딪히면
            int applePosIdx = GetApplePositionIdx(applePos, snakeHeadPos);
            if(applePosIdx != -1)
            {
                // 몸 길어짐, 꼬리는 그대로
                curPos[0] += curDir[0];
                curPos[1] += curDir[1];

                snakeBody.add(0, curPos.clone());
                applePos.remove(applePosIdx);
            }
            else
            {
                curPos[0] += curDir[0];
                curPos[1] += curDir[1];
                snakeBody.add(0, curPos.clone());
                snakeBody.remove(snakeBody.size()-1);
            }
            duration++;
        }

        bw.write(String.valueOf(duration));
        bw.flush();
        br.close();
        bw.close();
    }

    static int GetApplePositionIdx(ArrayList<Integer[]> applePos, int[] snakeHeadPos)
    {
        for(int i = 0 ; i < applePos.size(); ++i)
        {
            Integer[] pos = applePos.get(i);
            if(snakeHeadPos[0] == pos[0] && snakeHeadPos[1] == pos[1])
                return i;
        }
        return -1;
    }

    static boolean IsWall(int[] snakeHead, int N) {
        if (snakeHead[0] < 1 || snakeHead[0] > N
                || snakeHead[1] < 1 || snakeHead[1] > N) {
            return true;
        }
        return false;
    }

    static boolean IsSnakeBody(ArrayList<int[]> snakeBody, int[] snakeHead)
    {
        for(int[] body : snakeBody)
        {
            if(body[0] == snakeHead[0] && body[1] == snakeHead[1])
                return true;
        }
        return false;
    }
}
