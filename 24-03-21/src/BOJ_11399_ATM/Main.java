package BOJ_11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람 수

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 배열담기까지는 완료했다만.. 최소한의 시간을 구하는 법이 생각보다 쉽네
		Arrays.sort(arr);
		System.out.println(greedy(arr));
		
		
		
	}
	static int greedy(int[]arr) {
		
		int sum = 0;
		int cnt = arr.length;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i] * cnt;
			cnt--;			
		}
		return sum;
	}

}
