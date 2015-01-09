package basicProgram;

import java.util.Scanner;

public class theLeastRoundWay3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int flag = -1;
		int origin[][] = new int[n][n];
		leastZero deal[][] = new leastZero[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				deal[i][j] = new leastZero();
				flag = in.nextInt();
				if (flag % 2 == 0) {
					deal[i][j].two = 1;
				} else if (flag % 5 == 0) {
					deal[i][j].five = 1;
				}
				mainP(deal, 2, i, j);

			}
		}
		if (deal[n - 1][n - 1].two <= deal[n - 1][n - 1].five) {
			System.out.println(deal[n - 1][n - 1].two);
			System.out.println(deal[n - 1][n - 1].stepsTwo);
		} else {
			System.out.println(deal[n - 1][n - 1].five);
			System.out.println(deal[n - 1][n - 1].stepsFive);
		}

	}

	public static void mainP(leastZero deal[][], int a, int i, int j) {
		if (i == 0 && j != 0) {
			deal[i][j].add(deal[i][j - 1], "R");
		}
		if (i != 0 && j == 0) {
			deal[i][j].add(deal[i - 1][j], "D");
		}
		if (i != 0 && j != 0) {
			if (a == 2) {
				if (deal[i][j - 1].two <= deal[i - 1][j].two) {
					deal[i][j].add(deal[i][j - 1], "R");
				} else {
					deal[i][j].add(deal[i - 1][j], "D");
				}
			} else {

				if (deal[i][j - 1].five <= deal[i - 1][j].five) {
					deal[i][j].add(deal[i][j - 1], "R");
				} else {
					deal[i][j].add(deal[i - 1][j], "D");
				}

			}
		}
	}
}

class leastZero {
	public int two = 0;
	public int five = 0;
	public String stepsTwo = "";
	public String stepsFive = "";

	public void clean() {
		this.two = 0;
		this.five = 0;
		this.stepsTwo = "";
	}

	public void add(leastZero a, String c) {
		this.two += a.two;
		this.five += a.five;
		this.stepsTwo = a.stepsTwo + c;
		this.stepsFive = a.stepsFive + c;
	}

}