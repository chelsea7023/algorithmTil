
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 12
5 0
0 7
9 0
47 63
26 60
60 50
32 38
98 366
5310 6
7519 2006
7579 4005
2720 8031
 */

public class Main {

	static char[] word;
	static List<Integer> number;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		word = new char[4];
		word[0] = 'L';
		word[1] = 'R';
		word[2] = 'D';
		word[3] = 'S';

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			String goal = st.nextToken();
			visited = new boolean[10000];
			bfs(start, goal);
		}

	}

	static void bfs(String str1, String str2) {
		Queue<String[]> str = new LinkedList<>();

		str.add(new String[] { str1, "" });

		visited[Integer.parseInt(str1)] = true;

		while (!str.isEmpty()) {

			String[] curr = str.poll();
			String now = curr[0];
			String method = curr[1];

			if (now.equals(str2)) {
				StringBuilder sb = new StringBuilder("");
				sb.append(method);
				System.out.println(sb);
				return;
			}

			for (int i = 0; i < 4; i++) {

				char order = word[i];

				if (order == 'L') {
					int num = Integer.parseInt(now);
					int first = num / 1000;
					int remain = num % 1000;
					num = remain * 10 + first;

					if (visited[num]) {
						continue;
					} else {
						visited[num] = true;
					}

					str.add(new String[] { Integer.toString(num), method + "L" });

				} else if (order == 'R') {
					int num = Integer.parseInt(now);
					int first = num % 10;
					int rest = num / 10;
					num = first * 1000 + rest;

					if (visited[num]) {
						continue;
					} else {
						visited[num] = true;
					}

					str.add(new String[] { Integer.toString(num), method + "R" });

				} else if (order == 'D') {
					int num = Integer.parseInt(now);
					num *= 2;
					if (num > 9999) {
						num %= 10000;
					}

					if (visited[num]) {
						continue;
					} else {
						visited[num] = true;
					}

					str.add(new String[] { Integer.toString(num), method + "D" });
				} else {
					int num = Integer.parseInt(now);
					num -= 1;
					if (num < 0) {
						num = 9999;
					}

					if (visited[num]) {
						continue;
					} else {
						visited[num] = true;
					}

					str.add(new String[] { Integer.toString(num), method + "S" });
				}
			}
		}
	}
}
