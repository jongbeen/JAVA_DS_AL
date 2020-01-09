
public class HeapManager {
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		System.out.println(heap.pop());
		System.out.println();
		heap.printAll();
		
	}
}


class Heap{
	private int heap_array[];
	private int capacity;
	public int ptr;
	
	public Heap(int size) {
		heap_array = new int[size];
		capacity = size;
		heap_array[0] = (Integer) 0;
		ptr = 1;
	}
	
	public void insert(int data) {
		if (this.ptr == 1) { 
			heap_array[ptr] = data;
			ptr++;
		}
		else {
		heap_array[ptr++] = data;
		int inserted_idx = ptr-1;
			
		while(move_up(inserted_idx)) {
			int parent_idx = (int)(inserted_idx / 2);
			swap(inserted_idx,parent_idx);
			inserted_idx = parent_idx;			
			}
		}	
	}
	
	public boolean move_up(int inserted_idx) {
		if (inserted_idx <=1) 
			return false;
		
		int parent_idx = (int)(inserted_idx / 2);
		if( heap_array[inserted_idx] > heap_array[parent_idx]) {
			return true;
		}
		else
			return false;
	}
	public void swap(int index1, int index2) {
		int temp = 0;
		temp = heap_array[index1];
		heap_array[index1] = heap_array[index2];
		heap_array[index2] = temp;
	}
	public void printAll() {
		for(int i=0; i<heap_array.length;i++) {
			System.out.println(i+": "+heap_array[i]);
		}
	}
	
	public boolean move_down(int pop_idx) {
		int Lchild_idx = pop_idx *2;
		int Rchild_idx = (pop_idx *2 + 1);
		
		if (Lchild_idx >= this.ptr-1)
			return false;
		else if(Rchild_idx >= this.ptr-1) {
			if(heap_array[Lchild_idx] > heap_array[pop_idx])
				return true;
			else
				return false;				
		}
		else {
			if(heap_array[Lchild_idx] > heap_array[Rchild_idx]) {
				if(heap_array[Lchild_idx] > heap_array[pop_idx])
					return true;
				else
					return false;
			}
			else {
				if(heap_array[Rchild_idx] > heap_array[pop_idx])
					return true;
				else
					return false;
			}
		}
	}
	
	public int pop() {
		int returned_data = this.heap_array[1];
		this.heap_array[1] = this.heap_array[--ptr];
		this.heap_array[ptr] = 0;
		int pop_idx = 1;
		
		while(move_down(pop_idx)) {
			int Lchild_idx = pop_idx *2;
			int Rchild_idx = (pop_idx *2 + 1);
			
			if(Rchild_idx >= this.ptr-1) {
				if(heap_array[Lchild_idx] > heap_array[pop_idx]) {
					swap(Lchild_idx,pop_idx);
					pop_idx = Lchild_idx; 
				}
			}
			else {
				if(heap_array[Lchild_idx] > heap_array[Rchild_idx]) {
					if(heap_array[Lchild_idx] > heap_array[pop_idx]) {
						swap(Lchild_idx,pop_idx);
						pop_idx = Lchild_idx;
					}
				}
				else {
					if(heap_array[Rchild_idx] > heap_array[pop_idx]) {
						swap(Rchild_idx,pop_idx);
						pop_idx = Rchild_idx;
					}
				}
			}
		}
		return returned_data;
	}
	
}


















