package ssafy_test02;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			int[] arr3 = new int[K];
			
			for(int i = 0; i < N; i++) {
				arr1[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				arr2[i] = sc.nextInt();
			}
			for(int i = 0; i < K; i++) {
				arr3[i] = sc.nextInt();
			}
			// 여기까지 배열 완성
			int cnt = 0;
			boolean success = false;
			while(!success) {
				for(int i = 1; i < 1000; i++) {
					int n = i % N;
					int m = i % M;
					int k = i % K;
					if(arr1[n] == arr2[m] && arr2[m] == arr3[k] && arr3[k] == arr1[n]) {
						cnt = i;
						success = true;
						break;
						
					}
				}break;
			}
			if(success) {
				System.out.println(cnt);
			}else {
				System.out.println(-1);

			}
		}

	}

}
