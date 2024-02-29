package swea_4789_성공적인공연기획;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int[] arr = new int[str.length()];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i) - '0';
			}
//		System.out.println(Arrays.toString(arr));
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < arr.length - 1; i++) {
				sum += arr[i];
				if(arr[i + 1] > 0) {
					if(i + 1 > sum) {
						sum+= (i+1)-sum;
						cnt = (i + 1) -sum;
					}
				}
			}System.out.println(cnt);
		}
		
	}
}
