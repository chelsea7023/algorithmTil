package swea_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char [][] flag = new char[N][M];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < M; j++) {
					flag[i][j] = str.charAt(j);
				}
			}
			int cnt = 0; 
			

			for(int i = 0; i < M; i++) {
				if(flag[0][i] != 'W') {
					cnt++;
				}if(flag[N-1][i] != 'R') {
					cnt++;
				}
			}
			
			/*
			 * 둘째줄부터 파랑을 분기점으로 흰색이랑 레드를 정해야함
			 * 그래서 블루 라인을 정해주자
			 */
			int min = Integer.MAX_VALUE;
			for(int bs = 1; bs < N - 1; bs++) {
				for(int be = bs; be < N - 1; be++) {
					int cnt2 = 0; 
					for(int white = 1; white < bs; white++) {
						for(int j = 0; j < M; j++) {
							if(flag[white][j] != 'W') 
								cnt2++;
							
						}
					}
					for(int blue = bs; blue <=  be; blue++) {
						for(int j = 0; j < M; j++) {
							if(flag[blue][j] != 'B')
								cnt2++;
						}
					}
					for(int red = be + 1; red < N - 1; red++) {
						for(int j = 0; j < M; j++) {
							if(flag[red][j] != 'R')
								cnt2++;
						}
					}
					if(min > cnt2) {
						min = cnt2;
					}
				}
			}
			System.out.println("#" + tc + " " + (min+cnt));
		}

	}

}
