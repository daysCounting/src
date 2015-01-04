import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AncientBerlandCircus {
	private float x;
	private float y;

	public AncientBerlandCircus(float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		List<AncientBerlandCircus> list = new ArrayList<AncientBerlandCircus>();
		float line[] = new float[3];
		for (int i = 0; i < 3; i++) {
			float one = in.nextFloat();
			float two = in.nextFloat();
			AncientBerlandCircus x = new AncientBerlandCircus(one, two);
			list.add(x);
		}

		for (int i = 0; i < 3; i++) {
			if (i != 2) {
				line[i] = getLine(list.get(i), list.get(i + 1));
			} else {
				line[i] = getLine(list.get(i), list.get(0));
			}
			System.out.println(line[i]);
		}
		
	}

	static float getLine(AncientBerlandCircus a, AncientBerlandCircus b) {
		float x = (float) Math.sqrt(Math.pow((a.x - b.x), 2)
				+ Math.pow((a.y - b.y), 2));
		return x;
	}

}
