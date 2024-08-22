package swea_1961_숫자배열회전;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] num = new char[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					num[i][j] = sc.next().charAt(0);
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(num[N - 1 - j][i]);

				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(num[N - 1 - i][N - 1 - j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(num[j][N - 1 - i]);
				}System.out.println();

			}

		}
	}

}
