package swea_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int cnt = 1;
			int d = 0;
			
			int[]di = {0, 1, 0, -1};
			int[]dj = {1, 0, -1, 0};
			
			
			int r = 0; 
			int c = 0;
			
			map[0][0] = cnt++;
			
			while(cnt <= N*N) {
				
				int nr = r + di[d];
				int nc = c + dj[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
					d++;
					d %= 4;
				}
				r += di[d];
				c += dj[d];
				map[r][c] = cnt++;
				
			}
			
			
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}
		}

	}

}
