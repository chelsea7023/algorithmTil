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

		Queue<Integer> road = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			road.add(sc.nextInt());
		}

		int time = 0;

		while (!road.isEmpty()) {
			int num = road.poll();
			int cnt = 1;
			if (num + road.peek() <= L && cnt <= w && road.isEmpty()) {
				num += road.peek();
				cnt++;
			}
			time++;
		}

		System.out.println(time);
	}

}
