package bakjoon_5464;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 15760 KB 164 ms
public class chan_5464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalIncome = 0;

        // 필요한 데이터 자료구조 선언
        Queue<Integer> waitingCars = new ArrayDeque<>();
        int[] parkingSpace = new int[N];
        int[] priceParkingSpace = new int[N];
        int[] weightPerCar = new int[M];
        int[] parkingHistory = new int[2 * M];

        // 값 입력 받기
        for (int i = 0; i < parkingSpace.length; i++) {
            parkingSpace[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            priceParkingSpace[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            weightPerCar[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * M; i++) {
            parkingHistory[i] = Integer.parseInt(br.readLine());
        }

        // 메인 로직
        for (int car : parkingHistory) {
            // 차 주차
            if (car > 0) {
                // 주차장 꽉 찼는지 확인 그리고 기다려야 하는 차 큐에 넣어주기
                if (countParkingSpace(parkingSpace) == N) {
                    waitingCars.add(car);
                    // 꽉 차지 않았으면 차를 빈 주차장에 넣어준다
                } else {
                    int emptyParkingSpace = findEmptySpace(parkingSpace);
                    parkingSpace[emptyParkingSpace] = car;
                }
                // 차 빼기
            } else {
                int removedCar = -car;
                int parkedSpace = getParkedSpace(parkingSpace, removedCar); // 어디에 주차되어있는지 찾기
                totalIncome += priceParkingSpace[parkedSpace] * weightPerCar[removedCar - 1]; // 주차료 정산
                parkingSpace[parkedSpace] = 0; // 주차되있던 공간 초기화

                // 기다리고 있는 차가 있는지 확인
                if (!waitingCars.isEmpty()) {
                    int emptySpace = findEmptySpace(parkingSpace); // 빈 주차장 확인
                    parkingSpace[emptySpace] = waitingCars.poll(); // 빈 주차장에 기다리던 차 넣어주기
                }
            }
        }

        bw.write(String.valueOf(totalIncome));
        bw.flush();
        bw.close();
        br.close();
    }

    // 주차 되어 있는 주차장 반환
    public static int getParkedSpace(int[] arr,int value) {
        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }

    // 주차 되어 있는 주차장 모두 카운트
    public static int countParkingSpace(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        return count;
    }

    // 빈 주차장 찾기
    public static int findEmptySpace(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}