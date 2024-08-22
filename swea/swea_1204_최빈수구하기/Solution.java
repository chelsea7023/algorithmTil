package swea_1204_최빈수구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] student = new int[1000];
			for(int i = 0; i < 1000; i++) {
				student[i] = sc.nextInt();
				//여기까지 배열 입력 완성
			}
			int [] cnt = new int[101];
			for(int i = 0; i < 1000; i++) {
				cnt[student[i]]++;
			}
			//여기까지 카운팅 완료
			int max = 0;
			for(int i = 0; i < 101; i++) {
				if(max < cnt[i]) {
					max = cnt[i];
				}
			}
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < 101; i++) {
				if(cnt[i] == max) {
					list.add(i);
				}
			}
			Collections.reverse(list);// 정렬
			System.out.println("#" + N + " " +list.get(0));
			
			
			
		}
	}

}
