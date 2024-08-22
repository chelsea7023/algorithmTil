package swea_1209_sum;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[][] sum = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					sum[i][j] = sc.nextInt();
				}
			}
			/*
			 * 여기까지 배열 완성 해주고 이제 합을 구해보자 
			 * 근데 행 우선, 열 우선, 대각선 우선 나눠서 추후에 다시 비교해주는 식으로 하자
			 */
			//행 최대 값부터
			int num = 0;
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) {
				int c = i; 
				num = 0;
				for(int j = 0; j < 100; j++) {
					num += sum[c][j];
					
				}
				if(max < num) {
					max = num;
				}
			}
			int a = max;
			max = 0; 
			num = 0; 
			//열 우선으로 
			for(int i = 0; i < 100; i++) {
				int c = i; 
				num = 0;
				for(int j = 0; j < 100; j++) {
					num += sum[j][c];
					
				}
				if(max < num) {
					max = num;
				}
			}
			int b = max;
			max = 0;
			num = 0; 
			//이제 대각선 좌 상향부
			for(int i = 0; i < 100; i++) {
				num += sum[i][i];
			}
			int c = num;
			num = 0; 
			
			//이제 대각선 우상향
			for(int i = 0; i < 100; i++) {
				num += sum[100 - (i+1)][i];
			}
			int d = num;
			
			max = Math.max(a, Math.max(b, Math.max(c, d)));
			System.out.println(max);
			
		}
		
	}

}
