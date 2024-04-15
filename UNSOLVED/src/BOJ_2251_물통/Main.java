package BOJ_2251_물통;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> water = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		boolean[] visited = new boolean[3];

		comb(visited, arr, 0, 0, 2);

		Collections.sort(water);

//	v

	}

	static void comb(boolean[] visited, int[] arr, int start, int dp, int r) {
		if (dp == r) {
			int[] ans = new int[2];
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(visited, arr, i + 1, dp + 1, r);
				visited[i] = false;
			}
		}

	}

	static void add(int x) {
		if (!water.contains(x)) {
			water.add(x);
		}
	}
}
