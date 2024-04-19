package BOJ_10815_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Fail_1 {

	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card);
//		System.out.println(Arrays.toString(card));
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] check = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}


		for (int i = 0; i < check.length; i++) {
			cnt = 0;
			BS(card, check[i]);

		}
	}

	static void BS(int[] arr, int key) {
		int start = 0;
		int start2 = 0;
		int end = arr.length - 1;
		int end2 = arr.length - 1;
		int mid = 0;
		int mid2 = 0;
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

			mid2 = (start2 + end2) / 2;
			if (key <= arr[mid2]) {
				end2 = mid2 - 1;
			} else {
				start2 = mid2 + 1;
			}
		}
		if (flag) {
			System.out.print(start - start2 + " ");
		} else {
			System.out.print(0 + " ");
		}

	}

}
