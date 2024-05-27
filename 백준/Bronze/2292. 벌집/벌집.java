import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 1; // 출력값인데 이미 1번방부터 1회로 치고 시작 
		int Num = 1;
		
		while(N > Num) {
			if(N > Num) {
				Num += 6*cnt;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
	
}
