package BOJ_5427_불;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N;
	static char[][] map;
	static Queue<int[]> fire;
	static Queue<int[]> safe;
	static boolean[][] visited;
	static boolean flag = false;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();

			map = new char[N][M];

			fire = new LinkedList<>();
			safe = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*') {
						fire.add(new int[] { i, j, 0 });
					} else if (map[i][j] == '@') {
						safe.add(new int[] { i, j, 0 });
					}
				}
			}

		}
	}

	public static void bfs() {
		while (!safe.isEmpty()) {
			var curr = safe.poll();
			int x = curr[0];
			int y = curr[1];
			int run = curr[2];
			
			for(int i = 0; i < )
		}
	}
}
