package BOJ_1987_알파벳;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M, ans;
	static char[][] map;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		List<Character> c = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		c.add(map[0][0]);
		boolean flag = true;
		dfs(c, visited, flag, 0, 0);

		System.out.println(ans);

	}

	static void dfs(List<Character> list, boolean[][] visited, boolean flag, int x, int y) {

		flag = false;

		for (int d = 0; d < 4; d++) {
			int nx = x + di[d];
			int ny = y + dj[d];
			if (check(nx, ny) && !list.contains(map[nx][ny]) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				list.add(map[nx][ny]);
				flag = true;
				dfs(list, visited, flag, nx, ny);
				list.remove(Character.valueOf(map[nx][ny]));
				visited[nx][ny] = false;
			}
		}

		if (!flag) {
			if (ans < list.size()) {
				ans = list.size();
			}
			return;
		}

	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
