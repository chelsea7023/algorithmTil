package swea_7272_안경이없어;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			String str2 = sc.next();
			
			char[]arr = str.toCharArray();
			char[]arr2 = str2.toCharArray();
			
//			char[]arr = new char[str.length()];
//			char[]arr2 = new char[str2.length()];
//			for(int i = 0; i < arr.length; i++) {
//				arr[i] = str.charAt(i);
//			}
//			for(int i = 0; i < arr2.length; i++) {
//				arr2[i] = str2.charAt(i);
//			}
			
			
			if(Arrays.equals(change(arr), change(arr2))){
				System.out.println("#" + tc + " SAME");
			}else {
				System.out.println("#" + tc + " DIFF");
			}
			
			
		}

	}
	
	static char[] change(char[]arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 'A'||arr[i] == 'D'||arr[i] == 'O'||arr[i] == 'P'||arr[i] == 'Q'||arr[i] == 'R') {
				arr[i] = '1';
			}else if(arr[i] == 'B') {
				arr[i] = '2';
			}else {
				arr[i] = '0';
			}
		}
		return arr;
	}
	
	
}
