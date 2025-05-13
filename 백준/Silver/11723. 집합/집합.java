import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int bitSet = 0;


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                bitSet |= (1 << (x - 1));
            } else if(order.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                bitSet &= ~(1 << (x - 1));
            } else if(order.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                sb.append((bitSet & (1 << (x - 1))) != 0 ? "1\n"  : "0\n");
            } else if (order.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                bitSet ^= (1 << (x - 1));
            } else if (order.equals("all")){
                bitSet = ((1 << 20) - 1);
            } else {
                bitSet = 0;
            }
        }

        System.out.println(sb);

        
    }
}
