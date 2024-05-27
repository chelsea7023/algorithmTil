import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int F, S, G, U, D, ans;
	static boolean flag = false;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt(); // 총 층수
		S = sc.nextInt(); // 현재 위치
		G = sc.nextInt(); // 목표 지점
		U = sc.nextInt(); // 한번에 위로 갈 수 있는 층 수
		D = sc.nextInt(); // 한번에 아래로 갈 수 있는 층 수

		visited = new boolean[F + 1];
		q.add(S);
		q.add(0);

		stair();

		if (flag) {
			System.out.println(ans);
		} else {
			System.out.println("use the stairs");
		}

	}

	static void stair() {

		while (!q.isEmpty()) {
			int curr = q.poll();
			int count = q.poll();
			if(curr == G) {
				flag = true;
				ans = count;
				return;
			}
			
			int curr_u = curr + U;
			if (check(curr_u) && !visited[curr_u]) {
				q.add(curr_u);
				q.add(count + 1);
				visited[curr_u] = true;
			}
			
			
			int curr_d = curr - D;
			if (check(curr_d) && !visited[curr_d]) {
				q.add(curr_d);
				q.add(count + 1);
				visited[curr_d] = true;
			}
		}
	}

	static boolean check(int x) {
		return x > 0 && x <= F;
	}

}
