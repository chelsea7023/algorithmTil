import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n][m];

        int artCount = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    artCount++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(artCount);
        System.out.println(max);
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            var curr = q.poll();
            int now_x = curr[0];
            int now_y = curr[1];

            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = now_x + di[i];
                int ny = now_y + dj[i];

                if (check(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

            }
        }
        return cnt;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 1;
    }
}
