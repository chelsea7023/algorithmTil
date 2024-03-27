package swea_5356_의석이의세로로말해요;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			char[][]word = new char[5][15];
			for(int i = 0; i < 5; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					word[i][j] = str.charAt(j);
				}
			}
			/*
			 * 배열을 입력받는것까지는 완성 근데 행마다 길이가 다르다.
			 * 그래서 문제는 중간에 없는 배열의 경우는 어떻게 출력하냐는 건데..
			 * 일단은 출력해보고 문제를 해결해보자
			 * 
			 * 출력을 해보니 역시나
			 * Aa0aPAf985Bz1EhCz2W3D 1gkD   6x
			 * 이런식으로 출력된다 
			 * 빈칸인 경우 출력을 못하게 하는건 없나..
			 * 고민 고민을 하다가.. 음  
			 * 역시 아스키 코드가 있었다.
			 * 
			 */
			System.out.print("#" + tc + " ");
			for(int j = 0; j < 15; j++) {
				for(int i = 0; i < 5; i++) {
					if(word[i][j] > 0) {
						System.out.print(word[i][j]);
					}
					
				}
			}System.out.println();
		}

	}

}
