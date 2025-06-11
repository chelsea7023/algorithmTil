import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            /*
            순위대로 집결이 되는데 우선 적으로 한바퀴를 돌며 실격하는팀을 찾기
            그 후 실격되는 팀 다 빼고 다시 순위 책정
            그 다음에 각 팀별 점수를 취합해서 점수가 높은 팀 우승
            만약 같으면 5번째 선수가 먼저 들어온팀 우승
             */

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
                map.merge(list.get(j), 1, Integer::sum);
            }

            map.entrySet().removeIf(entry -> entry.getValue() < 6);

//            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue());
//            }

            for (int j = 0; j < list.size(); ) {
                if (!map.containsKey(list.get(j))) {
                    list.remove(j);
                } else {
                    j++;
                }
            }

//            System.out.println(list);

            Map<Integer, List<Integer>> map2 = new HashMap<>();
            int num = 0;

            for (int j = 0; j < list.size(); j++) {
                if (map2.get(list.get(j)) == null || map2.get(list.get(j)).size() <= 3) {
                    map2.computeIfAbsent(list.get(j), k -> new ArrayList<>()).add(j + 1);
                }
            }

//            for(Map.Entry<Integer, List<Integer>> entry : map2.entrySet()){
//                System.out.println(entry.getValue());
//            }

            List<Integer> rank = new ArrayList<>();
            int max = Integer.MAX_VALUE;

            for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
                int sum = 0;
                for (int j = 0; j < entry.getValue().size(); j++) {
                    sum += entry.getValue().get(j);
                }

                if (sum < max) {
                    max = sum;
                }
            }

//            System.out.println(max);

            for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
                int sum = 0;
                for(int j = 0; j < entry.getValue().size(); j++){
                    sum += entry.getValue().get(j);
                }

                if(sum == max){
                    rank.add(entry.getKey());
                }
            }

            Map<Integer, Integer> map3 = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                if (rank.contains(list.get(j))) {
                    map3.merge(list.get(j), 1, Integer::sum);
                    if (map3.get(list.get(j)) == 5) {
                        num = list.get(j);
                        break;
                    }
                }
            }

            System.out.println(num);

        }


    }
}
