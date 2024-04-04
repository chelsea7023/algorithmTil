package BOJ_16987_계란으로계란치기;

import java.util.LinkedList;
import java.util.Queue;

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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<int[]> egg = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			egg.add(new int[] {x, y});
		}
		
		
		
		
	}

}
