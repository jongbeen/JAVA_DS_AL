package Sort;

public class MergeSort {
	static int[] buff = new int[10];
	
	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1,0};
		Mergesort(array,0,9);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	
	}
	
	static void Mergesort(int[] arr,int left, int right) {
		if (left < right) {
			System.out.println("left: "+left);
			System.out.println("right: "+right);
			int i;
			int center = (left + right) /2;
			int p =0;
			int j = 0;
			int k = left;
			
			Mergesort(arr,left, center);
			Mergesort(arr,center+1,right);
			
			for(i = left; i<=center; i++) {
				buff[p++] =  arr[i];
			}
			
			while(i<=right && j< p) {
				arr[k++] = (buff[j] <= arr[i]) ? buff[j++] : arr[i++];
			}
			while(j<p) {
				arr[k++] = buff[j++];
			}
		}
	}

}


