import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] di = {1, -1, 0, 0, 0, 0};
    static int[] dj = {0, 0, 1, -1, 0, 0};
    static int[] dk = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {


            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.next();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);
                    }
                }
            }


//        for (int i = 0; i < L; i++) {
//            for (int j = 0; j < R; j++) {
//                for (int k = 0; k < C; k++) {
//                    System.out.print(map[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }


            visited = new boolean[L][R][C];
            int ans = -1;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') {
                            ans = bfs(i, j, k);
                        }
                    }
                }
            }

            if (ans == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + ans + " minute(s).");
            }


        }
    }

    static int bfs(int x, int y, int z) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, z, 0});
        visited[x][y][z] = true;

        while (!q.isEmpty()) {
            var curr = q.poll();
            int nx = curr[0];
            int ny = curr[1];
            int nz = curr[2];
            int cnt = curr[3];


            if (map[nx][ny][nz] == 'E') {
                return cnt;
            }

            for (int i = 0; i < 6; i++) {
                int now_x = nx + di[i];
                int now_y = ny + dj[i];
                int now_z = nz + dk[i];

                if (check(now_x, now_y, now_z) && !visited[now_x][now_y][now_z]) {
                    q.add(new int[]{now_x, now_y, now_z, cnt + 1});
                    visited[now_x][now_y][now_z] = true;
                }

            }


        }
        return -1;


    }

    static boolean check(int x, int y, int z) {
        return x >= 0 && x < L && y >= 0 && y < R && z >= 0 && z < C && map[x][y][z] != '#';

    }


}
