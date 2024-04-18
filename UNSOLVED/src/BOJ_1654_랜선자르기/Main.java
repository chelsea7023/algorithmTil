package BOJ_1654_랜선자르기;

import java.util.Arrays;
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
		long ans = sum / K;
		int cnt = 0;
		int mid = N / 2;
		while (cnt < K) {
			cnt = 0;
			for (int i = 0; i < mid; i++) {
				cnt += arr[i] / ans;
			}
			ans--;
		}
		System.out.println(ans + 1);

	}
}
