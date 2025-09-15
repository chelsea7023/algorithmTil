import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();

        int cnt = 0;
        int tmp = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                tmp = 0;
            } else{
                if(tmp == 0){
                    cnt++;
                    tmp++;
                } else{
                    tmp++;
                }
            }
        }

        System.out.println(cnt);
    }
}
