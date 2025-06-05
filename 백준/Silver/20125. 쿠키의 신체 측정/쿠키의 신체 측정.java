import java.util.Scanner;

public class Main {

    static int[] heart =  new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int rightArm = 0, leftArm = 0, rightLeg = 0, leftLeg = 0, height = 0;

        char[][] board = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = sc.next();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j);
            }
        }

        findHeart(board);

        int tmp = 1;

        // 왼팔
        while(true){
            if(check(heart[0], heart[1] - tmp, N) && board[heart[0]][heart[1] - tmp] == '*'){
                leftArm++;
                tmp++;
            } else{
                break;
            }
        }

        tmp = 1;

        // 오른팔
        while(true){
            if(check(heart[0], heart[1] + tmp, N) && board[heart[0]][heart[1] + tmp] == '*'){
                rightArm++;
                tmp++;
            } else break;

        }

        // 허리
        tmp = 1;
        int[] end = new int[2];
        while(true){
            if(check(heart[0] + tmp, heart[1], N) && board[heart[0] + tmp][heart[1]] == '*'){
                height++;
                tmp++;
            } else {
                end[0] = heart[0] + tmp - 1;
                end[1] = heart[1];
                break;
            }
        }

        // 왼쪽다리
        tmp = 1;
        while(true){
            if(check(end[0] + tmp, end[1] - 1, N) && board[end[0] + tmp][end[1] - 1] == '*'){
                leftLeg++;
                tmp++;
            } else break;
        }

        // 오른쪽 다리
        tmp = 1;
        while(true){
            if(check(end[0] + tmp, end[1] + 1, N) &&  board[end[0] + tmp][end[1] + 1] == '*'){
                rightLeg++;
                tmp++;
            } else break;
        }
        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(leftArm + " " + rightArm + " " + height + " " + leftLeg + " " + rightLeg);
    }

    static boolean check(int x, int y, int N){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void findHeart(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*'){
                    heart[0] = i + 1;
                    heart[1] = j;
                    return;
                }
            }
        }

    }
}
