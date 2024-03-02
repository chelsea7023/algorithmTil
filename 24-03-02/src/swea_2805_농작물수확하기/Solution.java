package swea_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0; 
			
			int left = N/2;
			int right = N/2; 
			for(int i = 0; i <= N/2; i++) {
				for(int j = left; j <= right; j++) {
					sum += farm[i][j];
				}
				left --;
				right ++;
			}
			left += 2;
			right -= 2;
			for(int i = N/2 + 1; i < N; i++) {
				for(int j = left; j <= right; j++) {
					sum += farm[i][j];
				}
				left ++;
				right--;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}
