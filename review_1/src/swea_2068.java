
import java.util.Arrays;
import java.util.Scanner;


/*
 * 버블 정렬 방식으로 문제 푸는 것에 익숙해졌으니 다른 방식의 정렬도 익숙해지도록 노력해야 할거 같다.
 * 그리고 버블 정렬 방식으로 문제를 풀 때마다 메소드 선언에서 i랑 j를 자꾸 바꿔 써서 오류가 난다. 조심할 것!
 * 
 */


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 값 입력받기
        int[] arr = new int [10]; // 기본 배열 선언
		
		
		for(int tc = 1; tc <= T; tc++)
		{
		
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = sc.nextInt(); // 만들어둔 배열에 값 입력받기
		}
		arr = bubble(arr);
//		System.out.println(Arrays.toString(arr));
		System.out.printf("#%d %d\n", tc, arr[0]);
		}
	}
	
	public static int[] bubble(int[]arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j ++) {
				if(arr[j] < arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
}