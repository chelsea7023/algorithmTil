package BOJ_10815_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card);

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] check = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			if (map.containsKey(card[i])) {
				cnt = map.get(card[i]) + 1;
			}
			map.put(card[i], cnt);
		}
		for (int i = 0; i < M; i++) {
			if (map.containsKey(check[i])) {
				System.out.print(map.get(check[i]) + " ");
			} else {
				System.out.print(0 + " ");
			}
		}

	}

}
