package swea_1208_flatten;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[] box = new int[100];
			for(int i = 0; i < box.length; i++) {
				box[i] = sc.nextInt();
			}
			/*
			 * N의 값은 덤프 횟수 
			 * box 배열 완성
			 * 어떤 방식으로 해야 평탄화 시킬 수 있을까
			 * 가장 큰 값에서 1을 가장 작은 값으로 보내주자
			 * while문으로 묶고 
			 */
			
			int cnt = 0; 
			while (cnt < N) {
				sort(box);
				box[0] -= 1;
				box[99] += 1; 
				cnt++;
			}
			sort(box);
			System.out.println("#" + tc + " " + (box[0] - box[99]));
			
		}
	}
	static int[] sort(int[] arr ) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] < arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}

}
