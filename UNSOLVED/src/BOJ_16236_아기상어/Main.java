package BOJ_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static int N, ans;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					dfs(i, j, 2, 0);
				}
			}
		}

		System.out.println(ans);
	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}
