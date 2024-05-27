import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {

			int[] arr1 = new int[5];
			int[] arr2 = new int[5];
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr1[a]++;
			}

			st = new StringTokenizer(br.readLine());
			int num2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num2; j++) {
				int b = Integer.parseInt(st.nextToken());
				arr2[b]++;
			}

//			for(int j = 4; j >= 1; j--) {
//				if(arr1[j] != arr2[j]) {
//					if(arr1[j] > arr2[j]) {
//						System.out.println('A');
//						break;
//					}else {
//						System.out.println('B');
//						break;
//					}
//				}else {
//					continue;
//				}
//				System.out.println('D');
//			}

			if (arr1[4] != arr2[4]) {
				if (arr1[4] > arr2[4]) {
					System.out.println('A');
				} else {
					System.out.println('B');
				}
			} else {
				if (arr1[3] != arr2[3]) {
					if (arr1[3] > arr2[3]) {
						System.out.println('A');
					} else {
						System.out.println('B');
					}
				} else {
					if (arr1[2] != arr2[2]) {
						if (arr1[2] > arr2[2]) {
							System.out.println('A');
						} else {
							System.out.println('B');
						}
					} else {
						if (arr1[1] != arr2[1]) {
							if (arr1[1] > arr2[1]) {
								System.out.println('A');
							} else {
								System.out.println('B');
							}
						}
						else {
							System.out.println('D');
						}
					}
				}
			}
		}

	}

}
