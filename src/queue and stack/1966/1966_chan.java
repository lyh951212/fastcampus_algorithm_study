import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 15464 KB 160 ms
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 총 테스트 케이스 받기
        int N = Integer.parseInt(br.readLine());

        // 필요한 자료구조 선언
        // 하나는 우선순위 큐
        // 하나는 문서 큐
        // 하나는 결과 저장
        Queue<Integer> documentPriorities = new ArrayDeque<>();
        Queue<Integer> documents = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        // 필요한 변수 선언
        boolean checkHigherPriority = false;
        int printCount = 0;

        // 테스트 케이스 루프
        for (int i = 0; i < N; i++) {
            // 큐 초기화 & 프린트 카운트 초기화
            documents.clear();
            documentPriorities.clear();
            printCount = 0;

            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int targetDocument = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            while (st2.hasMoreTokens()) {
                documentPriorities.add(Integer.parseInt(st2.nextToken()));
            }

            for (int j = 0; j < M; j++) {
                documents.add(j);
            }

            // 메인 로직
            while (documentPriorities.size() != 0) {
                // 맨 앞의 문서보다 더 높은 우선순위가 있는지 체크
                checkHigherPriority = findHigherPriority(documentPriorities, documentPriorities.peek());
                // 있다면 뒤로 보내줌 (우선순위 큐, 문서 큐 같이)
                if (checkHigherPriority) {
                    documentPriorities.add(documentPriorities.poll());
                    documents.add(documents.poll());
                } else {
                    // 더 높은 우선 순위가 없다면 큐에서 제거 (우선순위, 문서 큐 둘다)
                    printCount++;
                    documentPriorities.poll();
                    int removed = documents.poll();
                    // 제거해준게 우리가 궁금한 문서라면 저장하고 루프 종료
                    if (removed == targetDocument) {
                        result.add(printCount);
                        break;
                    }
                }
            }
        }

        // 결과 출력
        for (Integer ele : result
        ) {
            bw.write(ele + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 더 높은 우선순위를 찾는 함수
    static boolean findHigherPriority(Queue<Integer> documentPriorities, int current) {
        for (Integer ele : documentPriorities
        ) {
            if (ele > current) {
                return true;
            }
        }
        return false;
    }
}