package swea_1216;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] pd = new int[100][100];
			for(int i = 0; i < 100; i++) {
				String line = sc.next();
				for(int j = 0; j < 100; j++) {
					pd[i][j] = line.charAt(j);
				}
			}// 배열입력까지 완성
			
		}

	}
	static boolean palindrome()

}
