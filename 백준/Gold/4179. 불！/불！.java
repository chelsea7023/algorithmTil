import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		char[][] map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int ans = bfs(map);

		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);

		sc.close();
	}

	static int bfs(char[][] arr) {

		Queue<int[]> jeehoon = new ArrayDeque<>();
		Queue<int[]> fire = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'F') {
					fire.add(new int[] { i, j });
				} else if (arr[i][j] == 'J') {
					visited[i][j] = true;
					jeehoon.add(new int[] { i, j, 0 });
				}
			}
		}

		while (!jeehoon.isEmpty()) {

			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				var curr = fire.poll();

				int x = curr[0];
				int y = curr[1];

				for (int d = 0; d < 4; d++) {
					int nx = x + di[d];
					int ny = y + dj[d];

					if (check(nx, ny) && arr[nx][ny] != '#' && arr[nx][ny] != 'F') {
						arr[nx][ny] = 'F';
						fire.add(new int[] { nx, ny });
					}
				}
			}

			int jeehoonSize = jeehoon.size();
			for (int i = 0; i < jeehoonSize; i++) {
				var curr = jeehoon.poll();
				int x = curr[0];
				int y = curr[1];
				int run = curr[2];

				for (int d = 0; d < 4; d++) {
					int nx = x + di[d];
					int ny = y + dj[d];
					if (check(nx, ny) && !visited[nx][ny] && arr[nx][ny] == '.') {
						visited[nx][ny] = true;
						jeehoon.add(new int[] { nx, ny, run + 1 });
					}
				}

				if (x == R - 1 || x == 0 || y == C - 1 || y == 0) {
					return run + 1;
				}
			}

		}

		return -1;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
