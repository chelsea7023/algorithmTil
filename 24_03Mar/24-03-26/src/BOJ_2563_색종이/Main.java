package BOJ_2563_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][]white = new int[100][100];
		// 기본이 되는 흰 도화지 크기 100으로 생성
		
		int N = sc.nextInt();
		// 검은색 정사각형 색종이의 수
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt(); // 좌표가 반대로 되어 있다는걸 염두해두고 받기 
			int y = sc.nextInt();
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					white[y + j][x + k] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(white[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
