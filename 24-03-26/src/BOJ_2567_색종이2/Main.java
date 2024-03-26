package BOJ_2567_색종이2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] white = new int[100][100];

		int N = sc.nextInt();

		for(int i = 0; i < N; i++) {
			
			int y = sc.nextInt(); //col
			int x = sc.nextInt(); //row
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					white[y + j][x + k] += 2;
				}
			}
			
			for(int j = 0; j < 10; j++) {
				white[y + j][x] -= 1;
				white[y][x + j] -= 1;
				white[10 + y + j][x] -= 1;
				white[y][x + 10 + j] -= 1;
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
