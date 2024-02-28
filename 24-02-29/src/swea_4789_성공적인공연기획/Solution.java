package swea_4789_성공적인공연기획;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
//			System.out.println(Arrays.toString(arr)); 잘 받아지는지 확인 완료
			int cnt = 0;

			for (int i = arr.length - 1; i >= 0; i--) {
				int sum = 0;
				for (int j = 0; j < i; j++) {
					sum += arr[j] - '0';

				}
				if(i > sum) {
					cnt = i - sum;
					break;
				}

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
