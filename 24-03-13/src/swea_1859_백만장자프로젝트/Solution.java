package swea_1859_백만장자프로젝트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 거래 가능 횟수
			int[]arr = new int[N];
			long sum = 0; 
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int[] arr2 = new int[N];
			for(int i = 0; i < N; i++) {
				arr2[i] = arr[i];
			}
			for(int i = N - 1; i > 0; i--) {
				if(arr[i - 1] < arr[i]) {
					arr[i - 1] = arr[i];
				}
			}
			for(int i = 0; i < N; i++) {
				sum += arr[i] - arr2[i];
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
