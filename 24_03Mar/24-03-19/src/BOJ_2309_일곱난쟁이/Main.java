package BOJ_2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * 브루트포스 문제.
 * 완전 탐색이라고 해서 나는 2차원 배열의 완탐 같은건줄 알았지만, 
 * 그게 아니라 진짜 모든 경우의 수를 다 따져보는 무식한 방법이라고 한다.
 * 그래서 생각한 것은 비트 연산자를 활용해서 모든 더한 경우의 수 중 7개를 더한 값을 구해서 
 * 그 중 100일 때 더한 인자들을 구하는 것. 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < (1 << 9); i++) {
			int sum = 0;
			int cnt = 0;
			boolean flag = false;
			list.removeAll(list);
			for (int j = 0; j < 9; j++) {
				if ((i & (1 << j)) > 0) {
					list.add(arr[j]);
					sum += arr[j];
					cnt++;
					if (cnt == 7 && sum == 100) {
						for (int k = 0; k < list.size(); k++) {
							System.out.println(list.get(k));
						}
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				break;
			}

		}
	}
}
