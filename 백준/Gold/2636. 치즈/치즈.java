import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		boolean flag = false;
		List<Integer> num = new ArrayList<>();

		while (!flag) {

			melting(map);
			bfs();
			num.add(left_cheese(map));
			flag = check_cheese(map);
			cnt++;

		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.print(cnt - 1 + " " + num.get(cnt - 2));

	}

	static void bfs() {
		Queue<int[]> cheese = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		cheese.add(new int[] { 0, 0 });
		map[0][0] = -1;
		while (!cheese.isEmpty()) {
			int[] curr = cheese.poll();
			int x = curr[0];
			int y = curr[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + di[d];
				int ny = y + dj[d];
				if (check_bfs(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					cheese.add(new int[] { nx, ny });
					map[nx][ny] = -1;
				}

			}

		}
	}

	static boolean check_cheese(int[][] arr) {
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	static int left_cheese(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void melting(int[][] arr) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (check(ni, nj) && map[ni][nj] == -1) {
							cnt++;
						}
					}
					if (cnt >= 1) {
						q.add(new int[] { i, j });
					}

				}
			}
		}
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			map[x][y] = 0;
		}

	}

	static boolean check_bfs(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && (map[x][y] == 0 || map[x][y] == -1);
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
