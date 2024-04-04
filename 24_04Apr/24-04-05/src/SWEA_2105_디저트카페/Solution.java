package SWEA_2105_디저트카페;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N, nx, ny;
	static int[]di = {1, 1, -1, -1};
	static int[]dj = {1, -1, -1, 1};
	static int[][] map;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println(dfs(0, 1));
			
			
			 
		}
	}
	static int dfs(int x, int y) {
		int cnt = 0;
		
		if(x == nx && y == ny) {
			return cnt;
		}
		
		List<Integer> list = new ArrayList<>();
		list.add
		
		
		
	}
	static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
