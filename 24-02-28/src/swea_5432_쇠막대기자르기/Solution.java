package swea_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc ++) {
			String str = sc.next();
			char[]stick = new char[str.length()];
			for(int i = 0; i < stick.length; i++) {
				stick[i] = str.charAt(i);
			}
			
			int cnt = 0;
			
			int metal = 0; // 쇠막대기
			int piece = 0; // 추가되는 막대기의 수
			
			for(int i = 0; i < stick.length; i++) {
				if(stick[i] == '(') {
					metal++;
				}else {
					if(stick[i - 1] == '(') {
						// 레이저라는 의미
						metal--;
						piece += metal;
					}else {
						metal--;
						piece++;
					}
				}
			}
			piece += metal;
			System.out.println("#" + tc + " " + piece);
		}
	}

}
