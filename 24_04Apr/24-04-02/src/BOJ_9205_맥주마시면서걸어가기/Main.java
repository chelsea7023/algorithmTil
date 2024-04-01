package BOJ_9205_맥주마시면서걸어가기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n, startR, startC, endR, endC;
	static Queue<int[]> q = new LinkedList<>();
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt(); // 편의점 갯수
			startR = sc.nextInt();
			startC = sc.nextInt();
			q.add(new int[] {startR, startC});
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				q.add(new int[] {x, y});
			}
			endR = sc.nextInt();
			endC = sc.nextInt();
			
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			var curr = q.poll();
			int now_r = curr[0];
			int now_c = curr[1];
			
			if(now_r == endR && now_c == endC) {
				flag = true;
				return;
			}
			
			var goal = q.poll();
			int goal_r = goal[0];
			int goal_c = goal[1];
			
			if(Math.abs(goal_r - now_r) + Math.abs(goal_r - now_c) <= 1000) {
				q.add(new int[] {goal_r, goal_c});
			}
			
		}
	}

}
