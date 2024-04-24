package BOJ_2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int ans;
	static int sum;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] cost = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
//		int key = total / N;

		Arrays.sort(cost);
//		System.out.println(Arrays.toString(cost));
		int key = cost[N - 1];

		if (sum <= total) {
			ans = cost[N - 1];
		} else {
			BS(cost, key, total);
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(ans);
//		System.out.println(sb);

	}

	private static void BS(int[] arr, int key, int total) {
		while (!flag) {
			int start = 0;
			int end = arr.length - 1;
			int mid = 0;
			sum = 0;
			while (start < end) {
				mid = (start + end) / 2;

				if (key == arr[mid]) {
					return;
				} else if (key > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			for (int i = 0; i < start; i++) {
				sum += arr[i];
			}
			for (int i = start; i < arr.length; i++) {
				sum += key;
			}
			key--;
			System.out.println(sum);
			if (sum < total) {
				flag = true;
			}
		}
		ans = key;
	}
}
