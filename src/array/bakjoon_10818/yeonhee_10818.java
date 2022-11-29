package array.bakjoon_10818;

import java.util.*;
import java.io.BufferedReader;

class yeonhee_10818 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        // 배열 생성
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n ; ++i)
        {
            arr.add(sc.nextInt());
        }

        // 정렬
        Collections.sort(arr);

        // 출력
        System.out.print(arr.get(0) + " " + arr.get(n-1));
    }
}
// 메모리 : 333524kb
// 시간: 2380ms
