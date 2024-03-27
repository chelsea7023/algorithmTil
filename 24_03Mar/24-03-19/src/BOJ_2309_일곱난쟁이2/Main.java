package BOJ_2309_일곱난쟁이2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * 브루트포스 문제.
 * 완전 탐색이라고 해서 나는 2차원 배열의 완탐 같은건줄 알았지만, 
 * 그게 아니라 진짜 모든 경우의 수를 다 따져보는 무식한 방법이라고 한다.
 * 2번째 풀이인데 이 방법은 친구가 조언해준 방법인데 내가 위에 한 것보다 훨씬 효율적
 * 인 것 같아서 구현 도전
 * 방법은 어차피 난쟁이의 숫자는 정해져 있으니 다 더한 값에서 100을 빼주고 그 남은 값이
 * 난쟁이 두명의 합과 같으면
 * 그 두명을 빼고 출력해주면 되다는 것.
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0; 
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			int num1 = arr[i];
			for(int j = i + 1; j < arr.length; j++) {
				int num2 = arr[j];
				if(num1 + num2 == sum - 100) {
					for(int k = 0; k < arr.length; k++) {
						if(arr[k] != num1 && arr[k] != num2) {
							System.out.println(arr[k]);
						}
					}
				}
			}
		}
		
	}
}
