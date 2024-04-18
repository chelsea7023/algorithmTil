package BOJ_10815_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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
		int end = arr.length - 1;
		int mid = 0;
		boolean flag = false;
		THIS: while (start <= end) {
			mid = (start + end) / 2;
			if (key >= arr[mid]) {
				if (key == arr[mid]) {
					flag = true;
					cnt++;
					if (mid + 1 <= arr.length - 1 && key != arr[mid + 1]) {
						end = mid - 1;
						continue THIS;
					}
				}
				start = mid + 1;

			} else {
				end = mid - 1;
			}
		}
		if (flag) {
			System.out.print(cnt + " ");
		} else {
			System.out.print(0 + " ");
		}

	}

}
