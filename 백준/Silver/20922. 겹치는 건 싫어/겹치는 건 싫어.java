import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // 숫자의 갯수
        int K = Integer.parseInt(st.nextToken());
        // 한 수열에 있을 수 있는 같은 숫자 최대의 갯수


        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }



        System.out.println(twoPointer(arr, K, max));





    }

    static int twoPointer (int[] arr, int K, int max){
        int maxLength = 0;
        int start = 0;

        // 갯수 확인용
        int[] check = new int[max + 1];

        for(int end = 0; end < arr.length; end++){

            check[arr[end]] ++; // 방금 나온 수의 갯수를 업데이트 해준다

            while(check[arr[end]] > K){
                /*
                여기서는 기준이 되는 K의 값을 초과하는 순간부터 K이하가 될 때까지 start 늘려서 땡겨주는 것
                그렇게 해서 기준이 맞춰지면 원래의 for문을 다시 실행해서 원래대로의 로직 정상 작동
                 */
                check[arr[start]]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
