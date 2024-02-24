package swea_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int [][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					char ch = str.charAt(j);
					int num = ch - '0';
					arr[i][j] = num;
				}
			}
			int sum = 0;
			int spc = 0;
			
			for(int i = 0; i <= N/2; i++) {
				for(int j = N/2 - spc; j <= N/2 + spc; j++ ) {
					sum+=arr[i][j];
				}
				spc++;
			}
			int lft = 1; 
			int rgt = N-1;
			for(int i = N/2 + 1; i < N; i++) {
				for(int j = lft ; j < rgt; j++) {
					sum+=arr[i][j];
				}
				lft++;
				rgt--;
			}
			System.out.println("#" + tc + " " + sum);
			
			
		}
	}

}
