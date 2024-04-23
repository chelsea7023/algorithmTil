package BOJ_2470_두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

	static List<List<Integer>> combi = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		boolean[] visited = new boolean[num.length];

		com(num, visited, 0, 0, 2);

		Collections.sort(combi, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(2) - o2.get(2);
			}

		});

		for (List x : combi) {
			System.out.println(x);
		}
//		int start = 0;
//		int end = combi.size() - 1;
//		int mid = 0;
//		while (start < end) {
//			mid = (start + end) / 2;
//
//			if (combi.get(mid).get(2) > 0) {
//				end = mid - 1;
//			} else {
//				start = mid + 1;
//			}
//		}
//
//		System.out.println(combi.get(start).get(0) + " " + combi.get(start).get(1));

		int max = Integer.MIN_VALUE;
		int ans = 0;
		for (int i = 0; i < combi.size(); i++) {
			if (combi.get(i).get(2) < 0) {
				if (max < combi.get(i).get(2) && combi.get(i).get(2) < 0) {
					max = combi.get(i).get(2);
					ans = i;
				}
			}
		}
		System.out.println(num[combi.get(ans).get(0)] + " " + num[combi.get(ans).get(1)]);
	}

	static void com(int[] arr, boolean[] visited, int start, int dp, int r) {

		if (dp == r) {
			List<Integer> two = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					two.add(i);
				}
			}
			two.add(arr[two.get(0)] + arr[two.get(1)]);
			combi.add(two);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				com(arr, visited, i + 1, dp + 1, r);
				visited[i] = false;
			}
		}
	}
}
