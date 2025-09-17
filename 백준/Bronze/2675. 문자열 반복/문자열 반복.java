import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc = 0; tc < TC; tc++){
            int num = sc.nextInt();
            char[] arr = sc.next().toCharArray();

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < num; j++){
                    sb.append(arr[i]);
                }
            }

            System.out.println(sb);
        }
    }
}
