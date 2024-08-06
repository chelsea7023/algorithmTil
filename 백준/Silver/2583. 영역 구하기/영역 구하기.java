import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        // 세로 길이
        N = sc.nextInt();
        // 가로 길이
        int K = sc.nextInt();
        // 직사각형의 갯수

        /*
        하나의 큰 박스라고 생각하고 각 점들을 좌표로 넣는게 아니라 하나의 상자를 좌표로 생각한다.
        그런식으로 사각형이 존재하는 곳을 1로 채운다.
         */
        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            int c1 = sc.nextInt();
            int r1 = sc.nextInt();

            int c2 = sc.nextInt();
            int r2 = sc.nextInt();

            for (int j = r1; j < r2; j++) {
                for (int k = c1; k < c2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        visited = new boolean[M][N];

        int boxCount = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    boxCount++;
                    answer.add(bfs(i, j));


                }
            }
        }
        Collections.sort(answer);

        System.out.println(boxCount);
        for (int x : answer) {
            System.out.print(x + " ");
        }

        /*
        여기까지 입력이 다 되면 0을 기준으로 bfs를 돌리고 사각형의 갯수와 크기를 각각 기록
         */


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
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
        return cnt;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && map[x][y] == 0;
    }
}
