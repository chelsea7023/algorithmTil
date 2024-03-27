package swea_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		TC: for(int tc = 1; tc < T; tc++) {
		int [][] arr = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 여기까지 배열 완성 시켜놓고
		// 가로 세로 작은 사각형 순으로 검증해야함
		// 우선 가로 부터
		boolean sudoku = true;
		
		for(int i = 0; i < 9; i++) {
			int [] answer = new int[10];
			for(int j = 0; j < 9; j++) {
				int num = arr[i][j];
				if(answer[num]>=1) {
					System.out.println("#" + tc + " " + 0);
					continue TC;
				}
				answer[num]++;
			}
		}
		for(int i = 0; i < 9; i++) {
			int [] answer = new int[10];
			for(int j = 0; j < 9; j++) {
				int num = arr[i][j];
				if(answer[num]>=1) {
					System.out.println("#" + tc + " " + 0);
					continue TC;
				}
				answer[num]++;
			}
		}
		for(int si = 0; si < 9; si+=3) {
			for(int sj = 0; sj < 9; sj+=3) {
				int[] answer = new int[10];
				for(int i = si; i < si+3; i++) {
					for(int j = sj; j < sj + 3; j++) {
						int num = arr[i][j];
						if(answer[num] >= 1) {
							System.out.println("#" + tc + " " + 0);
							continue TC;
						}
						answer[num]++;
					}
				}
			}
		}
		System.out.println("#" + tc + " " +  1);
	}
	}

}
