package Sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = {5,2,7,9,1,6,3,8,4,10};
		quicksort(array,0,array.length-1);
		
		for(int i=0; i<array.length;i++)
			System.out.print(array[i]+" ");		
	}
	
	static void quicksort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl <= pr) 
				swap(a,pl++,pr--);
		}while(pl<=pr);
		
		if(left < pr) quicksort(a, left, pr);
		if(pl < right) quicksort(a, pl, right);
	}
	
	static void swap(int a[], int left, int right) {
		int temp =0;
		temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

}
