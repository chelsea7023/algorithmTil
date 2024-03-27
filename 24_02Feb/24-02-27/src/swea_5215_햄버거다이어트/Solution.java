package swea_5215_햄버거다이어트;


import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int Limit = sc.nextInt();

			int[] str = new int[N];
			int[] calorie = new int[N];
			for (int i = 0; i < N; i++) {
				str[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			// 종류는 string으로 받고 잘 들어간 것 확인
			// 칼로리는 int로 받고
			int max = 0;
			
			// N개의 자료를 이용하여 만들 수 있는 모든 경우의 수
			
			for (int i = 0; i < (1 << N); i++) { // 0 ~ 2^N-1 2^20개의 경우에 대해서

				// i라는 값은 -> 부분집합의 값인걸 알았는데
				// i의 칼로리가 무엇인지 알 수 가 없다.
				int ing = 0;
				int cal = 0;
				

				for (int j = 0; j < N; j++) {
					// 1이라고 하는 값을 j번 << 하면서 값을 비교한다.
					if ((i & (1 << j)) > 0) { // 선택됐는지 확인
						cal += calorie[j];
						ing += str[j];

					}
				}
				if (cal <= Limit) {
					if (max < ing) {
						max = ing;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

}
