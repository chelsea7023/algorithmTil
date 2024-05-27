import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] cost = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		Arrays.sort(cost);

		st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		// 이 최대값을 넘으면 안된다.

		if (sum <= total) {
			System.out.println(cost[N - 1]);
		} else {
			bs(cost, total);
			System.out.println(ans);
		}

	}

	static void bs(int[] arr, int x) {
		int start = 0;
		int end = arr[arr.length - 1];
		int mid = 0;
		int sum = 0;

		while (start < end) {
			mid = (start + end) / 2;
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= mid) {
					sum += arr[i];
				} else {
					sum += mid;
				}
			}
			if (sum > x) {
				end--;
			} else if (sum < x) {
				start++;
			} else {
				break;
			}

//			System.out.println(start + " " + end + " " + mid + " " + sum);
		}

		ans = mid;

//		if (sum == x) {
//			ans = mid;
//		} else if (sum > x) {
//			ans = start - 1;
//		} else {
//			ans = mid;
//		}

	}
}
