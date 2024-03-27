package swea_1289_원재의메모리복구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int [] arr = new int[str.length()];
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
			}
			
			
			int[] pwd = new int[arr.length];
			int cnt = 0;

			
			while(!Arrays.equals(arr, pwd)) {
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != pwd[i]) {
						cnt++;
						int num = i;
						for(int j = i; j < arr.length; j++) {
							pwd[j] = arr[num];
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);

				
		}
	}
}
