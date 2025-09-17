import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char ch = 'a';
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i = 0; i < str.length(); i++){
            int tmp = Math.abs(ch - str.charAt(i));

            if(arr[tmp] == -1){
                arr[tmp] = i;
            }
        }

        for(int x : arr){
            System.out.print(x + " ");
        }

        // 알파벳이 포함되어 있으면 위치를
    }
}
