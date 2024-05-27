import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
 * 내가 생각한 접근 방식은 큰 사각형에서 작은 사각형의 넓이를 뺀 값에다가 참되 갯수를 곱하는 것.
 * 
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 1당 참회밭 갯수 
		int maxRow = 0;
		int maxCol = 0;
		int [] dirArr = new int[6];
		int [] lineArr = new int[6];
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			dirArr[i] = dir;
			int line = Integer.parseInt(st.nextToken());
			lineArr[i] = line;
			if(dir == 4 || dir == 3) {
				if(maxRow < line) {
					maxRow = line;
				}
			}else if(dir == 1 || dir == 2){
				if(maxCol < line) {
					maxCol = line;
				}
			}
		}
		int max = maxRow * maxCol;
		int min = 0;
		int a = 0; 
		
		for(int i = 0; i < 6; i++) {
			if(i == 0 && dirArr[0] == dirArr[2] && dirArr[1] != dirArr[3]) {
				min = lineArr[0] * lineArr[1];
				break;
			}
			if(i + 2 >= 6) {
				a = i - 4;
			}else {
				a = i + 2;
			}
			if(dirArr[a] == dirArr[i]) {
				min = lineArr[i + 1] * lineArr[a];
				break;
			}
		}
		System.out.println(N*(max - min));
	}

}
