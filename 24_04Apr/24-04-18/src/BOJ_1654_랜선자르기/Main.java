package BOJ_1654_랜선자르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 랜선의 갯수
		int K = sc.nextInt();
		// 필요한 랜선의 수

		/*
		 * 필요한 랜선의 갯수를 확보했을때 가능한 최대 길이의 값을 구하기
		 * 
		 */

		int[] arr = new int[N];
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i] / 186);
//		}

		long end = sum / K;
		long start = 1;
		int cnt = 0;
		long result = 0;
		while (start <= end) {

			long mid = (start + end) / 2;
			cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += (arr[i] / mid);
			}
//			System.out.println(cnt);
			if (cnt < K) {
				end = mid - 1;
			} else { // 같거나 이상
				start = mid + 1;
			}
		}
		System.out.println(start - 1);

	}
}