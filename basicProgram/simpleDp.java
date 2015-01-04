package basicProgram;
public class simpleDp {
	public static void main(String[] args) {
		int a[] = { 5, 3, 4, 8, 6, 7 };
		note b[] = new note[6];
		for (int i = 0 ;i <6 ; i++) {
			b[i] = new note();
		}
		int len = 0;
		for (int i = 0; i < a.length; i++) {
			b[i].sum = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && (b[j].sum + 1) > b[i].sum) {
					b[i].sum = b[j].sum + 1;
					b[i].pront = j;
				}
				if (b[len].sum < b[i].sum)
					len = i;
			}
		}
		System.out.println(b[len].sum);
		while(len>0){
			System.out.println(len );
			len = b[len].pront;
		}
			
		

	}
}

class note {
	public note() {
		// TODO Auto-generated constructor stub
		this.sum = 0 ;
		this.pront = -1;
	}

	public int sum = 0;
	public int pront = -1;
}
