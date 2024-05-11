package BOJ_1238_파티;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static final int INF = 987654321;
	static int N;
	static int[][] map;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 노드의 수
		int M = sc.nextInt();
		// 간선 방향의 수 (단 방향)
		int X = sc.nextInt();
		// 파티가 열리는 목적지

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = INF;

				}
			}
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			map[x][y] = sc.nextInt();
		}
		
		

		for (int i = 1; i <= 4; i++) {
			dijkstra(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	
		for (int i = 1; i <= N; i++) {
			if(map[i][X] == INF) continue;
			if (map[i][X] + map[X][i] > ans) {
				ans = map[i][X] + map[X][i];
			}
		}

		System.out.println(ans);
	}

	static void dijkstra(int start) {

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		pq.add(new int[] { 0, start });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int goal = curr[1];
			if (visited[goal] == true) {
				continue;
			}

			visited[goal] = true;
			for (int i = 1; i < N + 1; i++) {
				if (dist[i] > dist[goal] + map[goal][i]) {
					dist[i] = dist[goal] + map[goal][i];
					pq.add(new int[] { dist[i], i });
				}
			}

		}
//		System.out.println(Arrays.toString(dist));
		map[start] = Arrays.copyOf(dist, N + 1);

	}

}
