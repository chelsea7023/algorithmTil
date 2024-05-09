package BOJ_1043_거짓말;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 사람 수
		int M = sc.nextInt();
		// 파티 수

		int T = sc.nextInt();
		// 진실을 아는 사람 수
		List<Integer> truth = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			truth.add(sc.nextInt());
		}
		List<int[]> total = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int P = sc.nextInt();
			int[] party = new int[P];
			for (int j = 0; j < P; j++) {
				party[j] = sc.nextInt();
			}
			total.add(party);
		}

		Collections.sort(total, new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2.length - o1.length;
			}
		});

//		for (int[] x : total) {
//			System.out.println(Arrays.toString(x));
//		}

		// 그냥 먼저 진실을 아는 사람들을 다 포함 시켜버려야겠다 truth에다가

		THIS: for (int i = 0; i < total.size(); i++) {
			int[] curr = total.get(i);
			for (int j = 0; j < curr.length; j++) {
				for (int k = 0; k < truth.size(); k++) {
					if (curr[j] == truth.get(k)) {
						for (int l = 0; l < curr.length; l++) {
							if (!truth.contains(curr[l])) {
								truth.add(curr[l]);
							}
						}
						continue THIS;
					}
				}
			}
		}

		THIS: for (int i = total.size() - 1; i >= 0; i--) {
			int[] curr = total.get(i);
			for (int j = 0; j < curr.length; j++) {
				for (int k = 0; k < truth.size(); k++) {
					if (curr[j] == truth.get(k)) {
						for (int l = 0; l < curr.length; l++) {
							if (!truth.contains(curr[l])) {
								truth.add(curr[l]);
							}
						}
						continue THIS;
					}
				}
			}
		}

		System.out.println(truth);

		int cnt = 0;

		THIS: for (int i = 0; i < total.size(); i++) {
			int[] curr = total.get(i);
			for (int j = 0; j < curr.length; j++) {
				for (int k = 0; k < truth.size(); k++) {
					if (curr[j] == truth.get(k)) {
						continue THIS;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);

	}
}
