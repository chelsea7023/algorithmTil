package SWEA_1949_등산로조성;

import java.util.Scanner;

public class Solution {

	static int N, K;
	static boolean[][] visited;
	static int[][] map;
	static int[] di;
	static int[] dj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

		}

	}
	
	static int dfs(int x, int y, ) {
		
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			
			if(check(nx, ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
				visited[nx][ny] = false;
			}
		}
		
		
		
		
	}
	

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
