import java.util.*;

public class Main {
    public static void main(String[] args) {

        class Size {
            int kg;
            int cm;

            public Size(int kg, int cm) {
                this.kg = kg;
                this.cm = cm;
            }
        }

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Size[] people = new Size[N];

        for(int i = 0; i < people.length; i++){
            people[i] = new Size(sc.nextInt(), sc.nextInt());
        }

        int[] ranks = new int[N];
        Arrays.fill(ranks, 1);


        for(int i = 0; i < people.length; i++){
            for(int j = 0; j < people.length; j++){
                if(i == j) continue;

                if(people[i].cm < people[j].cm &&  people[i].kg < people[j].kg){
                    ranks[i]++;
                }
            }

        }

        for(int ans : ranks){
            System.out.print(ans + " ");
        }

    }
}
