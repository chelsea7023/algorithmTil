package BOJ_17144_미세먼지안녕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C, T;
	static Queue<int[]> dust;
	static int[][] map;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];
		dust = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 4) {
					dust.add(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < T; i++) {

			while (!dust.isEmpty()) {
				var curr = dust.poll();
				int x = curr[0];
				int y = curr[1];
				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = x + di[d];
					int ny = y + dj[d];

					if (check(nx, ny)) {
						map[nx][ny] += map[x][y] / 5;
						cnt++;
					}
				}
				map[x][y] -= cnt * map[x][y]/5;

			}

		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C && map[x][y] != -1;
	}

}
