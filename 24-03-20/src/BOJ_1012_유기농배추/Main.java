package BOJ_1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] check;
	static int[][] arr;
	static int M, N, K, cnt;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static void DFS(int a, int b) {
		check[a][b] = true;

		for (int i = 0; i < 4; i++) {
			int da = a + di[i];
			int db = b + dj[i];
			if (da >= 0 && da < M && db >= 0 && db < N) {
				if (!check[da][db] && arr[da][db] == 1) {
					DFS(da, db);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			arr = new int[M][N];
			check = new boolean[M][N];

			K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;

			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !check[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

}
