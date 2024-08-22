package swea_1206_view;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int [] view = new int[N];
			for(int i = 0; i < N; i++) {
				view[i] = sc.nextInt();
			}
			/*
			 * 여기까지 배열 생성 완료 
			 * 빌딩의 높이는 숫자로 입력됐다
			 * 그러면 배열 2부터 돌면서 i를 기준으로 왼쪽 오른쪽 확인 
			 * 양쪽 전부가 성립해야 값을 출력해서 더해준
			 */
			int sum = 0; 
			int[]arr = {-2, -1, 1, 2};
			for(int i = 2; i < N - 2; i++) {
				int max = 0; 
				for(int j = 0; j < 4; j++) {
					if(max < view[i + arr[j]]) {
						max = view[i + arr[j]];
					}
				}
				if(view[i] > max) {
					sum += (view[i] - max);
				}else {
					continue;
				}
				
			}
			System.out.println(sum);
		}
		
		
	}

}
