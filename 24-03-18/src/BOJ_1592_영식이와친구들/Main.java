package BOJ_1592_영식이와친구들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 일단 N명의 사람이 던지는데 무조건 1번 자리가 먼저니까 시작은 시계방향으로 던져진다. 
 * 여기서 생각해야할 부분은 원형으로 도는걸 생각해야된다는 부분.
 * 배열을 하나 만들고 마이너스로 모듈화를 시켜서 배열의 안을 계속 돌게 구현한 결과
 * 생각보다 쉽게 만들 수 있었다.
 * 
 */


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		int cnt = 0; // 결과적으로 출력할 값
		
		int i = 0;
		arr[0] = 1;
		
		while(arr[i] < M) {
			if(arr[i] % 2 == 1) {
				if(i + L >= N) {
					i -= N;
				}
				arr[i + L]++;
				i = i + L;
				cnt++;
				
			
			}else if(arr[i] % 2 == 0) {
				if(i - L < 0) {
					i += N;
				}
				arr[i - L]++;
				i = i - L;
				cnt++;
				
			}
		}
		System.out.println(cnt);
		
		
	}

}
