import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int seq = -1;

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            if(max < tmp){
                max = tmp;
                seq = i + 1;
            }

        }

        System.out.println(max);
        System.out.println(seq);

    }
}
