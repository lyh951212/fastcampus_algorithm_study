package stack_queue;

// 17104kb,	180ms
import java.io.*;
import java.util.*;
class ParkingLot
{
    private int id;
    private int weight;
    ParkingLot(int id, int weight)
    {
        this.id = id;
        this.weight = weight;
    }
    public int GetId(){return this.id;}
    public int GetWeight(){return this.weight;}
}
class Car{
    private int id;
    private int weight;        // 내 무게
    private ParkingLot parkingLot;
    Car(int id, int w){
        this.id = id;
        this.weight = w;
    }
    public int GetWeight(){return this.weight;}
    public void SetParkingLot(ParkingLot pl){ this.parkingLot = pl;}
    public ParkingLot GetParkingLot(){return this.parkingLot;}
}

public class bakjoon_5464 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // key: 주차장 고유번호, value : 단위무게
        TreeMap<Integer, Integer> Rs = new TreeMap<>();
        for(int i =0 ; i < n;++i)
            Rs.put(i+1, Integer.parseInt(br.readLine()));

        // 주차장 꽉 차면 queue에 넣어줌
        Queue<Integer> waitingCar = new ArrayDeque<>();
        // 자동차의 정보를 담는 map (key: 차 고유번호,  value: Car객체)
        TreeMap<Integer, Car> carInfo = new TreeMap<>();
        for(int i =0 ; i < m;++i)
        {
            Car car = new Car(i+1, Integer.parseInt(br.readLine()));
            carInfo.put(i+1, car);
        }

        int total = 0;
        for(int i =0 ; i < m*2;++i)
        {
            int carId = Integer.parseInt(br.readLine());
            // 양수일 때 들어오는 차, 음수일 때 나가는 차
            if(carId > 0)
            {
                Car inCar = carInfo.get(carId);
                // Rs크기 0이상이면 주차장에 자리가 있다는 뜻
                if(Rs.size() > 0)
                {
                    // 트리맵 형인 RS의 최소키는 주차장 고유id가 가장 작은 값을 뱉는다
                    int parkingLotId = Rs.firstKey();
                    int parkingLotWeight = Rs.get(parkingLotId);

                    // 자동차가 주차가능 하므로 Car클스의 ParkingLot 인스턴스 변수를 세팅해주기 위해 객체 생성
                    ParkingLot p = new ParkingLot(parkingLotId, parkingLotWeight);
                    inCar.SetParkingLot(p);

                    // 주차완료 후 parkingLotId번째 주차장은 사용 불가하니까 treemap에서 remove
                    Rs.remove(Rs.firstKey());

                    // 주차료 정산
                    int fee = parkingLotWeight * inCar.GetWeight();
                    total += fee;
                }
                else
                {
                    // 주차장 자리 없으니까 대기 하는 자동차 id들을 큐에 넣자
                    waitingCar.add(carId);
                }
            }
            else
            {
                // 주차장에서 나감 처리
                Car outCar = carInfo.get(Math.abs(carId));
                ParkingLot p = outCar.GetParkingLot();
                // 주차장에서 나가니까 parkinglot인스턴스 멤버변수 null로 초기화 해준다
                outCar.SetParkingLot(null);
                // 주차장 사용가능 하니까 treemap에 넣어준다 -> 자동으로 정렬됨
                Rs.put(p.GetId(),p.GetWeight());

                // 큐에 대기중인 차량이 있으면 집어넣기
                if(false == waitingCar.isEmpty())
                {
                    int waitCarId = waitingCar.poll();
                    Car waitCar = carInfo.get(waitCarId);
                    waitCar.SetParkingLot(p);
                    Rs.remove(Rs.firstKey());
                    int fee = p.GetWeight() * waitCar.GetWeight();
                    total += fee;
                }

            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        br.close();
        bw.close();
    }
}
