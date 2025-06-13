import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // 단어 수
        int M = Integer.parseInt(st.nextToken());
        // 단어 길이

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.length() >= M){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(
                Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(entry -> entry.getKey().length(), Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey)
        );

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : entryList){
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
