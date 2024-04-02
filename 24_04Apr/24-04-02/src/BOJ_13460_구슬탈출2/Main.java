package BOJ_13460_구슬탈출2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, ans;
	static char[][] map;
	static Queue<int[]> red = new LinkedList<>();
	static Queue<int[]> blue = new LinkedList<>();
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static boolean flag = false;
	static boolean[][]visited_red;
	static boolean[][]visited_blue;
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		
		visited_red = new boolean[N][M];
		visited_blue = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					red.add(new int[] { i, j, 0 });
				} else if (map[i][j] == 'B') {
					blue.add(new int[] { i, j });
				}

			}
		}
		
		BFS();
		


		if(flag) {
			if(ans > 10) {
				System.out.println(-1);
			}else {
				System.out.println(ans);
			}
		}else {
			System.out.println(-1);
		}

		/*
		 * 여기까지 지도 완성인데.. 흠.. 빨강 구슬과 파랑 구슬을 같은 방향대로 움직여야 한다. 
		 * 두개의 큐를 운용하며 BFS방식으로 풀기로 접근
		 * red의 경우 횟수까지 카운트해야하기 때문에 3 배열로 
		 * blue의 경우 위치만 확인 하면 되므로 2 배열로 만들고 운영 
		 * 하나의. 즉, 빈공간을 찾으면 쭉 이동하고 count는 1만 올리는 방식으로 진행
		 */

	}

	static void BFS() {

		while (!red.isEmpty()) {
			var red_curr = red.poll();
			int x_red = red_curr[0];
			int y_red = red_curr[1];
			int count = red_curr[2];

			var blue_curr = blue.poll();
			int x_blue = blue_curr[0];
			int y_blue = blue_curr[1];

			for (int d = 0; d < 4; d++) {
				int nx_r = x_red + di[d];
				int ny_r = y_red + dj[d];

				int nx_b = x_blue + di[d];
				int ny_b = y_blue + dj[d];

				while (check(nx_r, ny_r) && !visited_red[nx_r][ny_r]) {
					nx_r += di[d];
					ny_r += dj[d];
					visited_red[nx_r][ny_r] = true;
					
					if (map[x_red][y_red] == 'O') {
						flag = true;
						ans = count + 1;
						return;
					}
					
					
				}
				while (check(nx_b, ny_b) && !visited_blue[nx_b][ny_b]) {
					nx_b += di[d];
					ny_b += dj[d];
					visited_blue[nx_b][ny_b] = true;
					
					if (map[x_blue][y_blue] == 'O') {
						return;
					}
					
				}
				if (check(nx_r, ny_r)) {
					red.add(new int[] { nx_r, ny_r, count + 1 });
				}
				if (check(nx_b, ny_b)) {
					blue.add(new int[] { nx_b, ny_b });
				}
			}
		}

	}

	static boolean check(int x, int y) {
		return map[x][y] == '.' || map[x][y] == 'O';
	}
}
