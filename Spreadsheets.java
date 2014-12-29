import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;
/***
 * 
 * @author daysCounting
 *
 */
public class Spreadsheets {
	public static void RcDecode(char[] a) {
		int i = 1;
		int row = 0;
		int column = 0;
		String temp = "";
		while (a[i] != 'C' && i < a.length) {
			row = row * 10 + (a[i++] - 48);
		}
		i++;
		while (i < a.length) {
			column = column * 10 + (a[i++] - 48);
		}
		while (column != 0) {
			temp = (char) (column % 26 == 0 ? 'Z' : column % 26 + 'A' - 1)
					+ temp;
			if (column % 26 == 0) {
				column = column / 26 - 1;
			} else {
				column = column / 26;
			}
		}
		System.out.println(temp + row);
	}

	public static void ANDecode(char[] a) {

		int row = 0;
		int column = 0;
		int i = 0;
		while (a[i] > '9' && i < a.length) {
			column = column * 26 + (a[i++] - 'A' + 1);
		}
		while (i < a.length) {
			row = row * 10 + (a[i++] - '0');
		}
		System.out.println("R" + row + "C" + column);

	}

	public static boolean testRC(char[] a) {
		for (int i = 2; i < a.length; i++) {
			if (a[i] > '9' || a[i] < '0' || a[i] == 'C') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt();
		String b, c;
		for (int i = 0; i < a; i++) {
			b = in.next();

			char[] b1 = b.toCharArray();

			if (b1[0] == 'R' && '0' <= b1[1] && b1[1] <= '9') {
				if (testRC(b1)) {
					RcDecode(b1);
				} else {
					ANDecode(b1);
				}

			} else {
				ANDecode(b1);
			}
		}

		in.close();
	}
}
