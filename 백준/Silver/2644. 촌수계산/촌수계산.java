import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static List<ArrayList<Integer>> list;
	static int n, v, cnt, start, end, ans;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 사람 수
		int x = sc.nextInt(); // 시작
		int y = sc.nextInt(); // 끝
		if (x >= y) {
			start = y;
			end = x;
		} else {
			start = x;
			end = y;
		}
		v = sc.nextInt(); // 간선 수

		visited = new boolean[n + 1];

		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < v; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}
		visited[start] = true;
		dfs(start, 0);
		if (!flag)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void dfs(int x, int count) {
		for (Integer nx : list.get(x)) {
			if (!visited[nx]) {
				if (nx == end) {
					flag = true;
					ans = count + 1;
					return;
				}
				visited[nx] = true;
				dfs(nx, count + 1);
				visited[nx] = false;
			}
		}
	}

}
