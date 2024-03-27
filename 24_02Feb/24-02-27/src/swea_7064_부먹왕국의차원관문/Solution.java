package swea_7064_부먹왕국의차원관문;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] city = new int[N];
			for(int i = 0; i < N; i++) {
				city[i] = sc.nextInt();
			}
			int distance = 0; 
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(city[i] == 0) {
					distance++;
					if(distance >= D) {
						cnt ++;
						distance = 0;
					}
				}
				if(city[i] == 1) {
					distance = 0;
				}
			}
			System.out.println("#" + tc + " " +cnt);
		}

	}

}
