import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Shark implements Comparable<Shark> {
        int s;
        int d;
        int z;
        int t;

        public Shark(int s, int d, int z, int t) {
            this.s = s;
            this.d = d;
            this.z = z;
            this.t = t;
        }

        @Override
        public int compareTo(Shark shark) {
            if (this.t == shark.t) {
                return shark.z - this.z;
            } else {
                return this.t - shark.t;
            }
        }

    }

    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        int N = sc.nextInt();
        int answer = 0;

        PriorityQueue<Shark>[][] map = new PriorityQueue[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = new PriorityQueue<>();
            }
        }


        for (int i = 0; i < N; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();

            map[r][c].add(new Shark(s, d, z, 0));
        }

        int cnt = 0;

        while (cnt < C) {

            for (int i = 0; i < R; i++) {
                if (!map[i][cnt].isEmpty()) {
                    int num = map[i][cnt].poll().z;
                    answer += num;
                    break;
                }
            }

            PriorityQueue<Shark>[][] newMap = new PriorityQueue[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    newMap[i][j] = new PriorityQueue<>();
                }
            }


            // 상어의 이동
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!map[i][j].isEmpty()) {
                        Shark nowShark = map[i][j].poll();
                        int r = i;
                        int c = j;
                        // 현재 위치
                        int d = nowShark.d;
                        int s = nowShark.s;
                        // 방향과 속력
                        int z = nowShark.z;
                        int t = nowShark.t + 1;

                        if (d == 1 || d == 2) {
                            int[] arr = moveShark(r, d, s);
                            r = arr[0];
                            d = arr[1];
                        } else {
                            int[] arr = moveShark(c, d, s);
                            c = arr[0];
                            d = arr[1];
                        }

                        Shark newShark = new Shark(s, d, z, t);

                        if (newMap[r][c].isEmpty() || newMap[r][c].peek().z < z) {
                            newMap[r][c].clear();
                            newMap[r][c].add(newShark);
                        }

                    }
                }
            }

            map = newMap;
            cnt++;
        }

        System.out.println(answer);
    }

    // 이동 최적화된 moveShark 함수
    static int[] moveShark(int start, int d, int s) {

        int limit = (d == 1 || d == 2) ? R : C;

        s = s % (2 * (limit - 1));

        for (int i = 0; i < s; i++) {
            if (d == 1 && start == 0) d = 2;
            else if (d == 2 && start == limit - 1) d = 1;
            else if (d == 3 && start == limit - 1) d = 4;
            else if (d == 4 && start == 0) d = 3;

            start += (d == 1 || d == 4) ? -1 : 1;
        }

        return new int[]{start, d};

    }

}