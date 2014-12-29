import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BS {

	private static void Tx(int t, List x) {
		if (!x.isEmpty() && x.contains(t)) {
			System.out.print(')');
		}
	}

	private static void Ty(int t, List y) {
		if (!y.isEmpty() && y.contains(t)) {
			System.out.print('(');
		}
	}

	private static void Tz(int t, List z) {
		if (!z.isEmpty() && z.contains(t)) {
			System.out.print(']');
		}
	}

	private static void Ts(int t, List s) {
		if (!s.isEmpty() && s.contains(t)) {
			System.out.print('[');
		}
	}

	public static void main(String[] args) {
		// / ‰»Î¿®∫≈ ˝◊È
		int flag1 = -1;
		int flag2 = -1;
		int i = 0;
		String b;
		char[] a = null;
		Scanner in = new Scanner(System.in);
		b = in.nextLine();
		b.replaceAll(" ", "");
		b.replaceAll(",", "");
		a = b.toCharArray();
		boolean c[] = new boolean[a.length];
		for (int j = 0; j < a.length; j++) {
			c[j] = true;
			// System.out.println(a[j]);
		}
		// /∆•≈‰
		List x = new ArrayList();
		List y = new ArrayList();
		List z = new ArrayList();
		List s = new ArrayList();
		for (int j = 0; j < a.length; j++) {
			if (a[j] == '(') {
				x.add(j);
				continue;
			}

			if (a[j] == ')') {
				if (x.isEmpty()) {
					y.add(j);
					continue;
				} else {
					for (int k = x.size() - 1; k > -1; k--) {
						if (c[(Integer) x.get(k)]) {

							for (int h = (Integer) x.get(k); h <= j; h++) {
								c[h] = false;
							}
							x.remove(k);
							break;
						} else {
							if (k == 0)
								y.add(j);

						}
						continue;
					}
				}
			}

			if (a[j] == '[') {
				z.add(j);
				continue;
			}

			if (a[j] == ']') {
				if (z.isEmpty()) {
					s.add(j);
					continue;
				} else {

					for (int k = z.size() - 1; k > -1; k--) {
						if (c[(Integer) z.get(k)]) {
							for (int h = (Integer) z.get(k); h <= j; h++) {
								c[h] = false;
							}
							z.remove(k);
							break;
						} else {
							if (k == 0)
								s.add(j);
						}
					}
					continue;
				}
			}
		}
//		System.out.println(x.size() + " " + y.size() + " " + z.size() + " "
//				+ s.size());
		for (int j = 0; j < a.length; j++) {
			if (a[j] == '(' || a[j] == ')' || a[j] == '[' || a[j] == ']') {
				Ty(j, y);
				Ts(j, s);
				System.out.print(a[j]);
				Tx(j, x);
				Tz(j, z);
			}
		}

	}
}
