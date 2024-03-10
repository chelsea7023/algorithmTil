package swea_1289_원재의메모리복구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int[] str = new int[4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j< 4; j++) {
				str[j] = arr[j][i];
			}
			System.out.println(Arrays.toString(str));
		}
	}
}
