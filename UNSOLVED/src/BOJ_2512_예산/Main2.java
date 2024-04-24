package BOJ_2512_예산;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] cost = new int[N];
		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextInt();
		}
		int total = sc.nextInt();
		int key = total / N;

		Arrays.sort(cost);

		BS(cost, key, total);

	}

	private static void BS(int[] arr, int key, int total) {
		int sum = 0;
		while (sum <= total) {
			int start = 0;
			int end = arr.length - 1;

			while (start <= end) {
				int mid = (start + end) / 2;

				if (key >= mid) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}

			}
		}
	}
}
