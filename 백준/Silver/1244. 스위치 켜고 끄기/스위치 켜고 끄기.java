import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();
        // 학생 수

        for (int i = 0; i < num; i++) {

            int gender = sc.nextInt();
            int tmp = sc.nextInt();

            if (gender == 1) {
                // 남자면 숫자의 배수만 반대 숫자로 바꿔주기

                for (int j = tmp; j <= N; j += tmp) {
                    if (arr[j] == 1) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }

            } else {
                // 여자면 숫자를 기준으로 그 숫자 포함 좌우 대칭일 경우 반대 숫자로 바꿔주기

                // 여학생 로직 수정
                int left = tmp - 1;
                int right = tmp + 1;

                while (left >= 1 && right <= N && arr[left] == arr[right]) {
                    left--;
                    right++;
                }

// 최종 대칭 범위: left+1 ~ right-1
                for (int j = left + 1; j <= right - 1; j++) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }



            }


        }

        for (int i = 1; i < arr.length; i++) {


            System.out.print(arr[i] + " ");

            if (i % 20 == 0) {
                System.out.println();
            }


        }


    }
}
