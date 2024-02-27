package swea_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution2 {
	// 이번엔 재귀로 풀어보자
	static int N;
	static int L;
	static int[] taste;
	static int[] calorie;
	static boolean[] put;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			max = 0;
			
			N = sc.nextInt(); // 재료 갯수, 
			L = sc.nextInt(); // 칼로리 한계
			
			taste = new int[N];
			calorie = new int[N];
			put = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			powerTaste(0);
			System.out.println(max);
			
		}

	}
	
	static void powerTaste(int idx) {
		// base case
		if(idx >= N) {
			int cal = 0;
			int full = 0;
			for(int i = 0; i < N; i ++) {
				if(put[i]) {
					cal += calorie[i];
					full += taste[i];
				}
				
			}
			if(cal <= L) 
				max = Math.max(max, full);
				return;
						
		}
		
		//recursive case
		put[idx] = true;
		powerTaste(idx + 1);
		

		put[idx] = false;
		powerTaste(idx + 1);
	}	
		

}
