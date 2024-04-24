package BOJ_12865_평범한배낭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 물건의 수

		int K = sc.nextInt();
		// 가방 무게의 한계

		int[] weight = new int[N + 1];

		int[] value = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			// 1 ~ i 번째까지 물건을 고려하겠다.
			// 임시 무게 w에 대한 for 문도 돌아야함
			for (int w = 0; w <= K; w++) {
				// 내가 고려해야될 i번째의 물건의 무게가, 임시무게보다 적다면
				// 이 물건 넣을지 말지 고려를 해야함
				if (weight[i] <= w) {
					// 현재 w가 임시 무게보다 작다면
				} else {
					// 현재 가방에 넣을 수가 없음. 그러면 저에 것을 땡겨 오는 방식
					dp[i][w] = dp[i - 1][w];
				}
			}
		}

	}
}
