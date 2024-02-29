package swea_5658_보물상자비밀번호;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 숫자 갯수 
			int K = sc.nextInt(); // 몇번째 숫자를 꺼내는지
			String str = sc.next(); // 문자열로 입력 받고
			char[] words = str.toCharArray();
			char[] pwd = new char[N + (N/4 - 1)];
			// System.out.println(pwd.length);
			for(int i = 0; i < words.length; i++) {
				pwd[i] = words[i];
			}
			for(int i = 0; i < pwd.length - words.length; i++) {			
				pwd[pwd.length - (pwd.length - words.length) + i] = words[i];
			}
			List<Integer> realPwd = new ArrayList<>();
		
			int sum = 0;
			reverseArray(pwd);
			for(int i = 0; i <= pwd.length - 1 - (N/4 - 1); i++) {
				 for(int j = N/4 - 1; j >= 0; j--) {
					 sum += (Math.pow(16, j) * (Character.digit(pwd[i + j], 16)));
				 }
				 if(!realPwd.contains(sum)) {
					 realPwd.add(sum);
				 }
				 sum = 0;
				
			}
			Collections.sort(realPwd, Collections.reverseOrder());
			System.out.println("#" + tc + " " + realPwd.get(K-1));
		}
	}

    public static void reverseArray(char[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
