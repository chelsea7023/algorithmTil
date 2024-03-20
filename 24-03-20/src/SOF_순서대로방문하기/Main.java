package SOF_순서대로방문하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt, t;
	static int[][] arr;
	static boolean[][] check;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static void dfs(int x, int y, int t) {
		if (t == m) {
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (arr[nx][ny] == t + 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					dfs(nx, ny, t + 1);
					check[nx][ny] = false;
				} else if (arr[nx][ny] == 0 && !check[nx][ny]) {
					check[nx][ny] = true;
					dfs(nx, ny, t);
					check[nx][ny] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		check = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}

		int count = 1;
		int startx = 0;
		int starty = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = count;
			if (arr[x][y] == 1) {
				startx = x;
				starty = y;
			}
			count++;
		}

		check[startx][starty] = true;
		dfs(startx, starty, 1);
		System.out.println(cnt);

	}

}
