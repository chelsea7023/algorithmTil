package swea_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution_비트마스킹 {
	static int T, N, L;
	static int[] calories;
	static int[] taste;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 재료수
			L = sc.nextInt(); // 칼로리 리밋
			calories = new int[N];
			taste = new int[N];
			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			int max = 0;
			for(int i = 0; i < (1<<N); i++) {
				// 부분집합의 경우의 수
				int calSum = 0;
				int tasteSum = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) > 0) {
						calSum += calories[j];
						tasteSum += taste[j];
						if(calSum <= L) {
							max = Math.max(max, tasteSum);
						}
					}
				}
				
			}
			System.out.println(max);
		}

	}

}
