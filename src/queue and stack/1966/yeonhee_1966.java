package stack_queue;

// 14724kb	156ms
import java.io.*;
import java.util.*;

class Document
{
    private int id;
    private int priority;
    public int GetId() {return this.id;}
    public  int GetPriority() {return this.priority;}
    Document(int _id, int _priority)
    {
        this.id = _id;
        this.priority = _priority;
    }
}
public class bakjoon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 프린터 큐
        Queue<Document> printerQ = new ArrayDeque<>();
        // 우선순위 값을 저장
        ArrayList<Integer> priorityList = new ArrayList<>();
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testcase; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; ++j)
            {
                int pri = Integer.parseInt(st.nextToken());
                Document doc = new Document(j, pri);
                // 큐, 우선순위 array에 저장
                printerQ.add(doc);
                priorityList.add(pri);
            }

            int ans = 0;
            // 우선순위를 오름차순한다. -> 우선순위가 가장 큰 값을 찾기 위해
            Collections.sort(priorityList);
            while(true)
            {
                // 프린터 큐에 맨 앞에 있는 문서를 꺼낸다
                Document doc = printerQ.peek();
                // 널 체크
                if(null == doc)
                    break;
                int maxPriority = priorityList.get(priorityList.size()-1);

                // 꺼낸 문서의 우선순위가 최대 우선순위 값이 아니면 맨 뒤로 보낸다
                if(doc.GetPriority() < maxPriority)
                    printerQ.add(printerQ.poll());
                else
                {
                    // 가장 우선순위가 높은 문서라면 프린트 해준다. -> 큐에서도 빼주고, 그에 해당하는 array도 삭제
                    printerQ.poll();
                    priorityList.remove(priorityList.size()-1);
                    // 프린트 된 횟수 카운트
                    ans++;
                    // 프린트 된 순서를 알고자 한 문서의 index와 같으면 while탈출해서 print해준다
                    if(doc.GetId() == m)
                        break;
                }
            }
            // 다음 테스트 케이스에도 활용될 컨테이너 비워준다.
            printerQ.clear();
            priorityList.clear();

            // 출력
            bw.write(String.valueOf(ans));
            if(i < testcase-1)
                bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
