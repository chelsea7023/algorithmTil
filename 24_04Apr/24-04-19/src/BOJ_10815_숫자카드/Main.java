package BOJ_10815_숫자카드;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 상근이가 가지고 있는 카드의 수
		int[] card = new int[N];
		// 상근이가 가지고 있는 카드 종류

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		Arrays.sort(card);

		int M = sc.nextInt();
		// 확인해야할 숫자 수
		int[] check = new int[M];

		for (int i = 0; i < M; i++) {
			check[i] = sc.nextInt();
		}

		for (int i = 0; i < check.length; i++) {
			BS(card, check[i]);
		}

	}

	static void BS(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		boolean flag = false;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (key == arr[mid]) {
				flag = true;
				System.out.print(1 + " ");
				return;
			} else if (key > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (!flag) {
			System.out.print(0 + " ");
		}
	}
}
