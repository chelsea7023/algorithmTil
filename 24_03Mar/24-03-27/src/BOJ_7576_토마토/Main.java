package BOJ_7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] arr;
	static int M, N, cnt;
	static boolean flag = true;
	static Queue<Integer> q = new LinkedList<>();
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // j 크기
		M = sc.nextInt(); // i 크기

		arr = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					q.add(i);
					q.add(j);
					q.add(0);
				}
			}
		}
		int ans = bfs();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					flag = false;
				}
			}
		}
		if (flag) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}

	}

	static int bfs() {
		int now_d = 0;
		while (!q.isEmpty()) {
			int now_r = q.poll();
			int now_c = q.poll();
			now_d = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = now_r + di[i];
				int nj = now_c + dj[i];
				if (check(ni, nj) && arr[ni][nj] == 0) {
					arr[ni][nj] = 1;
					q.add(ni);
					q.add(nj);
					q.add(now_d + 1);
				}

			}
		}
		return now_d;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

}
