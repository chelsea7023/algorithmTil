import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 자르는 횟수
        int M = sc.nextInt();
        // 자를 수 있는 지점의 개수
        int L = sc.nextInt();
        // 롤케이크의 길이

        int[] cakeCut = new int[M + 1];
        for (int i = 0; i < M; i++) {
            cakeCut[i] = sc.nextInt();
        }
        cakeCut[M] = L;
        /*
        여기서 중요한 부분이 우리가 길이를 지속적으로 비교하며
        자르는 횟수를 만족하는 한에서 최대값을 구해야하므로
        마지막에 롤케이크의 길이도 넣어줘야 한다.
         */

        for (int i = 0; i < N; i++) {
            int cut = sc.nextInt();
            // 여기서 이제 자르는 횟수를 받아온다
            int answer = 0;
            // 가장 작은 길이의 최대값


            int left = 0;
            int right = cakeCut[M];

            while (left <= right) {
                int mid = (left + right) / 2;

                int cnt = 0;
                int prev = 0;
                for (int j = 0; j < cakeCut.length; j++) {
                    if (cakeCut[j] - prev >= mid) {
                        cnt++;
                        prev = cakeCut[j];
                    }
                }

                if (cnt > cut) {
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                } else {
                    right = mid - 1;
                }


            }

            System.out.println(answer);


        }


    }
}
