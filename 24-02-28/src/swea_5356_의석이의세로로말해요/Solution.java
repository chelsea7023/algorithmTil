package swea_5356_의석이의세로로말해요;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[][] word = new char[5][15];
			for (int i = 0; i < 5; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					word[i][j] = str.charAt(j);
				}
			}
			List<Character> list = new ArrayList<>();
			System.out.print("#" + tc + " ");
				for (int j = 0; j < 15; j++) {
					for (int i = 0; i < 5; i++) {
						list.add(word[i][j]);
					}
				
			}System.out.println(list);
		}
	}
}
