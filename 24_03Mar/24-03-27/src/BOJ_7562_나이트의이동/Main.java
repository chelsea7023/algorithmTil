package BOJ_7562_나이트의이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] chess;
	static int T, N;
	static boolean [][] visited;
	static Queue<Integer> q = new LinkedList<>();	
	static int[]di = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[]dj = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {

			N = sc.nextInt();
			chess = new int[N][N];
			visited = new boolean[N][N];
			int r = sc.nextInt();
			int c = sc.nextInt();
			q.add(r);
			q.add(c);
			q.add(0);
			int gR = sc.nextInt();
			int gC = sc.nextInt();
			chess[gR][gC] = 1;
			int ans = bfs(chess, r, c, 1);
			System.out.println(ans);
			

		}
	}
	
	static int bfs(int[][]arr, int r, int c, int x) {
		visited[r][c] = true;
		int now_r = q.poll();
		int now_c = q.poll();
		int now_t = q.poll();
		for(int i = 0; i < 8; i++) {
			int ni = now_r + di[i];
			int nj = now_c + dj[i];
			if(check(ni, nj) && !visited[ni][nj]) {
				visited[ni][nj] = true;
				q.add(ni);
				q.add(nj);
				q.add(now_t + 1);
			}
		}
		return now_t;
	}
	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
