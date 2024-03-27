package swea_1493_수의새로운연산;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int p = sc.nextInt();
			int q = sc.nextInt();
			int n = 460;

			int[][] arr = new int[n][n];
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						int ni = i;
						int nj = j;
						while (nj >= 0 && ni < n) {
							arr[ni][nj] = cnt;
							ni++;
							nj--;
							cnt++;
						}
					}
				}
			}
			int num = 0, num2 = 0, num3 = 0, num4 = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == p) {
						num = i;
						num2 = j;
					} 
					if (arr[i][j] == q) {
						num3 = i;
						num4 = j;
					}
				}
			}
			System.out.println("#" + tc + " " + arr[num + num3 + 1][num2 + num4 + 1]);
		}

	}

}
