import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 카드의 수
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            queue.add(i + 1);
        }

        /*
        첫번째 동작은 맨 위 카드 버리기
        두번째 동작은 맨 위 카드 맨 아래로 놓기
        마지막 카드 나올때까지 무한 반복
         */
        int last = 0;

        for(int i = 0; i < N; i++){
            last = queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(last);
    }
}
