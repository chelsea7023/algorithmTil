import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] tomato;
	static int N, M;
	static Queue<int[]> q = new LinkedList<>();
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, -1, 0, 1 };
	static boolean flag = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}

		
		bfs();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j] > max) {
					max = tomato[i][j];
				}
				if(tomato[i][j] == 0) {
					flag = false;
				}
			}
		}
		if(!flag) {
			System.out.println(-1);
		}else {
			if(max == 1) {
				System.out.println(0);
			}else {
				System.out.println(max - 1);
			}
		}
		

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			var curr = q.poll();
			int nx = curr[0];
			int ny = curr[1];
			for (int d = 0; d < 4; d++) {
				int nextX = nx + di[d];
				int nextY = ny + dj[d];
				if (check(nextX, nextY) && tomato[nextX][nextY] == 0) {
					q.add(new int[] { nextX, nextY });
					tomato[nextX][nextY] = tomato[nx][ny] + 1;
				}
			}
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
