import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int cnt = Integer.MAX_VALUE;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[1000001];
		visited[N] = true;
		q.add(N);
		q.add(0);

		bfs();

		System.out.println(cnt);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int now = q.poll();
			int count = q.poll();
			if (now == K) {
				if (cnt > count) {
					cnt = count;
					return;
				}
			} else {
				for (int i = 0; i < 3; i++) {
					int num = now;
					int ans = count;
					if (i == 0) {
						int now_a = num - 1;
						if (check(now_a) && !visited[now_a]) {
							q.add(now_a);
							q.add(ans + 1);
							visited[now_a] = true;
						}
					} else if (i == 1) {
						int now_b = num + 1;
						if (check(now_b) && !visited[now_b]) {
							q.add(now_b);
							q.add(ans + 1);
							visited[now_b] = true;
						}
					} else {
						int now_c = num * 2;
						if (check(now_c) && !visited[now_c]) {
							q.add(now_c);
							q.add(ans + 1);
							visited[now_c] = true;
						}
					}
				}
			}
		}

	}

	static boolean check(int x) {
		return x >= 0 && x <= 100000;
	}
}
