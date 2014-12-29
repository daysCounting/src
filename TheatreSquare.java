import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class TheatreSquare {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		BigDecimal x = new BigDecimal(number(a, c));
		BigDecimal y = new BigDecimal(number(b, c));
		
		System.out.println(x.multiply(y));

	}

	private static int number(int a, int c) {
		if (a % c == 0) {
			return a / c;
		} else {
			return a / c + 1;
		}
	}
}
