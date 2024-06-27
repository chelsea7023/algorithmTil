import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i] % 42);
		}

		HashSet<Integer> set = new HashSet<>(list);

		System.out.println(set.size());

	}
}
