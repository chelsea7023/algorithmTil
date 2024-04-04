package SWEA_2112_보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[][] copy;
	static int[][] map;
	static int D, W, K, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			copy = map;

			boolean flag = check();

			int[] arr = new int[D];
			for (int i = 0; i < D; i++) {
				arr[i] = i;
			}
			List<Integer> list = new ArrayList<>();
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < (1 << D); i++) {
				list = new ArrayList<>();
				for (int j = 0; j < D; j++) {
					if ((i & (1 << j)) > 0) {
						list.add(arr[j]);
					}
				}
				if (list.size() <= K && !list.isEmpty()) {
					result.add(list);
				}
			}

			Collections.sort(result, Comparator.comparingInt(List::size));

			int[] nums = new int[] { 0, 1 };

			OUT: while (!flag) {
				for (int i = 0; i < result.size(); i++) {

					for (int j = 0; j < result.get(i).size(); j++) {
						int num = result.get(i).get(j);
						Arrays.fill(map[num], nums[0]);
					}

					answer = result.get(i).size();
					flag = check();
					if (flag) {
						break OUT;
					}
					map = copy;

				}

			}
			if (flag) {
				System.out.println("#" + tc + " " + 0);
			} else {
				System.out.println("#" + tc + " " + answer);
			}

		}

	}

	static boolean check() {
		int pass = 0;
		This: for (int j = 0; j < W; j++) {
			for (int i = 0; i < D - K; i++) {
				int num = map[i][j];
				int cnt = 0;
				for (int k = 0; k < K; k++) {
					if (num == map[i + k][j]) {
						cnt++;
					}
				}
				if (cnt >= K - 1) {
					pass++;
					continue This;
				}

			}

		}
		if (pass >= W) {
			return true;
		} else {
			return false;
		}
	}

}
