package Sort;

public class Bubble_Sort {
	public static void main(String[] args) {
		int[] table = {5,1,2,6,3,8,9,10};
		
		for(int i=0; i<table.length-1;i++) {
			for(int j=i; j<table.length;j++) {
				if(table[i]> table[j]) {
					int temp =0;
					temp = table[i];
					table[i] = table[j];
					table[j] = temp;
				}
			}
		}
		
		for(int i=0; i<table.length;i++) {
			System.out.print(table[i]+"  ");
		}
	}

}
