package BOJ_17144_미세먼지안녕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int R, C, T;
	static Queue<int[]> dust;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};

		int[][] map = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {
			dust = new LinkedList<>();
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] >= 4) {
						dust.add(new int[] {r, c});
					}
				}
			}
		}
		while(dust.isEmpty()) {
			var curr = dust.poll();
			int x = curr[0];
			int y = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + di[d];
				int ny = y + dj[d];
				
				if(check(nx, ny)) {
					
				}
			}
			
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}System.out.println();
		}

	}

	static boolean check(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

}
