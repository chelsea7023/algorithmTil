package BOJ_1620_나는야포켓몬마스터이다솜;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도감 수
		int M = sc.nextInt(); // 문제 수

		List<String[]> pk = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			pk.add(new String[] { i + "", sc.next() });
		}

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			if (arr[0] < 'A') {
				System.out.println(pk.get(Integer.parseInt(str) - 1)[1]);
			} else {
				for (int j = 0; j < N; j++) {
					String ans = pk.get(j)[1];
					if (ans.equals(str)) {
						System.out.println(j + 1);
					}

				}
			}
		}
	}
}
