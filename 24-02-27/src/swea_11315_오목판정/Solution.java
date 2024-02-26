package swea_11315_오목판정;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[][] omok = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    omok[i][j] = str.charAt(j);
                }
            }

            // 순회하면서 돌이 오목이 되는지 아닌지 확인
            boolean success = false;
            int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (omok[i][j] == 'o') {
                        for (int k = 0; k < 8; k++) {
                            int cnt = 0;
                            int ni = i;
                            int nj = j;
                            while (ni >= 0 && ni < N && nj >= 0 && nj < N && omok[ni][nj] == 'o') {
                                cnt++;
                                ni += di[k];
                                nj += dj[k];
                            }
                            if (cnt >= 5) {
                                success = true;
                                break;
                            }
                        }
                        
                    }
                }
                
            }

            if (success) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
