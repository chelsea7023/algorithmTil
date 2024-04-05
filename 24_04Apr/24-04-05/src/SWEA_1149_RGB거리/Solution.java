package SWEA_1149_RGB거리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int[][] map;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	static Queue<int[]> q = new LinkedList<>();
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
				if (i == 0) {
					q.add(new int[] { i, j, 0, map[i][j] });
				}
			}
		}

	}

	static void bfs() {
		while (!q.isEmpty()) {
			var curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int count = curr[2];
			int sum = curr[3];

			visited[y] = true;

			if (count == N) {
				list.add(sum);

			}

		}

	}

}
