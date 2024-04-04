package SWEA_2112_보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			boolean flag = true;
			
			int[] arr = new int[D];
			for(int i = 0; i < D; i++) {
				arr[i] = i;
			}
			List<Integer> list = new ArrayList<>();
			List<List<Integer>> result = new ArrayList<>();
			for(int i = 0; i < (1<<D); i++) {
				list = new ArrayList<>();
				for(int j = 0; j < D; j++) {
					if((i & (1 << j)) > 0) {
						list.add(arr[j]);
					}
				}
				result.add(list);
			}
			
			
			
			

		}

	}

}
