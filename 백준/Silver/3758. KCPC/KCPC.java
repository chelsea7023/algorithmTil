import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc < TC; tc++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            // 팀의 갯수
            int k = Integer.parseInt(st.nextToken());
            // 문제 갯수
            int t = Integer.parseInt(st.nextToken());
            // 내가 찾으려는 팀
            int m = Integer.parseInt(st.nextToken());
            // 로그의 갯수

            /*
            정렬 문제로
            1 순위는 총점
            2 순위는 문제 시도 횟수
            3 순위는 제출시간이 더 빠른 경우
            하나의 class를 만들어 총점, 도전 횟수, 마지막 제출시간을 넣어서 비교
             */

            class Player implements Comparable<Player>{
                int ID;
                Map<Integer, Integer> problems;
                int totalScore;
                int totalTrial;
                int lastSubmit;

                public Player(int ID, Map<Integer, Integer> problems, int totalScore, int totalTrial, int lastSubmit){
                    this.ID = ID;
                    this.problems = problems;
                    this.totalScore = totalScore;
                    this.totalTrial = totalTrial;
                    this.lastSubmit = lastSubmit;
                }

                @Override
                public int compareTo(Player o) {
                    if(this.totalScore != o.totalScore){
                        return o.totalScore - this.totalScore;
                    } else {
                        if(this.totalTrial != o.totalTrial){
                            return this.totalTrial - o.totalTrial;
                        } else{
                            return this.lastSubmit - o.lastSubmit;
                        }
                    }
                }
            }

            List<Player> list = new ArrayList<>();
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                // 팀 아이디
                int z = Integer.parseInt(st.nextToken());
                // 문제 번호
                int s = Integer.parseInt(st.nextToken());
                // 획득 점수

                boolean found = false;

                for(Player p : list){
                    if(p.ID == id){

                        if(p.problems.containsKey(z)){
                            if(s > p.problems.get(z)){
                                p.totalScore -= p.problems.get(z);
                                p.totalScore += s;
                                p.problems.replace(z, s);
                            }
                        } else{
                            p.problems.put(z, s);
                            p.totalScore += s;
                        }

                        p.totalTrial += 1;
                        p.lastSubmit = i + 1;

                        found = true;
                        break;
                    }
                }

                if(!found){
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(z, s);
                    list.add(new Player(id, map, s, 1, i + 1));
                }

            }

            Collections.sort(list);

//            for(Player p: list){
//                System.out.println(p.ID + " " + p.problems + " " + p.totalScore + " " + p.totalTrial + " " + p.lastSubmit);
//            }

            for(int i = 0; i < list.size(); i++){
                if(list.get(i).ID == t){
                    System.out.println(i + 1);
                }
            }
        }
    }


}
