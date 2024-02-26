package ssafy_test01;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			// 입력받을 배열부터 만들자
			int[][] arr = new int[6][7];
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//여기까지 입력받고 배열 완성
			/*
			 * 문제 풀이 방법은 위에서 부터 떨어진다고 생각하고 만약에 선택한 배열의 값이 0이면 아래에 값이 있는지 없는지 확인하고
			 * 아래로 7방 탐색 실시 
			 */
			
			//7방 탐색용 배열 만들자
			int[] di = {0, -1, -1, -1, 0};
			int[] dj = {-1, -1, 0 , 1, 1};
			int cnt = 0;
			boolean success = false;
			int max = Integer.MIN_VALUE;
			for(int i = 5; i >= 0; i--) {
				for(int j = 6; j >= 0; j--) {
					// 오른쪽 끝의 경우 
					if(arr[i][j] == 1) {
						
					}
				}
			}
			
			
			
			
		}

	}

}
