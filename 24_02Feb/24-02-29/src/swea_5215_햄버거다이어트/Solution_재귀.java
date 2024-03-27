package swea_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution_재귀 {
	static int T, N, L, max;
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
			
			max = 0; 
			answer(0, 0, 0);
			System.out.println(max);

			// 여기까지 배열 완성
		}
	}

	// 재귀 구현 도전
	static void answer(int idx, int tasteSum, int calSum) {
		if (calSum > L)
			return;
		if (idx >= N) {
			if (max < tasteSum) {
				max = tasteSum;
				return;
			}
		}
		answer(idx + 1, tasteSum + taste[idx], calSum + calories[idx]);
		answer(idx + 1, tasteSum, calSum);
	}

}
