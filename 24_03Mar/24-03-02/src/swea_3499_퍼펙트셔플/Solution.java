package swea_3499_퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 단어 수
			String[] word = new String[N];
			// 배열 선언 해주고
			for (int i = 0; i < N; i++) {
				word[i] = sc.next();
			}
			Queue<String> que = new LinkedList<>();
			Queue<String> que2 = new LinkedList<>();
			if (N % 2 == 0) {
				for (int i = 0; i < N / 2; i++) {
					que.add(word[i]);
				}
				for (int i = N / 2; i < N; i++) {
					que2.add(word[i]);
				}
				System.out.print("#" + tc + " ");
				for (int i = 0; i < N; i++) {
					if (i % 2 == 0) {
						System.out.print(que.poll() + " ");
					} else if (i % 2 == 1) {
						System.out.print(que2.poll() + " ");
					}
				}
				System.out.println();
			}else {
				for (int i = 0; i <= N / 2; i++) {
					que.add(word[i]);
				}
				for (int i = N / 2 + 1; i < N; i++) {
					que2.add(word[i]);
				}
				System.out.print("#" + tc + " ");
				for (int i = 0; i < N; i++) {
					if (i % 2 == 0) {
						System.out.print(que.poll() + " ");
					} else if (i % 2 == 1) {
						System.out.print(que2.poll() + " ");
					}
				}
				System.out.println();
				
			}
		}

	}
}
