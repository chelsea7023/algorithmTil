package SWEA_2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, r, c, ans;
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

					dfs(visited, check, i, j, i, j, 1);
										
				}
			}
			
			System.out.println(ans);

		}
	}

	static void dfs(boolean[][] visited, List<Integer> list, int x, int y, int goal_x, int goal_y, int dp) {

		if(x == goal_x && y == goal_y && dp >= 4) {
			if(dp > ans) {
				ans = dp;
			}
		}
		
		
		
		for (int d = 0; d < 4; d++) {
			int nx = x + di[d];
			int ny = y + dj[d];
			if (!visited[nx][ny] && check(nx, ny) && !list.contains(map[nx][ny])) {
				visited[nx][ny] = true;
				list.add(map[nx][ny]);
				dfs(visited, list, nx, ny, goal_x, goal_y, dp + 1);
				visited[nx][ny] = false;
				list.remove(Integer.valueOf(map[nx][ny]));
			}if(nx == goal_x && ny == goal_y) {
				dfs(visited, list, nx, ny, goal_x, goal_y, dp);
			}
		}

	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
