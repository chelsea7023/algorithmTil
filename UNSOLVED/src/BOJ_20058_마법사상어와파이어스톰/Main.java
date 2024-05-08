package BOJ_20058_마법사상어와파이어스톰;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int num;
	static int[][] map;
	static int[][] copy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 크기
		int num = (int) Math.pow(2, N);

		map = new int[num + 1][num + 1];
		copy = new int[num + 1][num + 1];

		int Q = sc.nextInt();
		// 단계 횟수
		int[] levels = new int[Q];

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= num; i++) {
			copy[i] = Arrays.copyOf(map[i], num);
		}

		for (int i = 0; i < Q; i++) {
			int n = sc.nextInt();
			int number = (int) Math.pow(2, n);
			levels[i] = number;
		}

	}

	static void turn(int x) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				map[i][j] = copy[][i];
			}
		}
	}
}
