
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] check = new int[M];
		for (int i = 0; i < M; i++) {
			check[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			BS(arr, check[i]);
		}

	}

	static void BS(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		boolean flag = false;
		while (start <= end) {
			mid = (start + end) / 2;

			if (key >= arr[mid]) {
				if (key == arr[mid]) {
					flag = true;
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}
}
