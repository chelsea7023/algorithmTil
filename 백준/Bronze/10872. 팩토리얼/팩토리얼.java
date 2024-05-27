
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(function(sc.nextInt()));
		
	}
	
	public static int function(int n) {
		if(n == 0) {
			return 1;
		}
		
		return n * function(n-1);
	}
}