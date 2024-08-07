import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        // 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구해야한다.

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i < K + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < K + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }

        System.out.println(dp[K][N]);


    }
}
