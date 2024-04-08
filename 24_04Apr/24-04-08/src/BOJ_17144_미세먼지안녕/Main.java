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
		int cleaner = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					cleaner = i; // 어차피 i 랑 i - 1 이니까 하나만 저장해도됨.
					map[i][j] = 0;
				}

			}
		}

		for (int tc = 0; tc < T; tc++) {

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] >= 4) {
						dust.add(new int[] { i, j, map[i][j] });
					}
				}
			}

			// 먼지 저장해주고

			while (!dust.isEmpty()) {

				var curr = dust.poll();
				int x = curr[0];
				int y = curr[1];
				int num = curr[2];
				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int nx = x + di[d];
					int ny = y + dj[d];

					if (check(nx, ny)) {
						map[nx][ny] += (num / 5);
						cnt++;
					}
				}
				map[x][y] -= cnt * (num / 5);

			}
			// 먼지의 값들을 빼주면서 맵 재조정
			
			
			int top = cleaner - 1;
			int down = cleaner;
			
			// 위 쪽은 반시계 방향으로 이동 
			// 1. 먼저 아래로 당겨주기 
			for(int i = top - 1; i > 0; i--) {
				map[i][0] = map[i - 1][0];
			}
			for()
			
			

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
