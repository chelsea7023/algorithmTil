import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static int[][] arr;
	
	static int node, line, start, cnt;
	
	static Queue<Integer> que = new LinkedList<>();
	
	public static void BFS(int start) {
		que.offer(start);
		check[start] = true;
		System.out.print(start + " ");
		
		while(!que.isEmpty()) {
			start = que.poll();
			
			for(int i = 1; i <= node; i++) {
				if(arr[start][i] == 1 && check[i] == false) {
					que.offer(i);
					check[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
	
	
	
	public static  void DFS(int start) {
		check[start] = true;
		System.out.print(start + " ");
		
		if(cnt == node) {
			return;
		}
		cnt++;
		
		for(int i = 1; i <= node; i++) {
			if(arr[start][i] == 1 && check[i] == false) {
				DFS(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken()); // 정점의 갯수 입력
		line = Integer.parseInt(st.nextToken()); // 간선의 갯수
		start = Integer.parseInt(st.nextToken()); // 시작점
		
		arr = new int[node + 1][node + 1];
		check = new boolean [node + 1];
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		DFS(start);
		System.out.println();
		
		check = new boolean[node + 1];
		BFS(start);
		
	}

}
