package test01_ssafy_monthly;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[][] game = new int[6][7];
			
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					game[i][j] = sc.nextInt();
				}
			}
			// 배열 입력까지 완성
			/*
			 * 푸는 방법은 아래부터 배열을 순회하는 것이 유리하다고 판단
			 * 1을 발견하면 내 위치를 저장하고 그 위치에서 5방 탐색 실시
			 * 5방 탐색 중에 1을 발견하면 쭉 그 라인을 따라 올라가기
			 * 만약에 탐색을 시작한 자리를 포함한 1의 개수가 3이고 다음이 0일때 0위치의 좌표 j출력
			 */
			int [] di = {0, -1, -1, -1, 0};
			int [] dj = {-1, -1, 0, 1, 1};
			int max = 0;
			
			
			for(int i = 5; i >= 0; i--) {
				for(int j = 6; j >= 0; j--) {
					if(game[i][j] == 1) { 
						for(int k = 0; k < 5; k++) {
							
							int cnt = 1; 
							int ni = i + di[k];
							int nj = j + dj[k];
							while(ni >= 0 && ni < 6 && nj >= 0 && nj < 7 && game[ni][nj] == 1) {
								ni += di[k];
								nj += dj[k];
								cnt++;
							}
							if(cnt == 3 && game[ni][nj] == 0) {
								int a = nj;
								if(max < a) {
									max = a;
								}
							}
						}
					}
				}
			}
			if(max > 0) {
				System.out.println("#" + tc + " " + max);
			}else {
				System.out.println("#" + tc + " " + -1);
			}
		}
	}
}
