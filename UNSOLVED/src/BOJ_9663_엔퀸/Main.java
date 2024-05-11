package BOJ_9663_엔퀸;

import java.util.Scanner;

public class Main {

	/*
	 * 1차 시도는 조합이었지만 말도 안됨 2차 시도는 하나 씩 놓으면서 모든 경우의 수 찾기
	 */
	static int N;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[][] map = new int[N][N];

	}

	static boolean dfs(int[][] map, boolean[] visited, int x, int y, int start, int r) {
		boolean flag = true;

		map[x][y] = 1;

	}

	static boolean check_q(int x, int y, int[][] map) {
		boolean flag = true;
		for(int i = 0; i < 4; i++) {
			
		}
		
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
