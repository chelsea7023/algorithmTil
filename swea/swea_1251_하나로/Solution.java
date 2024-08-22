package swea_1251_하나로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static double E;
	static final double INF = Double.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // 점의 수
			
			List<Integer> x_list = new ArrayList<>();
			List<Integer> y_list = new ArrayList<>();
			
			int[] p = new int[N + 1];
			
			for (int i = 0; i < N; i++) {
				x_list.add(sc.nextInt());
			}
			
			for (int i = 0; i < N; i++) {
				y_list.add(sc.nextInt());
			}
			
			double E = sc.nextDouble();
			
			Queue<Double> q= new LinkedList<>();
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					q.add(E * (Math.pow(x_list.get(i) - x_list.get(j), 2) + Math.pow(y_list.get(i) - y_list.get(j), 2)));
				}
			}
			double[][] map = new double[N][N];
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					map[i][j] = map[j][i] = q.poll();
				}
			}
						
			int V = N;
			boolean[] visited = new boolean[V];
			double[] dist = new double[V];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			double ans = 0;
			for(int i = 0; i < V; i++) {
				double min = INF;
				int idx = -1;
				for(int j = 0; j < V; j++) {
					if(!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				visited[idx] = true;
				ans += min;
				for(int j = 0; j < V; j++) {
					if(!visited[j] && map[idx][j] != 0 && dist[j] > map[idx][j]) {
						dist[j] = map[idx][j];
					}
				}
			}
			System.out.printf("#" + tc + " " + "%.0f", ans);
			System.out.println();
		}
	}
	
}
