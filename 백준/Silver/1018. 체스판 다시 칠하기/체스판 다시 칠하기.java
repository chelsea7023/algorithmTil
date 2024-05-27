import java.util.Scanner;

public class Main {

	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		char[][] map = new char[M][N];

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int ans = Math.min(black(map), white(map));
		System.out.println(ans);
		
	}

	static int black(char[][] arr) {
		int min = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < M - 7; i++) {
			for (int j = 0; j < N - 7; j++) {
				int cnt = 0;
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if((i + r) % 2 == 0) {
							if((j + c) % 2 == 0) {
								if(arr[i + r][j + c] == 'B') {
									continue;
								}else {
									cnt++;
								}
							}else {
								if(arr[i + r][j + c] == 'W') {
									continue;
								}else {
									cnt++;
								}
							}
						}else {
							if((j + c) % 2 == 0) {
								if(arr[i + r][j + c] == 'W') {
									continue;
								}else {
									cnt++;
								}
							}else {
								if(arr[i + r][j + c] == 'B') {
									continue;
								}else {
									cnt++;
								}
							}
						}
					}
				}
				if(cnt < min) {
					min = cnt;
				}
				
			}
		}
		return min;
	}
	
	static int white(char[][] arr) {
		int min = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < M - 7; i++) {
			for (int j = 0; j < N - 7; j++) {
				int cnt = 0;
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if((i + r) % 2 == 0) {
							if((j + c) % 2 == 0) {
								if(arr[i + r][j + c] == 'W') {
									continue;
								}else {
									cnt++;
								}
							}else {
								if(arr[i + r][j + c] == 'B') {
									continue;
								}else {
									cnt++;
								}
							}
						}else {
							if((j + c) % 2 == 0) {
								if(arr[i + r][j + c] == 'B') {
									continue;
								}else {
									cnt++;
								}
							}else {
								if(arr[i + r][j + c] == 'W') {
									continue;
								}else {
									cnt++;
								}
							}
						}
					}
				}
				if(cnt < min) {
					min = cnt;
				}
				
			}
		}
		return min;
	}
}
