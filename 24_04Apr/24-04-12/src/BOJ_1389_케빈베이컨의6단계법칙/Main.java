package BOJ_1389_케빈베이컨의6단계법칙;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();

			int y = sc.nextInt();

			arr[x][y] = arr[y][x] = 1;
		}

		int max = 0;

		int ans = 0;

		for (int i = 1; i <= N; i++) {

			int cnt = 0;

			for (int j = 1; j <= N; j++) {

				if (arr[i][j] == 1) {
					cnt++;
				}

			}

			System.out.println(i + " " + cnt);

			if (cnt > max) {
				max = cnt;
				ans = i;
			}
		}
//		System.out.println(ans);

	}
}
