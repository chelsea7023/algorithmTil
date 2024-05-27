import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도감 수
		int M = sc.nextInt(); // 문제 수

		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			map.put(i, str);
			map2.put(str, i);
		}

		for (int i = 0; i < M; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			if (arr[0] < 'A') {
				String ans = map.get(Integer.parseInt(str));
				System.out.println(ans);
			} else {
				int num = map2.get(str);
				System.out.println(num);
			}
		}

	}

}
