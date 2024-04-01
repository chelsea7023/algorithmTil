package SWEA_1267_작업순서;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
		int V = sc.nextInt(); // 정점 수
		int E = sc.nextInt(); // 간선 수
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		int[] arr = new int[V + 1];
		for(int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			
			arr[y]++;
		}
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= V; i++) {
			if(arr[i] == 0) {
				q.add(i);
			}
		}
		System.out.print("#" + tc + " ");
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for(int i = 1; i <= V; i++) {
				if(list.get(curr).contains(i)) {
					arr[i]--;
					list.get(curr).remove(Integer.valueOf(i));
					if(arr[i] == 0)
						q.add(i);
				}
			}
		}
		}
		
	}

}
