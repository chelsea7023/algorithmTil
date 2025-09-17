import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            int tmp = sc.nextInt();

            if(tmp > max){
                max = tmp;
            }

            if(tmp < min){
                min = tmp;
            }
        }

        System.out.println(min   + " " + max);
    }
}
