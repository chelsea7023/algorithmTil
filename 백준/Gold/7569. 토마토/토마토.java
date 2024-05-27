import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][][] tomato;
	static int N, M, H;
	static boolean flag = true;
	static Queue<int[]> q = new LinkedList<>();
	static int[] di = { -1, 0, 1, 0, 0, 0 };
	static int[] dj = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		tomato = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = sc.nextInt();
					if (tomato[i][j][k] == 1) {
						q.add(new int[] { i, j, k });
					}
				}
			}
		}
		bfs();

		int max = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[i][j][k] == 0)
						flag = false;
					if (tomato[i][j][k] > max)
						max = tomato[i][j][k];

				}
			}
		}
		if (!flag) {
			System.out.println(-1);
		} else {
			if (max == 1) {
				System.out.println(0);
			} else {
				System.out.println(max - 1);
			}
		}

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			var curr = q.poll();
			int now_h = curr[0];
			int now_x = curr[1];
			int now_y = curr[2];
			for (int i = 0; i < 6; i++) {
				int nh = now_h + dh[i];
				int nx = now_x + di[i];
				int ny = now_y + dj[i];
				if (check(nh, nx, ny) && tomato[nh][nx][ny] == 0) {
					q.add(new int[] { nh, nx, ny });
					tomato[nh][nx][ny] = tomato[now_h][now_x][now_y] + 1;
				}
			}
		}
	}

	static boolean check(int h, int x, int y) {
		return h >= 0 && x >= 0 && y >= 0 && h < H && x < N && y < M;
	}

}
