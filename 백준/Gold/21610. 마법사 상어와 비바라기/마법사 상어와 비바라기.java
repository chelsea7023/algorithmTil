import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static Queue<int[]> cloud;
	// 구름 이동용
	static int[] ci = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] cj = { -1, -1, 0, 1, 1, 1, 0, -1 };
	// 대각선 확인용
	static int[] di = { -1, -1, 1, 1 };
	static int[] dj = { -1, 1, 1, -1 };
	// 구름이었던 부분은 다시 바로 구름 x 하기 위한 방문 배열
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		cloud = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// x 는 방향 y 이동하는 횟수
		List<int[]> move = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			move.add(new int[] { x, y });
		}

		/*
		 * 첫번째 구름은 정해주니까 그대로 q에 담아준다.
		 */

		cloud.add(new int[] { N - 1, 0 });
		cloud.add(new int[] { N - 1, 1 });
		cloud.add(new int[] { N - 2, 0 });
		cloud.add(new int[] { N - 2, 1 });

		for (int i = 0; i < move.size(); i++) {
			visited = new boolean[N][N];

			bfs_move(move.get(i)[0], move.get(i)[1]);

			copy_water();
//			if (i == 3) {
//				break;
//			}

			make_cloud();
		}
//		visited = new boolean[N][N];
//		bfs_move(move.get(0)[0], move.get(0)[1]);
//		copy_water();
//		make_cloud();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
				sum += map[i][j];
			}
//			System.out.println();
		}

		System.out.println(sum);

	}

	static void bfs_move(int x, int y) {
		// X 는 방향 Y 는 가는 거리
		// 첫번째 구름의 이동이 필요하다.
		int num = cloud.size();
		while (num != 0) {
			int[] curr = cloud.poll();
			int now_x = curr[0];
			int now_y = curr[1];

			int nx = now_x + (ci[x - 1] * y);

			if (nx < 0) {
				while (nx < 0) {
					nx += (N);
				}
			} else {
				nx %= (N);
			}

			int ny = now_y + (cj[x - 1] * y);

			if (ny < 0) {
				while (ny < 0) {
					ny += (N);
				}
			} else {
				ny %= (N);
			}
			visited[nx][ny] = true;
			cloud.add(new int[] { nx, ny });
			num--;

		}

	}

	static void copy_water() {

		int num = cloud.size();

		while (num > 0) {
			int[] place = cloud.poll();
			int now_x = place[0];
			int now_y = place[1];
			map[now_x][now_y]++;
			cloud.add(place);
			num--;
		}

		while (!cloud.isEmpty()) {

			int[] place = cloud.poll();

			int now_x = place[0];
			int now_y = place[1];

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = now_x + di[i];
				int ny = now_y + dj[i];
				if (check(nx, ny) && map[nx][ny] > 0) {
					cnt++;
				}
			}

			map[now_x][now_y] += cnt;
		}
	}

	static void make_cloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && !visited[i][j]) {
					cloud.add(new int[] { i, j });
					map[i][j] -= 2;
				}
			}
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
