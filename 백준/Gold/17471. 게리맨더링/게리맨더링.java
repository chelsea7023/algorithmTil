import java.util.*;

public class Main {

    static List<List<Integer>> list;
    static List<Integer> num;
    static boolean check;
    static int N;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();// 구역의 갯수

        int[] arr = new int[N]; // 구역 인구수
        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            maxSum += arr[i];
        }

        num = new ArrayList<>(); // 구역 번호
        for (int i = 0; i < N; i++) {
            num.add(i + 1);
        }
        // 구역별 인구 수

        map = new int[N + 1][N + 1]; // 구역별 연결 여부 확인용 2차원 배열
        for (int i = 1; i <= N; i++) {
            int start = sc.nextInt();
            for (int j = 0; j < start; j++) {
                int end = sc.nextInt();
                map[i][end] = map[end][i] = map[i][i] = 1;
            }
        }

        list = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for (int i = 1; i < N; i++) {
            combi(num, visited, 0, 0, i);
        }
//        for (List<Integer> x : list) {
//            System.out.println(x);
//        }

        /*
        숫자들의 조합에 따른 연결 여부 확인
        만약 연결이 된게 맞다면
        인구 수 비교
         */
        check = false;
        // 선거구를 나눌 수 있는지 없는지 전체 여부
        // 단 한번의 조합으로라도 나눌 수 없다면 -1 출력
        // 한번이라도 두 선거구로 나눌 수 있는 조합이 나온다면 최솟값 출력
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < list.size(); i++) {

            List<Integer> tmp = new ArrayList<>(num);
            tmp.removeAll(list.get(i));

            if (bfs(list.get(i)) && bfs(tmp)) {
                check = true;
                int sum = 0;
                for (int j = 0; j < list.get(i).size(); j++) {
                    sum += arr[list.get(i).get(j) - 1];
                }

                int sum2 = maxSum - sum;

//                System.out.println(sum + " " + sum2);

                if (Math.abs(sum2 - sum) < min) {
                    min = Math.abs(sum2 - sum);
                }

            }
        }

        if (check) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }


    }

    static void combi(List<Integer> arr, boolean[] visited, int start, int end, int r) {
        if (end == r) {
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) {
                    li.add(arr.get(i));
                }
            }
            list.add(li);
        }

        for (int i = start; i < arr.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(arr, visited, i + 1, end + 1, r);
                visited[i] = false;

            }
        }
    }

    static boolean bfs(List<Integer> li) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[li.get(0)] = true;
        queue.add(li.get(0));

        int count = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[node][i] == 1 && !visited[i] && li.contains(i)) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }

        return count == li.size();
    }



}
