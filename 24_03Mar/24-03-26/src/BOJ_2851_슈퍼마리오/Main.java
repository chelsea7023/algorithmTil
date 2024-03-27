package BOJ_2851_슈퍼마리오;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			sum += sc.nextInt();
			list.add(sum);
		}

		Collections.sort(list);
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) <= 100 && max < list.get(i)) {
				max = list.get(i);
			}
			if(list.get(i) > 100 && min > list.get(i)) {
				min = list.get(i);
			}
		}
		if(100 - max == min - 100) {
			System.out.println(min);
		}else if(100 - max > min - 100) {
			System.out.println(min);
		}else if(100 - max < min - 100) {
			System.out.println(max);
		}
		
	}

}
