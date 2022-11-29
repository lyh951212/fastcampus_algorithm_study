import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// 	17796kb,	340ms
public class Main {
    public static void main(String[] args) throws IOException {
        // 사용할 컨테이너
        LinkedList<Integer> numList = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // 입출력 관련
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int gap = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n; ++i)
        {
            numList.add(i+1);
        }

        // 컨테이너가 다 없어질 때까지 while문을 돈다
        Iterator<Integer> iter = numList.iterator();
        while(!numList.isEmpty())
        {
            // iter가 가리키는 값을 저장
            int curNum = 0;
            for(int i = 0 ; i < gap;++i)
            {
                // 현재 iterator가 가리키는 next가 없으면 다시 처음부터 순회해야해서 초기화해준다.
                if(!iter.hasNext())
                    iter = numList.iterator();

                curNum = iter.next();
            }

            // gap만큼 iterator를 이동시킨 후 iterator가 가리키는 값을 저장한다.
            ans.add(curNum);
            // 현재 iter가 가리키는 것 삭제 -> numList에도 삭제됨
            iter.remove();
        }
        bw.write('<');
        for(int i = 0 ; i < n;++i)
        {
            if(i == n-1)
                bw.write(ans.get(i)+">");
            else
                bw.write(ans.get(i)+", ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
