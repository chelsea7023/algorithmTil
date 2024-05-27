import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
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
