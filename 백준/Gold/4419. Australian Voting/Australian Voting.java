import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 총 후보자 수
		int n = Integer.parseInt(br.readLine());
		String[] names = new String[n];
		
		// (인덱스, 이름)넣기
		for (int i=0; i<n; i++) {
			names[i] = br.readLine();
		}
		
		int[][] votes = new int[1000][n]; // 각 인원의 투표를 담는다.
		
		int person = 0;	// 투표한 사람의 수
		String line ="";
		while ((line = br.readLine()) != null && line.length() != 0) {
			StringTokenizer st = new StringTokenizer(line);
			for (int i=0; i<n; i++) {
				votes[person][i] = Integer.parseInt(st.nextToken()) - 1;
			}
			person++;
		}

		int[] leave = new int[n]; 			// 후보자별 탈락 여부 확인
		int[] person_vote = new int[person];// 투표자별 현재 개표하는 표의 인덱스
		
		int left = n; // 현재 남아 있는 후보자 수
		
		int max_idx = -1; // 투표율 50% 이상의 후보자 인덱스
		voting: 
			while (left > 1) { // 후보자가 1명이 남을때 까지 실행
			
			int[] vote_cnt = new int[n]; 		// 후보자별 투표권 수

			// 각 인원의 투표 개수 카운트
			for (int i=0; i<person; i++) {
				while(leave[votes[i][person_vote[i]]] == 1) {
					person_vote[i]++;
				}
				vote_cnt[votes[i][person_vote[i]]]++;
			}
			
			int min_vote = 1001;	// 최소 투표수
			List<Integer> now_leave = new ArrayList<>(); // 현재 탈락자 명단
			for (int i = 0; i<n; i++) {
				// 탈락하지 않은 후자인 경우
				if(leave[i] == 0) {
					// 득표 1등이 50%이상일 때 종료
					int percent = (vote_cnt[i]*100) / person;
					if(percent >= 50 && left != 2) {
						max_idx = i;
						break voting;
					}
					// 최소 투표수 초기화, 현재 탈락자 명단 갱신
					if (min_vote > vote_cnt[i]) {
						now_leave = new ArrayList<>();
						now_leave.add(i);
						min_vote = vote_cnt[i];						
					} else if (min_vote == vote_cnt[i]) {
						now_leave.add(i);
					}
				}
			}
			
			// 현재 탈락자 후보가 남은 인원수와 같다면 (동률)
			if (now_leave.size() == left) {
				break voting;
			} else {
				// 현재 탈락자들 탈락으로 갱신
				for (int i : now_leave) {
					leave[i] = 1;
				}
			}
			// 남은 탈락자 수 갱신
			left -= now_leave.size();
		}
		
		// 50% 득표수가 넘은 인원이 나왔으면
		if (max_idx != -1) {
			System.out.println(names[max_idx]);
		} else {
			// 탈락하지 않은 후보들 출력
			for (int i=0; i<n; i++) {
				if(leave[i] == 0) {					
					System.out.println(names[i]);
				}
			}
		}
	}
}
