package SWEA_1149_RGB거리;

import java.util.Scanner;

public class Solution {

	static int[][] map;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		
		

	}
}
