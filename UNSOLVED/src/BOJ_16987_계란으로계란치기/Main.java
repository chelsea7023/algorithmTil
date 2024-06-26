package BOJ_16987_계란으로계란치기;

import java.util.ArrayList;
import java.util.List;

/* 
 * 계란의 값으로 주어지는 것은 왼쪽 값 내구도, 오른쪽 값 무게
 * 계란은 내구도가 0이하가 되면 깨지는 것으로 판단
 * 내구도는 부딧히는 다른 계란의 무게 값을 빼주는 것을 계산
 * 계란을 최대한 많이 깨려면 무게가 낮은 순으로 깨주면 되는 것으로 계산해자.
 * 왼쪽 것을 골랐다가 다른 계란들을 쭉 돌면서 깨고 깨지지 않은 오른쪽 계란으로 간다.
 * 이 문제에서 핵심은 "계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 것"
 */

import java.util.Scanner;

public class Main {

	static int N, ans;
	static List<int[]> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			list.add(new int[] { x, y });
		}

		dfs(0, 0);

		System.out.println(ans);

	}

	static void dfs(int dp, int max) {

		if (dp == N) {
			if (max > ans) {
				ans = max;
			}
		}
		
		if(list.get(x)[0] <= 0) {
			dfs(x + 1, dp, max);
		}

		for (int i = 0; i < N; i++) {
			// 같은 계란이거나 이미 깨진거면 패스하는 것
			if ((i == x) || visited[i])
				continue;
			
			
			

		}

	}

}
