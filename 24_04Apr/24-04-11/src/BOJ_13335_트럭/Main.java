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
		Queue<Integer> truck = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			truck.add(sc.nextInt());
		}

		for (int i = 0; i < w; i++) {
			road.add(0);
		}

		int time = 0;
		int sum = 0;

		while (!road.isEmpty()) {

			// 도로에 있는 합을 구하기 매번 트럭을 빼줄 때마다?
			// 다리에 차가 올라오는 조건은 대기 중인 차가 도로에 있는 차의 합과 다같이 합했을때 최대 무기 이하일 때만 나오기
			// 그리고 큐가 밀려나는 형식이니까 다리에서 하나 빼주고 다리에 하나 넣어주기
			if (!truck.isEmpty()) {
				
				if (sum - road.peek() + truck.peek() <= L) {
				
					int out_truck = road.poll();
					sum -= out_truck;
					int now_truck = truck.poll();
					road.add(now_truck);
					sum += now_truck;
				} else {
					road.add(0);
					int out_truck = road.poll();
					sum -= out_truck;
				}
			} else {
				road.poll();
			}

			time++;
		}

		System.out.println(time);
	}

}
