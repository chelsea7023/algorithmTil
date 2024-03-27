package swea_1204_최빈수구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] student = new int[1000];
			for(int i = 0; i < 1000; i++) {
				student[i] = sc.nextInt();
			}
			/*
			 * 특이하게 테스트 케이스를 다시 입력값으로 주는 점 주의
			 * 빈도수를 더해줄 임시 배열을 하나 생성 점수는 100점이 최대니까 거기까지만 만들자 
			 * 
			 */
			int[] cnt = new int[101];
			for(int i = 0; i < 1000; i++) {
				cnt[student[i]] ++;
			}
			//cnt 값 완성 최대값 구해보자
			
			int max = Integer.MIN_VALUE;
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
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println(list.get(0));
		
		}

	}

}
