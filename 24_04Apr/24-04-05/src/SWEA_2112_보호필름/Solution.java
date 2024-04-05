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
	static List<int[]> combination;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			flag = true;

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

			check();

			copy = new int[D][W];

			for (int i = 0; i < D; i++) {
				copy[i] = Arrays.copyOf(map[i], W);
			}

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

			combination = new ArrayList<>();

			for (int i = 1; i <= K; i++) {
				generateCombination(i);
			}

			OUT:

			while (!flag) {

				IT: for (int i = 0; i < result.size(); i++) {

					for (int k = 0; k < combination.size(); k++) {

						if (result.get(i).size() == combination.get(k).length) {

							for (int l = 0; l < result.get(i).size(); l++) {

								Arrays.fill(map[result.get(i).get(l)], combination.get(k)[l]);

							}
						}else if(result.get(i).size() < combination.get(k).length){
							continue IT;
						}

						answer = result.get(i).size();

						check();

						if (flag) {
							flag = false;
							break OUT;
						}

						for (int n = 0; n < D; n++) {
							map[n] = Arrays.copyOf(copy[n], W);
						}

					}
				}
			}

			if (!flag) {
				System.out.println("#" + tc + " " + answer);
			} else {
				System.out.println("#" + tc + " " + 0);
			}

		}

	}

	static void generateCombination(int x) {
		for (int i = 0; i < Math.pow(2, x); i++) {
			int[] com = new int[x];
			int temp = i;
			for (int j = x - 1; j >= 0; j--) {
				com[j] = temp % 2;
				temp /= 2;
			}
			combination.add(com);
		}
	}

	static void check() {

		This: for (int j = 0; j < W; j++) {
			int pass = 0;

			for (int i = 0; i <= D - K; i++) {
				int num = map[i][j];
				int cnt = 0;
				for (int k = 0; k < K; k++) {
					if (num == map[i + k][j]) {
						cnt++;
					}
				}
				if (cnt >= K) {
					pass++;
				}

			}

			if (pass < 1) {
				flag = false;
				return;
			} else if (pass >= 1) {
				continue This;
			}

		}
		flag = true;
		return;
	}
}
