package swea_2063_중간값구하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			/*
			 * 배열 완성했으니까
			 * 크기 순으로 정렬해서 
			 * 중간값을 찾아보자
			 * 
			 */
			sort(arr);
			System.out.print(arr[N/2]);
		}
		
	static int[] sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] < arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp; 
				}
			}
		}
		return arr;
	}
}
