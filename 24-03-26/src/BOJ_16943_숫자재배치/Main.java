package BOJ_16943_숫자재배치;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static char[] arr;
	static boolean[] visited;
	static char[] out;
	static int dp, r, B, max;
	static ArrayList<Integer> array;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String one = sc.next();
		B = Integer.parseInt(sc.next());
		char[]out = new char[one.length()];
		boolean[]visited = new boolean[one.length()];
		array = new ArrayList<>();
		char[] arr = one.toCharArray();
		
		int ans = -1;
		
		permutation(arr, visited, out, 0, arr.length, B);
		Collections.sort(array);
		if(array.isEmpty()) {
			System.out.print(ans);
		}else {
			System.out.print(array.get(array.size() -1));
		}
	}
	
	public static void permutation(char[] arr, boolean[]visited, char[]out, int dp, int r, int B) {
		String str = "";
		if(r == dp) {
			
			if(out[0] == '0') {
				return;
			}
			for(int i = 0 ; i < out.length; i++) {
				str += out[i];
			}
			
			int Anum = Integer.parseInt(str);
			if(Anum < B && Anum > max) {
				array.add(Anum);
			}
			
			
		}
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[dp] = arr[i];
				permutation(arr, visited, out, dp+1, r, B);
				visited[i] = false;
			}
		}
		
	}
	
	
	

}
