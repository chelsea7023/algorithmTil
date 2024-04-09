package SWEA_2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };
	static int[][] map;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					boolean[][] visited = new boolean[N][N];

					List<Integer> check = new ArrayList<>();

					visited[i][j] = true;
					check.add(map[i][j]);

					dfs(map, visited, check, i, j, i, j, 1);

				}
			}

			if (!list.isEmpty()) {
				Collections.sort(list, Collections.reverseOrder());
				System.out.print("#" + tc + " " + list.get(0));
			} else {
				System.out.println(-1);
			}
		}
	}

	static void dfs(int[][] arr, boolean[][] visited, List<Integer> num, int x, int y, int r, int c, int dp) {
		if (x == r && y == c && visited[x][y] && dp >= 4) {
			list.add(dp);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + di[d];
			int ny = y + dj[d];

			if (check(nx, ny) && !visited[nx][ny] && !num.contains(map[nx][ny])) {
				visited[nx][ny] = true;
				num.add(map[nx][ny]);
				dfs(arr, visited, num, nx, ny, r, c, dp + 1);
//				visited[nx][ny] = false;
				num.remove(Integer.valueOf(map[nx][ny]));
			} else if (nx == r && ny == c && dp > 2) {
				dfs(arr, visited, num, nx, ny, r, c, dp);
			}

		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
