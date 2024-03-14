package BOJ_1592_영식이와친구들;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 친구 숫자
		int M = sc.nextInt(); // 종료조건
		int L = sc.nextInt(); 
		// 공을 M번보다 적게 받은 사람이 공을 던질 때, 
		// 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 
		//짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
		int[] arr = new int[N];
		int cnt = 1;
		int total = 0; 
		
		
		while(cnt < M) {
			for(int i = 0; true; i+=L) {
				i %= N;
				if(arr[i] % 2 == 1) {
					arr[(i+L)%N]++;
					cnt++;
					total++;
				}else {
					if(i - L < 0) {
						 arr[i-L+N]++;
					}else {
						arr[i - L]++;
					}
				}
				
			}
		}
		System.out.println(total);
	}

}
