package BOJ_13335_트럭;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 트럭 수
		int w = sc.nextInt(); // 다리의 길이
		int L = sc.nextInt(); // 최대 하중
		
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> road = new LinkedList<>();
		
		
		for(int i = 0; i < n; i++) {
			truck.add(sc.nextInt());
		}
		
		int cnt = 0;
		
		while(!truck.isEmpty()) {
			if(truck.peek() < L) {
				road.add(truck.poll());
				road.
			}
			
		}
		

//		int[] arr = new int[2 * n + w];
//
//		int sum = 0;
//
//		for (int i = 2 * n + w - n; i < 2 * n + w; i++) {
//			arr[i] = sc.nextInt();
//			sum += arr[i];
//		}
//
//		System.out.println(Arrays.toString(arr));
//
//		int result = 0;
//
//		for (int i = 0; i < 4; i++) {
//			result += arr[i];
//		}
//
//		int answer = 0;
//
//		while (sum > result) {
//			
//		}

	}

}
