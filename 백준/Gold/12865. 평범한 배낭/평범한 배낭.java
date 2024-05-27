import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		/*
		 * dp 2차원 배열에 맞게 입력을 해야하는데 dp의 기본은
		 * 내가 앞서 구한 최대값을 잘 저장해서 다음 경우의 수를 줄이는 것
		 * 
		 */
		
		for (int i = 1; i <= N; i++) {

			for (int w = 1; w <= K; w++) {

				if (weight[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}

		}
		System.out.println(dp[N][K]);

	}
}
