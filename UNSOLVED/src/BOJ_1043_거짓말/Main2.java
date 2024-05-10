package BOJ_1043_거짓말;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	static List<List<Integer>> combi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ��� ��ȣ �ִ� ��
		int M = sc.nextInt();
		// ��Ƽ ��
		int T = sc.nextInt();
		// ����� �ƴ� ��� ��

		List<Integer> truth = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			truth.add(sc.nextInt());
		}

		List<int[]> total = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int P = sc.nextInt();
			int[] arr = new int[P];
			for (int j = 0; j < P; j++) {
				arr[j] = sc.nextInt();
			}
			total.add(arr);
		}

		combi = new ArrayList<>();
		// ���տ� ����Ʈ

		for (int i = 0; i < M; i++) {
			int[] curr = total.get(i);
			boolean[] visited = new boolean[curr.length];

			combination(curr, visited, 0, 0, 2);
		}

		for (List<Integer> x : combi) {
			System.out.println(x);
		}
	}

	static void combination(int[] arr, boolean[] visited, int start, int dp, int r) {

		if (dp == r) {
			List<Integer> arr2 = new ArrayList<>();

			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					arr2.add(arr[i]);
				}
			}

			combi.add(arr2);

			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(arr, visited, i + 1, dp + 1, r);
				visited[i] = false;
			}
		}

	}

}
