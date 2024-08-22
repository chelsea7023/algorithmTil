package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int money = sc.nextInt();

			int[] arr = new int[8];
			int[] dp = new int[8];
			arr[0] = 50000;
			arr[1] = 10000;

			for (int i = 2; i < arr.length; i++) {
				if (i % 2 == 0) {
					arr[i] = arr[i - 2] / 10;
				} else {
					arr[i] = arr[i - 2] / 10;
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				int cnt = 0;
				if(money >= arr[i]) {
					while(money >= arr[i]) {
						money -= arr[i];
						cnt++;
					}
				}
				dp[i] = cnt;
				if(money == 0) {
					break;
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i < dp.length; i++) {
				System.out.print(dp[i] + " ");
			}
			System.out.println();

		}

	}

}
