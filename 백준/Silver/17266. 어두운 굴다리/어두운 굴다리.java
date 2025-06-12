import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 다리 길이

        int cnt = sc.nextInt();
        int[] lamp = new int[cnt];

        for(int i = 0; i < lamp.length; i++){
            lamp[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i = lamp.length - 1; i > 0; i--){
            int num = lamp[i] - lamp[i - 1];
            if(max < num){
                max = num;
            }
        }

        int start = lamp[0];
        int end = N - lamp[cnt - 1];

        System.out.println(Integer.max(Integer.max(start, end), (max + 1) / 2));

    }
}
