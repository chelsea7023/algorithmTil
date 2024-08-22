package swea_1220_magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
//			int[] magnet = new int[N];
			int cnt = 0; 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				S:for(int j = 0; j < N; j++) {
					if(arr[j][i] == 1) {
						for(int k = j + 1; k < N; k++) {
							if(arr[k][i] == 2) {
								cnt++;
								continue S;
							}else if(arr[k][i] == 1) {
								continue S;
							}
						}
					}
				}
//				System.out.println(cnt);
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
}
