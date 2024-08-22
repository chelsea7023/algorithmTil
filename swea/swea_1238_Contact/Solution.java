package swea_1238_Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			int[] data = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				data[i] = sc.nextInt();
				if (max < data[i]) {
					max = data[i];
				}
			}
			visited = new boolean[max + 1][max + 1];
			map = new int[max + 1][max + 1];

			for (int i = 0; i < data.length - 1; i += 2) {
				map[data[i]][data[i + 1]] = 1;
			}
			/*
			 * 단방향도 있기 때문에 이렇게 만드는 것까지는 했는데. 다음엔 어떻게 구현을 해줘야 할까
			 * 
			 */
			prim(start, max);
			System.out.println(list);
			System.out.println(list2);
		}
	}

	// 최대값 구하는 prim?
//	static void prim(int x, int MAX) {
//		for (int i = 1; i <= MAX; i++) {
//			if (map[x][i] == 1 && !visited[x][i]) {
//				cnt++;
//				visited[x][i] = true;
//				list.add(i);
//				list2.add(cnt);
//				prim(i, MAX);
//
//			}
//		}
//	}
}
