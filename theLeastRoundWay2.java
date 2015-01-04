import java.util.Scanner;

public class theLeastRoundWay2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		leastZero b[][] = new leastZero[2][n];
		leastZero c[][] = new leastZero[2][n];
		int a[][] = new int[n][n];
		int k = -1;
		int s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i < 2){
					b[i][j] = new leastZero();
					c[i][j] = new leastZero();
				}
				k = i % 2;
				s = 1 - k;
				a[i][j] = in.nextInt();
				b[k][j].clean();
				c[k][j].clean();
				
				if (a[i][j] % 2 == 0) {
					b[k][j].two = c[k][j].two = 1;
				}
				if (a[i][j] % 5 == 0) {
					b[k][j].five = c[k][j].five = 1;
				}
				
				if (i == 0) {
					if (j != 0) {
						b[k][j].add(b[k][j - 1], b[k][j - 1].steps + "R");
						c[k][j].add(c[k][j - 1], c[k][j - 1].steps + "R");
					} else {
						continue;
					}
				} else if (j == 0) {
					b[k][j].add(b[s][j], b[s][j].steps + "D");
					c[k][j].add(c[s][j], c[s][j].steps + "D");
				} else {
					if (b[k][j - 1].two <= b[s][j].two) {
						b[k][j].add(b[k][j - 1], b[k][j - 1].steps + "R");
					} else {
						b[k][j].add(b[s][j], b[s][j].steps + "D");
					}
					if (c[k][j - 1].five <= c[s][j].five) {
						c[k][j].add(c[k][j - 1], c[k][j - 1].steps + "R");
					} else {
						c[k][j].add(c[s][j], c[s][j].steps + "D");
					}
				}
				// test System.out.println(b[k][j].steps+" " +i+"  j"+j + " two:" +b[k][j].two);
			}

		}
		k = (n-1) %2;
		if (c[k][n - 1].zeroS() > b[k][n - 1].zeroS()) {
			System.out.println(b[k][n - 1].zeroS());
			System.out.println(b[k][n - 1].steps);
		} else {
			System.out.println(c[k][n - 1].zeroS());
			System.out.println(c[k][n - 1].steps);
		}
	}
}

class leastZero {
	public int two = 0;
	public int five = 0;
	public String steps = "";
	
	public void clean(){
		this.two = 0;
		this.five = 0;
		this.steps = "";
	}
	public void add(leastZero a, String c) {
		this.two += a.two;
		this.five += a.five;
		steps += c;
	}

	public int zeroS() {
		return two < five ? two : five;
	}
}