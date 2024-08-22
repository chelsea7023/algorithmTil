package swea_2817_부분수열의합;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[]arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			//여기까지 배열 완성
			int cnt = 0; 
			for(int i = 0; i < (1 << N); i++) {
				int plus = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) > 0) {
						plus += arr[j];
					}
				}
				if(K == plus) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}

}
