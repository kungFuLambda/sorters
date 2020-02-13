package sorters;

public class QuickOfThree extends Sorter{
	private String name ="Quick Sort & Median";
	
	
//////////////////////////////////////////////////////MAIN///////////////////////////////////////////////////////	
	
	
	private int findMedian(Integer[] A,int left,int right) {
		int center = (left+right)/2;
		
		
		if (A[left] > A[right]) {
			
			swap(A,left,right);
		}
		
		if (A[left] > A[center]) {
			
			swap(A,left,center);
		}
		
		if (A[right] < A[center]) {
			swap(A,right,center);
		}
		swap(A,center,right-1);
		return A[right-1];
	}
	
	
	
	
	private int partition(Integer[] A,int left, int right) {
		
		
		int pivot = findMedian(A,left,right); //choose pivot
		int  leftPointer= left-1; //start index outside
		for (int rightPointer = left ; rightPointer <= right-2 ; rightPointer++) {
			if (A[rightPointer] <= pivot) {
				leftPointer++;
				swap(A,leftPointer,rightPointer);
			}
		}
		swap(A,leftPointer+1,right-1);
		return leftPointer +1;
		
	}
	
	
	

	public void sort(Integer[] A,int left, int right) {
		
		

		if (left < right && right-left + 1 >2) {

		    int partition = partition(A,left, right);
		    sort(A,left, partition - 1);
		    sort(A,partition + 1, right);
		}
		
		else if (right-left + 1 == 2) {
			sortTwo(A,left,right);
		}
	}
	

	
//////////////////////////////////////////////////////HELPER FUNCTIONS///////////////////////////////////////////////////////	
	
	
	public String getName() {
		return this.name;
	}

}
