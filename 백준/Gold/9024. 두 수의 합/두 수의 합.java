import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < t; tc++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            // 숫자 갯수
            int k = Integer.parseInt(st.nextToken());
            //가장 가까워야 하는 숫자

            int[] num = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);
            //배열 정렬까지 완료

            int left = 0;
            int right = num.length - 1;
            int cnt = 0;
            int min = Integer.MAX_VALUE;

            while (left < right) {
                int sum = num[left] + num[right];
                int diff = Math.abs(sum - k);

                if (diff < min) {
                    min = diff;
                    cnt = 1;
                } else if (diff == min) {
                    cnt++;

                }
                if (sum == k) {
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;

                } else if (sum > k) {
                    right--;
                }


            }
            StringBuilder sb = new StringBuilder();
            sb.append(cnt);
            System.out.println(sb);

        }
    }
}
