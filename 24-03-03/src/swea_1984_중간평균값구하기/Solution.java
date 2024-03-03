package swea_1984_중간평균값구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[] num = new int[10];
			for(int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			double sum = 0;
//			System.out.println(Arrays.toString(num));
			for(int i = 1; i < num.length - 1; i++) {
				sum += num[i];
			}
			System.out.printf("#" + tc + " " + "%.0f",sum/8);
			System.out.println();
			
		}
	}
}
