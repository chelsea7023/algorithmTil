package swea_1940_가랏RC카;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //커맨드 수
			int sum = 0;
			int cnt = 0;
			Tc:for(int i = 0; i < N; i++) {
				
				if(sc.nextInt() == 1) {
					if(sc.nextInt() == 2) {
						cnt += 2;
						sum += cnt;
					}else if(sc.nextInt() == 1) {
						cnt+=1;
						sum +=cnt;
						
					}
				}else if(sc.nextInt() == 2) {
					if(sc.nextInt() == 1) {
						cnt -= 1;
						sum += cnt;
					}else if(sc.nextInt() == 2){
						cnt -= 2;
						sum+=cnt;
						
					}
				}else {
					sum += cnt;
					continue Tc;
				}
			}System.out.println(sum);
		}
	}

}
