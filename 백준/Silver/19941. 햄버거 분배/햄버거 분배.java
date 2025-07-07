import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //햄버거 길이
        int K = sc.nextInt(); //사람과 햄버거의 거리

        /*
        햄버거를 기준으로 가장 멀리 있는 사람한테 일단 먹혀야 하나..?
         */

        int cnt = 0;

        char[] arr = sc.next().toCharArray();

        boolean[] visited = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P'){
                for(int j = i - K; j <= i + K; j++) {
                    if(j >= 0 && j < arr.length){
                        if(arr[j] == 'H' && !visited[j]){
                            cnt++;
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
