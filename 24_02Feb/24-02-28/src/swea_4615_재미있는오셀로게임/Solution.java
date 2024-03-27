package swea_4615_재미있는오셀로게임;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 한변의 길이 설정
			int[][] board = new int[N][N];
			int tr = sc.nextInt(); // 돌을 놓는 횟수

			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;

			// 8방 탐색용 배열 추가 11시부터 검사
			int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };

			// 기본적으로 주어지는 돌들 이후에 돌을 놓으면서 과정 변화 부여
			for (int i = 0; i < tr; i++) {
				int a = sc.nextInt() - 1; // 놓는 돌의 x좌표
				int b = sc.nextInt() - 1; // 놓는 돌의 y좌표
				int c = sc.nextInt(); // 돌의 색
				board[a][b] = c;

				// 흑돌의 경우
				if (c == 1) {
					for (int j = 0; j < 8; j++) {
						int ni = a + di[j];
						int nj = b + dj[j];

						boolean black = false;
						
						while (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 2) {

							ni += di[j];
							nj += dj[j];
							
							if (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 1) {
								black = true;
								
							}


						}
						
						ni = a + di[j];
						nj = b + dj[j];
						
						if (black) {
							while (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 2) {
								
								if (board[ni][nj] == 2) {
									board[ni][nj] = 1;
									
								}
								
								ni += di[j];
								nj += dj[j];

							}
						}

					}
				}
				// 백돌의 경우
				if (c == 2) {
					for (int j = 0; j < 8; j++) {
						int ni = a + di[j];
						int nj = b + dj[j];
						boolean white = false;

						while (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 1) {
							
							ni += di[j];
							nj += dj[j];

							if (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 2) {
								white = true;
							}
						}
						
						ni = a + di[j];
						nj = b + dj[j];
						
						if (white) {
							while (ni >= 0 && ni < N && nj >= 0 && nj < N && board[ni][nj] == 1) {
								if (board[ni][nj] == 1) {
									board[ni][nj] = 2;
								}
								ni += di[j];
								nj += dj[j];

							}

						}
					}
				}
			}
			int cntw = 0;
			int cntb = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 2) {
						cntw++;
					} else if (board[i][j] == 1) {
						cntb++;
					}
				}
			}
			System.out.println("#" + tc + " " + cntb + " " + cntw);

		}
	}
}
