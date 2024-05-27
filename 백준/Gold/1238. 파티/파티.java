import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	static int N;
	static int[][] map;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

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
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= N; i++) {
			if (map[i][X] == INF || map[X][i] == INF)
				continue;
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
