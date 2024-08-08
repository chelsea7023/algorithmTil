import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 가수의 수
        int M = sc.nextInt();
        // 보조 PD의 수

        int[] sequence = new int[N + 1];
        int[][] map = new int[N + 1][N + 1];


        for (int i = 0; i < M; i++) {
            int total = sc.nextInt();
            int[] arr = new int[total];

            for (int j = 0; j < total; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < arr.length - 1; j++) {
                map[arr[j]][arr[j + 1]] = 1;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < N + 1; j++) {
                if (map[j][i] == 1) {
                    cnt++;
                }
            }

            sequence[i] = cnt;
        }


//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < N + 1; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println(Arrays.toString(sequence));

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        boolean flag = true;


        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();

            list.add(curr);

            for (int i = 1; i < N + 1; i++) {
                if (map[curr][i] == 1) {
                    sequence[i]--;
                }
            }

            for (int i = 1; i < sequence.length; i++) {
                if (sequence[i] == 0 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                flag = false;
            }
        }

        if (flag) {
            for (int x : list) {
                System.out.println(x);
            }
        } else {
            System.out.println(0);
        }


    }
}
