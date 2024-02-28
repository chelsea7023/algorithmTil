package swea_4698_테네스의특별한소수;

import java.util.Scanner;

public class Solution {
	/*
	 * 에라토스테네의 체 문제...
	 * 소수 구하기가 생각보다 어려워서 당황
	 * 자기보다 작은 정수들로 나눠주면 되긴하는데
	 * 메모리 사용량이 엄청나기 때문에 검색해서 다시 구함.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt(); // 테네스가 좋아하는 숫자, 포함되어야만 함
			int A = sc.nextInt(); // A이상
			int B = sc.nextInt(); // B이하

			int cnt = 0; // 갯수 세기
			int a = 0;
			boolean prime = true;

			for (int i = A; i <= B; i++) {
					a = i;
					prime = true;
				if (a == D) {
					cnt++;
				} else {
					for (int j = 2; j < Math.sqrt(a); j++) {
						if (a % j == 0) {
							prime = false;
						}
					}
					
					if (prime) {
						while (a > 0) {
							if (a % 10 == D) {
								cnt++;
								break;
							} else {
								a /= 10;
							}
						}
					}

				}
			}
			System.out.println(cnt);

		}
	}

}
