package BOJ_1181_단어정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<String> words = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (!words.contains(str)) {
				words.add(str);
			}
		}

		Collections.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return Integer.compare(o1.length(), o2.length());
				} else {
					return o1.compareTo(o2);
				}
			}

		});

		for (String str : words) {
			System.out.println(str);
		}
	}
}
