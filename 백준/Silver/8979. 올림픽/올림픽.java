import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        class Medal implements Comparable<Medal>{

            int country;
            int gold;
            int silver;
            int bronze;

            public Medal(int country, int gold, int silver, int bronze){
                this.country = country;
                this.gold = gold;
                this.silver = silver;
                this.bronze = bronze;
            }

            @Override
            public int compareTo(Medal o) {
                if(this.gold != o.gold){
                    return o.gold - this.gold;
                } else if(this.silver != o.silver){
                    return o.silver - this.silver;
                } else {
                    return o.bronze - this.bronze;
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Medal> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int country = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();

            Medal medal = new Medal(country, gold, silver, bronze);

            pq.add(medal);
        }

        int sequence = 0;

        /*
        모든 메달의 갯수가 같을 경우가 관건인데...
        메달에 점수를 부여하는 방식은 오히려 위험하고
        메달 별로 줄을 세우는건 맞는거 같은데

         */

        Medal tmp = new Medal (0, 0, 0, 0);
        int cnt = 0;

        for(int i = 0; i < N; i++){
            sequence++;

            Medal medal = pq.poll();

            if(tmp.gold != medal.gold || tmp.silver != medal.silver || tmp.bronze != medal.bronze){
                tmp.gold = medal.gold;
                tmp.silver = medal.silver;
                tmp.bronze = medal.bronze;
                sequence += cnt;
                cnt = 0;
            } else{
                cnt++;
                sequence--;
            }

            if(medal.country == K){
                System.out.println(sequence);
                break;
            }
        }


    }
}
