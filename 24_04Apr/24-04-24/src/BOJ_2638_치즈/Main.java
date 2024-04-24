package BOJ_2638_치즈;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		flag = false;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (!flag) {
			cnt++;
			bfs(map, 0, 0);
			make_cheese(map);
			flag = check_map(map);

		}
		System.out.println(cnt);

	}

	static boolean check_map(int[][] arr) {
		boolean ans = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					ans = false;
					break;
				}
			}
		}
		return ans;

	}

	static void make_cheese(int[][] arr) {

		Queue<int[]> cheese = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + di[d];
						int ny = j + dj[d];
						if (check(nx, ny) && map[nx][ny] == -1) {
							cnt++;
						}
					}
				}
				if (cnt >= 2) {
					cheese.add(new int[] { i, j });
				}
			}
		}

		while (!cheese.isEmpty()) {
			int[] curr = cheese.poll();
			int x = curr[0];
			int y = curr[1];
			map[x][y] = -1;
		}
	}

	static void bfs(int[][] arr, int start_x, int start_y) {
		Queue<int[]> air = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		map[start_x][start_y] = -1;
		visited[start_x][start_y] = true;
		air.add(new int[] { start_x, start_y });
		while (!air.isEmpty()) {
			int[] curr = air.poll();
			int x = curr[0];
			int y = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + di[d];
				int ny = y + dj[d];
				if (check_air(nx, ny) && !visited[nx][ny]) {
					map[nx][ny] = -1;
					air.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

		}

	}

	static boolean check_air(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && (map[x][y] == 0 || map[x][y] == -1);
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
