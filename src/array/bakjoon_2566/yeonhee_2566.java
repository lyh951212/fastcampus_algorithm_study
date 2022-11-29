package array.bakjoon2566;

import java.util.Scanner;

public class yeonhee_2566 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int maxXIdx = 0;
        int maxYIdx = 0;
        int[][] arr = new int[9][9];
        int max = 0;

        for(int i = 0; i < 9 ; ++i)
        {
            for(int j = 0; j < 9 ; ++j)
            {
                arr[i][j] = sc.nextInt();
                if(max < arr[i][j])
                {
                    max = arr[i][j];
                    maxXIdx = i;
                    maxYIdx = j;
                }
            }
        }

        System.out.print(max +"\n"+ (maxXIdx+1) +" "+(maxYIdx+1));
    }

}

// 18612kb,	248ms