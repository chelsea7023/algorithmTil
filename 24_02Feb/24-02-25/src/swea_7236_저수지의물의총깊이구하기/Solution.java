package swea_7236_저수지의물의총깊이구하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] water = new char[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					water[i][j] = sc.next().charAt(0);
				}
			}
			int max = 0; 
			int cnt = 0;
			int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < N - 1; j++) {
					cnt = 0;
					if(water[i][j] == 'W') {
						for(int k = 0; k < 8; k++) {
							if(water[i +di[k]][j + dj[k]] == 'W') {
								cnt++;
							}
						}
						if(max < cnt) {
							max = cnt;
						}
					}
				}
				
				
			}
			if(max == 0) {
				System.out.println("#" + tc + " " + 1);
			}else {
				System.out.println("#" + tc + " " + max);
			}
		}

	}

}
