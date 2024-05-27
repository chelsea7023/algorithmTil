import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/* 
 * '<'를 만나면, 만약 그 전까지 저장되어 있는 stack이 있을 경우에 
 * stack.pop으로 역순으로 붙여준다. 그리고 flag를 true로 바꿔서
 * 원래 순서대로 StringBuffer에 붙게 해준다.
 * 만약에 '>'를 만나면, '>'까지는 붙여주고 flag를 false로 바꿔준다.
 * 여기에서 문제점은 만약 빈칸 ' '을 만나는 경우인데, 이 경우에는 '<'를 만났을 때와 
 * 마찬가지로 stack에 쌓아 두었던 것들을 붙여주고 ' '빈칼까지 출력해준다.
 * 그리고 빈칸이 아닌 경우에는 계속해서 stack에 push 해준다.
 */


public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 결과를 출력해줄 StringBuilder선언
		StringBuilder sb = new StringBuilder();
		
		// < > 를 판단해줄 flag 선언
		boolean flag = false;
		
		// 문자들을 거꾸로 출력해주기 위해 FILO구조인 Stack활용
		Stack <Character> stack = new Stack<>();
		
		//본격적으로 문자열을 돌며 sb에 붙여주기
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				flag = true;
			}else if(str.charAt(i) == '>') {
				flag = false;
				sb.append(str.charAt(i));
				continue;
			}
			
			if(flag) {
				sb.append(str.charAt(i));
			}
			else if(!flag) {
				if(str.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(str.charAt(i));
				}else {
					stack.push(str.charAt(i));
				}
			}
			/*
			 * 마지막 경우에 출력이 되지 않는 경우를 상정해보니
			 * 꺽새도 없고 ' ' 빈칸도 없는 경우 마지막 문자열이 stack에만 담기고 출력이 되지 않는 현상 발생
			 * 그래서 i 가 마지막인자일 때 stack에 남은 것들을 모두 뽑아서 출력하는 것까지 추가 구현
			 */
			
			if(i == str.length() - 1) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
		}
		System.out.println(sb);
		
	
	}
}
