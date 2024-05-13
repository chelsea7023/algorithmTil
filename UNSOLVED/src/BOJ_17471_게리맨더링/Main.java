package BOJ_17471_게리맨더링;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();

			for (int j = 0; j < num; j++) {
				int num2 = sc.nextInt();
				map[i][num2] = map[num2][i] = 1;
			}
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	static void combination(int[] arr, boolean[] visited, int start, int dp, int r) {
		if (dp == r) {
			
		}
	}
}
