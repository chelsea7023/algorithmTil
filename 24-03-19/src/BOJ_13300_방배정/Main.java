package BOJ_13300_방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 침착하게 count 배열을 활용하여 만들었다.
 * 생각보다 어렵지 않았던 문제 
 * 남자와 여자 그리고 학년 별로 방을 규칙하에 배열로 만들었다
 * 배열은 무조건 6학년 2성별이기 때문에 12까지 들어갈 수 있는걸로 하지만 
 * 카운트 배열이기 때문에 13까지 배열을 만들어주고 
 * 남자인 경우 학년x2 의 배열에 
 * 여자인 경우 학년x2-1의 배열에 넣어줬다.
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 인원 수 
		int K = Integer.parseInt(st.nextToken()); // 방 최대 수용 인원
		
		int cnt = 0; // 방 갯수
		
		int[]room = new int[13];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 성별
			int q = Integer.parseInt(st.nextToken()); // 학년
			
			if(p == 1) {
				room[q * 2]++;
			}else {
				room[q * 2 - 1]++;
			}
		}
		for(int i = 1; i < 13; i++) {
			if(room[i] % K == 0) {
				cnt += room[i]/K;
			}else if(room[i] != 0 && room[i] < K) {
				cnt += 1;
			}else {
				cnt += room[i]/K + 1;
			}
		}
		System.out.println(cnt);
		
	}

}
