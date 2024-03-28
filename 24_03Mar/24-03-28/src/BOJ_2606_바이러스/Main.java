package BOJ_2606_바이러스;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 수
		int E = sc.nextInt(); // 간선의 수
		
		int[][] edges = new int[E][2];
		
		for(int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x <= y) {
				edges[i][0] = x;
				edges[i][1] = y;
			}else {
				edges[i][0] = y;
				edges[i][1] = x;
			}
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0] - o1[0];
			}
			
			
		});
		
		p = new int[V + 1];
		for(int i = 0; i <= V; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			if(findSet(x) != findSet(y))
				union(x, y);
		}
		
		for(int i = 1; i <= V; i++) {
			p[i] = findSet(p[i]);
		}
		
		
		
		int cnt = 0;
		for(int i = 2; i <= V; i++) {
			if(findSet(i) == 1)
				cnt++;
		}
		System.out.println(cnt);
		
		
	}
	
	static int findSet(int x) {
		if(x == p[x])
			return x;
		else
			return findSet(p[x]);
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
	
	

}
