package BOJ_15686_치킨배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, ans;
	static int[][] arr;
	static Queue<List<int[]>> newChicken = new LinkedList<>();
	static List<int[]> closed = new ArrayList<>();
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][N];
		int[][] copy = new int[N][N];

		List<int[]> chicken = new ArrayList<>();

		// 치킨집의 좌표를 담을 리스트 선언

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 2) {
					chicken.add(new int[] { i, j });
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			copy[i] = Arrays.copyOf(arr[i], N);
		}

		boolean[] visited = new boolean[chicken.size()];

		comb(chicken, visited, 0, 0, M);

		visited2 = new boolean[N][N];

		int min = Integer.MAX_VALUE;

		while (!newChicken.isEmpty()) {

			var curr = newChicken.poll();
			int num = curr.size();

			for (int i = 0; i < num; i++) {
				var n_chicken = curr.get(i);

				arr[n_chicken[0]][n_chicken[1]] = 2;

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						q.add(new int[] { i, j, 0 });
					}
				}
			}
			ans = 0;

			bfs();

			if (ans < min) {
				min = ans;
			}

			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.copyOf(copy[i], N);
			}

		}

	}

	static void comb(List<int[]> list, boolean[] visited, int start, int dp, int r) {
		if (dp == r) {
			for (int i = 0; i < list.size(); i++) {
				if (visited[i]) {
					closed.add(list.get(i));
				}
			}
			for (int[] x : closed) {
				System.out.println(Arrays.toString(x));
			}
			newChicken.add(closed);
			return;
		}

		for (int i = start; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(list, visited, i + 1, dp + 1, r);
				visited[i] = false;
			}
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			var curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int count = curr[2];

			if (arr[x][y] == 2) {
				ans += count;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if (check(nx, ny) && !visited2[nx][ny]) {
					q.add(new int[] { nx, ny, count + 1 });
					visited2[nx][ny] = true;
				}
			}
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
