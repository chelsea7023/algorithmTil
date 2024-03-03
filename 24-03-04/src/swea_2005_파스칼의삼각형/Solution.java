package swea_2005_파스칼의삼각형;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] pascal = new int[N][N];
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j <= i; j++) {
					if(j == 0) {
						pascal[i][j] = 1;
					}else if(i == j) {
						pascal[i][j] = 1;
					}else {
						pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
					}
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					
						System.out.print(pascal[i][j] + " ");
					
				}System.out.println();
			}
		}

	}

}
