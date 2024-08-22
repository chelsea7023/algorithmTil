package swea_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		TC: for (int tc = 1; tc <= T; tc++) {
			int[][] sdk = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdk[i][j] = sc.nextInt();
				}
			}
			// 확인용 배열

			int[] ok = new int[9];
			boolean success = true;
			// 행 우선 확인
			for (int i = 0; i < 9; i++) {
				int[] cnt = new int[10];
				for (int j = 0; j < 9; j++) {
					int num = sdk[i][j];
					if (cnt[num] >= 1) {
						System.out.println("#" + tc + " " + 0);
						continue TC;
					}
					cnt[num]++;
				}

			}
			// 열 우선 확인
			for (int i = 0; i < 9; i++) {
				int[] cnt = new int[10];
				for (int j = 0; j < 9; j++) {
					int num = sdk[j][i];
					if (cnt[num] >= 1) {
						System.out.println("#" + tc + " " + 0);
						continue TC;
					}
					cnt[num]++;
				}

			}
			for (int si = 0; si < 9; si += 3) {
				for (int sj = 0; sj < 9; sj += 3) {
					int[] cnt = new int[10];
					for (int i = si; i < si + 3; i++) {
						for (int j = sj; j < sj + 3; j++) {
							int num = sdk[i][j];
							if(cnt[num] >= 1) { 
								System.out.println("#" + tc + " " + 0);
								continue TC;
							}
							cnt[num]++;
						}

					}
				}
			}
			System.out.println("#" + tc + " " + 1);
		}
	}

}
