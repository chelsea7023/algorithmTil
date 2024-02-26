package swea_1210_ladder;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[][] ladder = new int[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			/*
			 * 사다리 배열 만들기까지 완료
			 * 도착 지점이 2인데 시작지점인 부분을 찾아야하는거니까 거꾸로 거슬러 올라가면 될거 같다
			 * 우선 2인 지점을 찾자 그리고 거기서 부터 출발 그리고 사다리 방식으로 쭉쭉 이동해서 시작지점을 찾자 
			 */
			int nowI = 99;
			int nowJ = 0;
			for(int i = 0; i < 100; i++) {
				if(ladder[nowI][i] == 2) {
					nowJ = i;
					break;
				}
			}
			while(nowI > 0) {
				if(nowJ > 0 && ladder[nowI][nowJ - 1] == 1) {
					nowJ --;
					while(ladder[nowI - 1][nowJ] != 1) {
						nowJ--;
					}
					nowI--;
				}
				else if(nowJ < 99 && ladder[nowI][nowJ + 1] == 1) {
					nowJ++;
					while(ladder[nowI - 1][nowJ] != 1) {
						nowJ++;
					}
					nowI--;
				}else {
					nowI--;
				}
			}
			System.out.println(nowJ);
			/*
			 * 간과한 부분이 배열의 탐색까지의 설계는 좋았지만
			 * 끝에 달햇을때 어떻게 배열의 밖으로 나가려 하는걸 막는 법을 넣었어야 했다
			 * 결국 방법을 찾지 못하고 참조 했는데
			 * 생각보다 방법은 쉬웠다 단순히 조건 하나를 추가해주는 것.
			 * 
			 */
			
			
		}
	}

}
