import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 색종이 수

		int[][] board = new int[1001][1001];
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + width; j++) {
				for (int k = y; k < y + height; k++) {
					board[k][j] = cnt;
				}
			}
			cnt++;
		}

		cnt = 1;
		int sum = 0;
		for (int l = 0; l < N; l++) {
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (board[i][j] == cnt) {
						sum++;
					}
				}
			}
			cnt++;
			System.out.println(sum);
			sum = 0;
		}
		
	}

}
