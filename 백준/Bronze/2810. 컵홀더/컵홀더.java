import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		int N = sc.nextInt(); // 자리수 
		String str = sc.next();
		char[] seet = str.toCharArray();
		int cnt = 0; // 컵홀더 수 
		int d = 1;
		if(seet[0] == 'S') {
			cnt+=2;
		} else if(seet[0] == 'L') {
			cnt+=2;
			d++;
		}
		
		while(d < seet.length) {
			if(seet[d] == 'S') {
				cnt += 1;
				d++;
			}else if(seet[d] == 'L') {
				cnt += 1;
				d += 2;
			}
		}
		if(cnt > N) {
			cnt = N;
		}
		
		
		System.out.println(cnt);
	}
}
