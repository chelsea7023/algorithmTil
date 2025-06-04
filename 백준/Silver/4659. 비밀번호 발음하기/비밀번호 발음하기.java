import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){

            String word = sc.next();

            if(word.equals("end")) break;

            if(!check1(word)){
                System.out.println("<" + word + ">" + " " + "is" + " " + "not acceptable.");
                continue;
            }

            if(!check2(word)){
                System.out.println("<" + word + ">" + " " + "is" + " " + "not acceptable.");
                continue;
            }

            if(!check3(word)){
                System.out.println("<" + word + ">" + " " + "is" + " " + "not acceptable.");
                continue;
            }

            System.out.println("<" + word + ">" + " " + "is" + " " + "acceptable.");




        }




    }

    static boolean check1 (String str){
        // 아에이오우 포함 하는지 여부 확인
        boolean flag = false;
        if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")){
            flag = true;
        }
        return flag;
    }

    static boolean check2(String str){
        // 모음 또는 자음 3개 연속 불가
        boolean flag = true;
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
                count2 = 0;
            } else{
                count2++;
                count = 0;
            }

            if(count >= 3 || count2 >= 3){
                flag = false;
                break;
            }

        }
        return flag;

    }

    static boolean check3(String str){
        // 같은 글자가 2번 연속이면 안되는데 ee랑 oo는 된다.

        boolean flag = true;

        for(int i = 0; i < str.length() - 1; i++){

            if(str.charAt(i) == str.charAt(i + 1)){
                String tmp = "" + str.charAt(i) + str.charAt(i + 1);
                if(!tmp.equals("ee") && !tmp.equals("oo")){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
