import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int N, cnt;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		int ans = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					cnt = 1;
					list.add(bfs(i, j));
					ans++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(ans);
		for (int x : list) {
			System.out.println(x);
		}

	}

	static int bfs(int r, int c) {
		arr[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int ni = r + di[i];
			int nj = c + dj[i];
			if (check(ni, nj) && arr[ni][nj] == 1) {
				arr[ni][nj] = 0;
				cnt++;
				bfs(ni, nj);
			}
		}
		return cnt;
	}

	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}
