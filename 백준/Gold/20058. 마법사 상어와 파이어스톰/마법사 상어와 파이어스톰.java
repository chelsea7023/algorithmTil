import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int num;
	static int[][] map;
	static int[][] copy;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 크기
		num = (int) Math.pow(2, N);

		map = new int[num][num];
		copy = new int[num][num];

		int Q = sc.nextInt();
		// 단계 횟수
		int[] levels = new int[Q];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < num; i++) {
			copy[i] = Arrays.copyOf(map[i], num);
		}

		for (int i = 0; i < Q; i++) {
			int n = sc.nextInt();
			int number = (int) Math.pow(2, n);
			levels[i] = number;
		}

		for (int i = 0; i < levels.length; i++) {
			turn(levels[i]);
			for (int j = 0; j < num; j++) {
				map[j] = Arrays.copyOf(copy[j], num);
			}
			melt();
		}
		visited = new boolean[num][num];
//
//		for (int i = 0; i < num; i++) {
//			for (int j = 0; j < num; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		int sum = 0;
		int cnt = Integer.MIN_VALUE;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					int x = bfs(i, j);
					if (x > cnt) {
						cnt = x;
					}
				}
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		if (cnt == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(cnt);

		}

	}

	static void turn(int x) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int rowI = i / x;
				int rowJ = j / x;
				int modI = i % x;
				int modJ = j % x;
				copy[i][j] = map[rowI * x + (x - 1) - modJ][rowJ * x + modI];
			}
		}
	}

	static void melt() {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if (check_2(ni, nj)) {
						cnt++;
					}
				}

				if (cnt >= 3) {
					continue;
				} else {
					if (map[i][j] >= 1) {
						map[i][j]--;
					}
				}

			}
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < num && y >= 0 && y < num && map[x][y] > 0;
	}

	static boolean check_2(int x, int y) {
		return x >= 0 && x < num && y >= 0 && y < num && copy[x][y] > 0;
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			var curr = q.poll();
			int now_x = curr[0];
			int now_y = curr[1];
			cnt++;
			for (int d = 0; d < 4; d++) {
				int nx = now_x + di[d];
				int ny = now_y + dj[d];
				if (check(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
		return cnt;
	}

}
