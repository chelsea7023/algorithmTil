package BOJ_1654_나무자르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int end = 0;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (end < arr[i]) {
				end = arr[i];
			}
		}
		int start = 0;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			long tree = 0;

			for (int i = 0; i < N; i++) {
				int num = arr[i] - mid;
				if (num < 0) {
					num = 0;
				}
				tree += num;

			}

			if (tree >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(end);

	}
}
