package swea_4047_영준이의카드카운팅;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			// 일단 문자열로 입력을 받고 배영롤 만든다
			char[]card = str.toCharArray();
			
			List<Integer> cardS = new ArrayList<>();
			List<Integer> cardD = new ArrayList<>();
			List<Integer> cardH = new ArrayList<>();
			List<Integer> cardC = new ArrayList<>();
			
			boolean success = true;
			
			for(int i = 0; i < card.length; i++) {
				if(card[i] == 'S') {
					int num = card[i+1] * 10 +  card[i + 2];
					if(!cardS.contains(num)) {
						cardS.add(num);
					}else {
						success = false;
						break;
					}
				}
				if(card[i] == 'D') {
					int num = card[i+1] * 10 +  card[i + 2];
					if(!cardD.contains(num)) {
						cardD.add(num);
					}else {
						success = false;
						break;

					}
				}
				if(card[i] == 'H') {
					int num = card[i+1] * 10 +  card[i + 2];
					if(!cardH.contains(num)) {
						cardH.add(num);
					}else {
						success = false;
						break;
					}
				}
				if(card[i] == 'C') {
					int num = card[i+1] * 10 +  card[i + 2];
					if(!cardC.contains(num)) {
						cardC.add(num);
					}else {
						success = false;
						break;
					}
				}
			}
			if(success) {
			System.out.println("#" + tc + " " + (13 - cardS.size()) + " " + (13 - cardD.size()) + " " +  (13 - cardH.size())  + " " +  (13 - cardC.size())  );
			}else {
				System.out.println("#" + tc + " " + "ERROR");
			}
		}
	}
}
