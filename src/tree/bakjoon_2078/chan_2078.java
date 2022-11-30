package bakjoon_2078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class chan_2078 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        search(targetX, targetY);

    }

    public static void search(int targetX, int TargetY) {
        int left = 0;
        int right = 0;

        while ( targetX > 1  ||  TargetY > 1 ){
            if( targetX > TargetY ){
                int up = (targetX - 1) / TargetY;
                left += up;
                targetX -= up * TargetY;
            } else {
                int up = (TargetY - 1) / targetX;
                right += up;
                TargetY -= up * targetX;
            }
        }

        System.out.println(left + " " + right);

    }

}