package sorters;


public class QuickSort extends Sorter{
	
	private String name = "Quick Sort";
	
//////////////////////////////////////////////////////MAIN///////////////////////////////////////////////////////
	
	private int partition(Integer[] A,int beginning, int end) {
		
		int pivot = A[end]; //choose pivot
		int  leftPointer= beginning-1; //start index outside
		for (int rightPointer = beginning ; rightPointer <= end-1 ; rightPointer++) {
			if (A[rightPointer] <= pivot) {
				leftPointer++;
				swap(A,leftPointer,rightPointer);
			}
		}
		swap(A,leftPointer+1,end);
		return leftPointer +1;
		
	}
	
	public void sort(Integer[] A,int start, int end) {
		if (start < end) {
			
			int mid = partition(A,start,end);
			sort(A,start,mid-1);
			sort(A,mid+1,end);
		}
	}

//////////////////////////////////////////////////////HELPER FUNCTIONS///////////////////////////////////////////////////////

	
	public String getName() {
		return this.name;
	}
	
	
	
}
