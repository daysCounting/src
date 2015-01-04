import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/***
 * 
 * @author NSX
 * @serial 采用对象记录法，由于理解正确，方法比较简单有效。
 */

public class Winner2 {
	public static void main(String[] args) {
		String name;
		int score;
		play play1;
		int size = 0 ;
		int maxEndPoint = -1001;
		int firstSite = -1; 
		String Winner =null;
		List<play> plays = new ArrayList<play>();
		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();
		for (int i = 0; i < lines; i++) {
			play1 = new play();
			name = in.next();
			score = in.nextInt();
			if (plays.size() == 0) {
				plays.add(new play(name, score, i));
			} else {
				for (int j = 0; j < plays.size(); j++){
					if(plays.get(j).name.equals(name)){
						play1 = plays.get(j);
						size = play1.size;
						play1.scores[size] = play1.scores[size-1] +score;
						play1.num[size] = i;
						play1.size ++;
						break;
					}

					if (j ==plays.size()-1) {
						plays.add(new play(name,score, i));
						break;
					}
					
				}
			}

		}
		for (play play : plays) {
			//System.out.println(play.name + " " +play.PrintLastPoints() +" " +play.firstPointNum());
			if(play.PrintLastPoints()>maxEndPoint){
				maxEndPoint = play.PrintLastPoints();
				firstSite = play.firstPointNum();
				Winner =play.name;
			}else if(play.PrintLastPoints()==maxEndPoint && play.firstPointNum()<firstSite){
				firstSite =play.firstPointNum();
				Winner =play.name;
			}
		}
		
		System.out.println(Winner);
	}
}
class play {
	public String name;
	public int size;
	public int scores[] = new int[1000];
	public int num[] = new int[1000];

	public play() {
		// TODO Auto-generated constructor stub
	}

	public play(String a, int b, int i) {
		// TODO Auto-generated constructor stub
		size = 0;
		num[size] = i;
		scores[size++] = b;
		this.name = a;

	}

	public int PrintLastPoints() {
		return scores[size - 1];
	}

	public int firstPointNum() {
		for (int i = 0; i < size; i++) {
			if (scores[i] > scores[size - 1]) {
				return num[i];
			}
		}
		return num[size -1];
	}
}
