package swea_2007_패턴마디의길이;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String a = sc.next();
			for(int i = 1; i <= a.length(); i++) {
				String b = a.substring(0, i);
				String c = a.substring(i, i+i);
				if(b.equals(c)) {
					System.out.println("#" + tc + " " + b.length());
					break;
				}
			}

		}

	}

}
