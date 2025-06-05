import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int score = sc.nextInt();
        int rankNum = sc.nextInt();
        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            pq.add(num);
            if(num == score){
                cnt++;
            }
        }

        pq.add(score);
        int tmp = -1;
        int rank = 0;
        int count = 1;

        while(!pq.isEmpty()){

            int num =  pq.poll();

            if(tmp != num){
                tmp = num;
                rank += count;
                count = 1;
            } else{
                count++;
            }

            if(num == score) break;

        }

        if(rank + cnt > rankNum) System.out.println(-1);
        else System.out.println(rank);
    }
}
