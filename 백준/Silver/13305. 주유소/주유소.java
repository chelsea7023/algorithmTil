import java.util.Scanner;

public class Main {

    /*
    최소 기름값으로 이동하는 방법을 찾으려고 한다.
    내가 현재 있는 도시의 기름값이 다름 도시의 기름값보다 비싸다면
    다음 도시로 갈 수 있는 최소한의 가름만 충전하면 된다.
    여기서 문제는 내가 있는 도시의 기름값이 다음도시보다 싸다면?
    그 다음 도시 그 다음 도시까지 체크를 해서 방법을 찾아야한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 도시 숫자

        int[] distances = new int[N - 1];
        for(int i = 0; i < distances.length; i++){
            distances[i] = sc.nextInt();
        }

        int[] costs = new int[N];
        for(int i = 0; i < costs.length; i++){
            costs[i] = sc.nextInt();
        }

        long totalCost = 0;
        int minPrice = costs[0];

        for(int i = 0; i < N - 1; i++){
            if(costs[i] < minPrice){
                minPrice = costs[i];
            }

            totalCost += (long) minPrice * distances[i];
        }

        System.out.println(totalCost);







    }
}
