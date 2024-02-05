package swea_8931;

import java.util.Scanner;
import java.util.Stack;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			// stack 선언
			Stack<Integer> stack = new Stack<>();
			
			int K = sc.nextInt();
			
			int sum = 0;
			
			int sum2 = 0;
			
			for(int i = 0; i < K; i++) {
				int n = sc.nextInt();
				if(n == 0) {
					// pop한 값들의 합산을 위해 poppedValue 선언후 sum2로 합산
					int poppedValue = stack.pop();

					sum2 += poppedValue;
							
				}else {
					// push된 값들의 총합을 구하기 위한 sum의 값
					stack.push(n);
					
					sum += n;
				}
			}
			System.out.println("#" + test_case + " " + (sum-sum2));
			

		}
	}
}