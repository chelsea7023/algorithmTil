package BOJ_7562_나이트의이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] chess;
	static int T, N;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] di = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dj = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			q = new LinkedList<>();
			N = sc.nextInt();
			chess = new int[N][N];
			visited = new boolean[N][N];
			int r = sc.nextInt();
			int c = sc.nextInt();
			q.add(new int[] { r, c, 0 });
			int gR = sc.nextInt();
			int gC = sc.nextInt();
			chess[gR][gC] = 1;
			int result = bfs(chess, q, r, c, 1);
			System.out.println(result);
		}
	}

	static int bfs(int[][] arr, Queue<int[]> list, int x, int y, int goal) {
		visited[x][y] = true;
		int answer = 0;
		while (!q.isEmpty()) {
			var curr = q.poll();
			int now_x = curr[0];
			int now_y = curr[1];
			int now_t = curr[2];
			if (arr[now_x][now_y] == goal) {
				answer = now_t;
				break;
			}
			for (int i = 0; i < 8; i++) {
				int ni = now_x + di[i];
				int nj = now_y + dj[i];
				if (check(ni, nj) && !visited[ni][nj]) {
					visited[ni][nj] = true;
					q.add(new int[] { ni, nj, now_t + 1 });
				}
			}
		}
		return answer;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
