package swea_2001_파리퇴치;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 배열완성 그리고 최대값을 비교하면 만들어보자~
			int sum = 0; 
			int max = 0; 
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					sum = 0;
					for(int k = 0; k < M; k++) {
						for(int L = 0; L < M; L++) {
							sum += map[i + k ][j + L];
							if(max < sum) {
								max = sum;
							}
						}
					}
				}
			}System.out.println("#" + tc + " " + max);
		}
	}

}
