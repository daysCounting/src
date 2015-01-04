import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/***
 * 
 * @author NSX
 * @see �������������и���ʱ���÷�����Ч�� ���޸�
 * @see  �ڶ����޸ģ�����Ϊat least at the points first .  ����Ҫ��¼֮ǰ��score. ��ϸ������winner2
 *
 */
public class Winner {
	public static String Winner;
	public static int maxNum = -10000;
	public static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> aMap = new Hashtable<String, Integer>();
		String name = null;
		int score = 0;
		int a = in.nextInt();
		for (int i = 0; i < a; i++) {
			name = in.next();
			score = in.nextInt();
			// System.out.println(name + " " + aMap.containsKey(name));
			if (!aMap.containsKey(name)) {
				put(aMap, name, score);
			} else {
				score = score + aMap.get(name);
				// System.out.println("get"+name + " value: " + aMap.get(name));
				put(aMap, name, score);
			}
		}
		if (list.size() != 0)
			System.out.println(list.get(0));
		System.out.println(aMap.toString());
	}

	static void put(Map<String, Integer> a, String b, int c) {
		// System.out.println(b+"  "+c);
		if (a.containsKey(b) && c != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(b)) {
					list.remove(i);
				}
			}
		}
		if (c > 0 && list.size() != 0) {
			for (int i = list.size() - 1; i > -1; i--) {
				if (a.get(list.get(i)) >= c) {
					list.add(i + 1, b);
					break;
				} else {
					if (i == 0) {
						list.add(0, b);
					}
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (a.get(list.get(i)) <= c) {
					list.add(i, b);
					break;
				}
			}
		}
		if (list.size() == 0) {
			list.add(b);
		}
		a.put(b, c);

	}
}
