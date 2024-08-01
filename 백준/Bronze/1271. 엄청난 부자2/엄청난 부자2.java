import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String A = sc.next();
        String B = sc.next();

        BigInteger num1 = new BigInteger(A);
        BigInteger num2 = new BigInteger(B);

        System.out.println(num1.divide(num2));
        System.out.println(num1.subtract(num2.multiply(num1.divide(num2))));
    }
}
