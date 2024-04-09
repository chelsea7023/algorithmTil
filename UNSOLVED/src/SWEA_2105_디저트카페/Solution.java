package SWEA_2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };
	static int[][] map;
	static boolean flag = false;
	static List<Integer> list = new ArrayList<>();
	static boolean[][] visited;
	static List<Integer> check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					check = new ArrayList<>();
					visited = new boolean[N][N];
					check.add(map[i][j]);
					visited[i][j] = true;
					dfs(i, j, i, j, 1);

				}
			}

			System.out.println(list);

		}
	}

	static void dfs(int x, int y, int r, int c, int dp) {

		if (x == r && y == c && visited[x][y] && dp > 2) {
			list.add(dp);
			return;
		}

		for (int d = 0; d < 4; d++) {

			int nx = x + di[d];
			int ny = y + dj[d];

			if (check(nx, ny) && !visited[nx][ny] && !check.contains(map[nx][ny])) {
				visited[nx][ny] = true;
				dfs(nx, ny, r, c, dp + 1);

			} else if (nx == r && ny == c && dp > 2) {
				dfs(nx, ny, r, c, dp + 1);
			}
		}

	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
