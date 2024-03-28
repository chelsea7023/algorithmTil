package BOJ_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 최단 거리를 구하는 문제의 경우 BFS일 가능성이 제일 높다는 부분을
 * 이 문제를 통해 기억하자 
 */


public class Main {
	
	static int[][] maze;
	static int N, M;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, -1, 0, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M]; 
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		/* 여기까지 지도 완성인데
		 * 
		 */
		
		
		
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(maze[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			var curr = q.poll();
			int nx = curr[0];
			int ny = curr[1];
			for(int d = 0; d < 4; d++) {
				int nextX = nx + di[d];
				int nextY = ny + dj[d];
				if(check(nextX, nextY) && maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					q.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
					maze[nextX][nextY] = maze[nx][ny] + 1;
				}
				
			}
		}
	}
	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
