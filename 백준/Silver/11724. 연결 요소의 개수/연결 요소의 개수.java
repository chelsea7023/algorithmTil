import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int[][] arr;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			arr[x][y] = arr[y][x] = -1;
			
			if(list.contains(x) || list.contains(y)) {
				list.remove(Integer.valueOf(x));
				list.remove(Integer.valueOf(y));
			}
		}
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == -1) {
					cnt++;
					dfs(i, j, cnt);
				}
			}

		}
		if(M == 0) {
			System.out.println(N);
		}else {
			System.out.println(cnt + list.size());
		}

	}

	static void dfs(int x, int y, int num) {

		visited[x][y] = true;
		arr[x][y] = num;

		for (int i = 1; i <= N; i++) {
			if (arr[y][i] == -1 && !visited[y][i]) {
				dfs(y, i, num);
			}
		}
	}
}
