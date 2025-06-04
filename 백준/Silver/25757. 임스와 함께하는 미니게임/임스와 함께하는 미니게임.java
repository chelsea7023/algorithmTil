import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String game =  sc.next();

        Set<String> players = new HashSet<>();
        for(int i = 0; i < N; i++){
            players.add(sc.next());
        }

        if(game.equals("Y")){
            System.out.println(players.size());
        } else if(game.equals("F")){
            System.out.println(players.size() / 2);
        } else{
            System.out.println(players.size() / 3);
        }
    }
}
