import java.util.Scanner;

public class Main {

	static int N, M, startRow, startCol, direction;
	static int[][] map;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		startRow = sc.nextInt();
		startCol = sc.nextInt();
		direction = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		clean(startRow, startCol, direction);
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	static void clean(int x, int y, int d) {
		map[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			d = (d+3) % 4;
			int nx = x + di[d];
			int ny = y + dj[d];
			if (map[nx][ny] == 0 && check(nx, ny)) {
				clean(nx, ny, d);
				return;
			}
		}
		int dir = (d + 2) % 4;
		int bx = x + di[dir];
		int by = y + dj[dir];
		if(check(bx, by) && map[bx][by] != 1) {
			clean(bx, by, d);
		}

	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
