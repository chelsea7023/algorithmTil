package BOJ_2470_두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

//		System.out.println(Arrays.toString(num));

		/*
		 * 값이 갱신되지 않아 실패한 방법 1
		 */
//		int start = 0;
//		int end = num.length - 1;
//		int mid = 0;
//		while (start < end) {
//
//			mid = Math.abs(num[start] + num[end]);
//
//			if (start + 1 != end && mid > Math.abs(num[start + 1] + num[end])) {
//				start++;
//			} else if (start != end - 1 && mid > Math.abs(num[start] + num[end - 1])) {
//				end--;
//			} else {
//				break;
//			}
//
//		}
//		System.out.println(num[start] + " " + num[end]);

//		/* 
//		 * 시간 초과 나는 실패한 방법 2
//		 */
//		int min = Integer.MAX_VALUE;
//		int ans_x = 0;
//		int ans_y = 0;
//		for (int i = 0; i < N - 1; i++) {
//			for (int j = i + 1; j < N; j++) {
//				if (min > Math.abs(num[i] + num[j])) {
//					min = Math.abs(num[i] + num[j]);
//					ans_x = num[i];
//					ans_y = num[j];
//				}
//			}
//		}
//		System.out.println(ans_x + " " + ans_y);

		/*
		 * 재현이가 간단하게 알려줬지만 되지 않는 방법
		 */

		int start = 0;
		int end = num.length - 1;
		int mid = 0;
		int ans_x = 0;
		int ans_y = 0;
		int min = Integer.MAX_VALUE;
		while (start < end) {
			mid = num[start] + num[end];

			if (Math.abs(mid) < min) {
				min = Math.abs(mid);
				ans_x = num[start];
				ans_y = num[end];
			}

			if (mid < 0) {
				end--;
			} else if (mid > 0) {
				start++;
			} else {
				break;
			}
		}
		System.out.println(ans_x + " " + ans_y);

	}
}
