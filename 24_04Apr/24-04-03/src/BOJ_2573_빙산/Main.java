package BOJ_2573_빙산;

import java.util.Scanner;

public class Main {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean flag = false;

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

		int num = 0;

		OUT:

		while (true) {

			num++;

			visited = new boolean[N][M];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int cnt = 0;
					if (map[r][c] > 0) {
						visited[r][c] = true;
						for (int d = 0; d < 4; d++) {
							int nr = r + di[d];
							int nc = c + dj[d];
							if (map[nr][nc] <= 0 && check(nr, nc) && !visited[nr][nc]) {
								cnt++;
							}
						}
					}
					map[r][c] -= cnt;
				}
			}

//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}

			visited = new boolean[N][M];

			int count = 0;
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(max < map[r][c]) {
						max = map[r][c];
					}
					if (map[r][c] > 0 && !visited[r][c]) {
						visited[r][c] = true;
						dfs(r, c);
						count++;
						if (count >= 2) {
							flag = true;
							ans = num;
							break OUT;

						}
					}
				}
			}
			if(max == 0) {
				break OUT;
			}

		}

		if (flag) {
			System.out.println(ans);
		} else {
			System.out.println(0);
		}

		/*
		 * dfs로 푸는거 같은데 갈피가 잡히지 않아 저번에 풀었던 안전영역을 참고 했다. 여기서 고려해야될 부분은 한번 깎고 점검하고 한번 깎고
		 * 점검하고
		 */
	}

	static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + di[d];
			int ny = y + dj[d];

			if (map[nx][ny] > 0 && !visited[nx][ny] && check(nx, ny)) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}

		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
