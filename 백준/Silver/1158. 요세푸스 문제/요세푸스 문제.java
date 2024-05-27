import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
