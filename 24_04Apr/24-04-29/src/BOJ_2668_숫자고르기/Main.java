package BOJ_2668_숫자고르기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] num;
	static int max = Integer.MIN_VALUE;
	static List<Integer> answer;
	static boolean result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		num = new int[2][N];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0) {
					num[i][j] = j + 1;
				} else {
					num[i][j] = sc.nextInt();

				}
			}
		}

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		boolean[] visited = new boolean[N];

		for (int i = N - 1; i >= 0; i--) {
			combination(arr, visited, 0, 0, i);
			if (!result) {
				continue;
			} else {
				break;
			}

		}

		Collections.sort(answer);

		System.out.println(max);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}

	static void combination(int[] arr, boolean[] visited, int start, int dp, int r) {

		if (dp == r) {

			boolean flag = false;
			List<Integer> list = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					list.add(i + 1);
					list2.add(num[1][i]);
				}
			}
			int cnt = 0;

			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				if (list2.contains(num)) {
					cnt++;
					flag = true;
					continue;
				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				answer = new ArrayList<>();
				max = cnt;
				for (int i = 0; i < list2.size(); i++) {
					answer.add(list2.get(i));
				}
				result = true;
				return;
			} else {
				return;
			}
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i + 1, dp + 1, r);
				visited[i] = false;
			}
		}

	}

}
