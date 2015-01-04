import java.util.Scanner;

/***
 * 
 * @author NSX
 * @version 1.01 在test测试数据1000个1的时候 内存超标。故改用theLeastRoundWay2
 */
public class theLeastRoundWay {
	public static void main(String[] args) {
		// 输入 n * n 矩阵；
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[][] = new int[n][n];
		String twoSteps ="";
		String fiveSteps ="";
		int twoNum = 0;
		int fiveNum = 0;
		lessZero b[][] = new lessZero[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
				b[i][j] = new lessZero();
				if (a[i][j] %2 == 0) {
					b[i][j].two  = 1;

				}
				if (a[i][j] % 5 == 0) {
					b[i][j].five = 1;
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(b[i][j].two+" ");
//			}
//			System.out.println();
//		}
		// 2的倍数
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i != 0 && j != 0) {
					if (b[i][j - 1].two <= b[i - 1][j].two) {
						b[i][j].add(b[i][j - 1], b[i][j - 1].steps + "R");
					} else {
						b[i][j].add(b[i - 1][j], b[i - 1][j].steps + "D");
					}
				} else if (i == 0) {
					b[i][j].add(b[i][j - 1], b[i][j - 1].steps + "R");

				} else {
					b[i][j].add(b[i - 1][j], b[i - 1][j].steps + "D");
				}
			}
		}
		twoNum =  b[n - 1][n - 1].zeroS();
	    twoSteps = b[n - 1][n - 1].steps;
		// 5的倍数
	    
	    for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j].clean();
				if (a[i][j] %2 == 0) {
					b[i][j].two  = 1;

				}
				if (a[i][j] % 5 == 0) {
					b[i][j].five = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i != 0 && j != 0) {
					if (b[i][j - 1].five <= b[i - 1][j].five) {
						b[i][j].add(b[i][j - 1], b[i][j - 1].steps + "R");
					} else {
						b[i][j].add(b[i - 1][j], b[i - 1][j].steps + "D");
					}
				} else if (i == 0) {
					b[i][j].add(b[i][j - 1], b[i][j - 1].steps+ "R");

				} else {
					b[i][j].add(b[i - 1][j], b[i - 1][j].steps+ "D");
				}
			}
		}
		fiveNum = b[n - 1][n - 1].zeroS();
		fiveSteps = b[n - 1][n - 1].steps;
		if (fiveNum > twoNum) {
			System.out.println(twoNum);
			System.out.println(twoSteps);
		} else {
			System.out.println(fiveNum);
			System.out.println(fiveSteps);
		}
	}
	
}

class lessZero {
	public int two = 0;
	public int five = 0;
	public String steps="";
	
	public void clean(){
		this.two = 0;
		this.five = 0;
		this.steps = "";
	}
	public void add(lessZero a, String c) {
		this.two += a.two;
		this.five += a.five;
		steps += c;
	}

	public int zeroS() {
		return two < five ? two : five;
	}
}
