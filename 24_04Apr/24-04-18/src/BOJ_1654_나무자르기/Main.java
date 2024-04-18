package BOJ_1654_�����ڸ���;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���� ��
		int M = sc.nextInt(); // ���ϴ� ���� Ŀ�� ����

		int end = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (end < arr[i]) {
				end = arr[i];
			}
		}
		int start = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			int tree = 0;

			for (int i = 0; i < N; i++) {
				tree += (arr[i] - mid);
			}

			if (tree > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		System.out.println(start + 1);

	}
}
