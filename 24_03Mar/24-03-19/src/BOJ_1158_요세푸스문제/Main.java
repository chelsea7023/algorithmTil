package BOJ_1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 처음에는 ArrayList에서
 * remove메소드를 쓰면 큐의 팝과 마찬가지로 따로 받을 수 있는 것을 확인하고
 * 두개의 ArrayList로 구현을 해보려고 했지만 인자 값을 활용하며 하기에는 너무 복잡해져서 포기 했다.
 * 결국 Que를 활용하려 3개를 앞의 두개는 다시 que에 추가해서 원형큐 느낌으로 만들었다.
 * 그 결과 원하는 결과를 얻을 수 있었다.
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0; // 멈추는 조건
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		System.out.print('<');
		while(cnt < N - 1) {
			for(int i = 1; i < K; i++) {
				que.add(que.poll());
			}
			System.out.print(que.poll()+", ");
			cnt++;
		}
		System.out.print(que.poll());
		System.out.print('>');
	}

}
