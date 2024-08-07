import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visitedCheck;

    static int[] di = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dj = {0, -1, 0, 1, 1, -1, 1, -1};

    /*

    8 7

    4 3 2 2 1 0 1

    3 3 3 2 1 0 1

    2 2 2 2 1 0 0

    2 1 1 1 1 0 0

    1 1 6 6 0 1 0

    0 0 0 1 1 1 0

    0 1 2 2 5 1 0

    0 1 1 1 2 1 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        visitedCheck = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && checkNum(i, j)) {
                    if (!visitedCheck[i][j] && checkBfs(i, j)) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
        }

        System.out.println(cnt);

        /*
        bfs로 생각을 하고 바로 문제로 접근
        문제는 여타의 bfs처럼 최단거리를 구하는것이 아니라 높은 곳에서 낮은 곳을 점령하는 느낌으로 접근
         */


    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;


        while (!q.isEmpty()) {
            var curr = q.poll();
            int now_x = curr[0];
            int now_y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = now_x + di[i];
                int ny = now_y + dj[i];

                if (check(nx, ny) && map[now_x][now_y] >= map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                }
            }
        }
    }

    static boolean checkBfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visitedCheck[x][y] = true;
        boolean flag = true;

        OUT:
        while (!q.isEmpty()) {
            var curr = q.poll();
            int now_x = curr[0];
            int now_y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = now_x + di[i];
                int ny = now_y + dj[i];

                if (check(nx, ny) && !visitedCheck[nx][ny] && map[now_x][now_y] == map[nx][ny]) {
                    visitedCheck[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                } else if (check(nx, ny) && map[now_x][now_y] < map[nx][ny]) {
                    flag = false;
                    break OUT;
                }
            }
        }
        return flag;

    }

    static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }


    static boolean checkNum(int x, int y) {

        boolean flag = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + di[i];
            int ny = y + dj[i];

            if (check(nx, ny) && map[nx][ny] > map[x][y]) {
                flag = false;
                break;
            }
        }

        return flag;
    }


}
