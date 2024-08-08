import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sequence = new int[N + 1];

        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            map[A][B] = 1;
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

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (sequence[i] == 0) {
                q.add(new int[]{i, 1});
                visited[i] = true;
                ans.add(new int[]{i, 1});
            }
        }

        while (!q.isEmpty()) {
            var curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 1; i < N + 1; i++) {
                if (map[x][i] == 1) {
                    sequence[i]--;
                }
            }

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && sequence[i] == 0) {
                    q.add(new int[]{i, y + 1});
                    visited[i] = true;
                    ans.add(new int[]{i, y + 1});
                }
            }

        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] x : ans) {
            System.out.print(x[1] + " ");
        }


    }
}
