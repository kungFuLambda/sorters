package sorters;

public class QuickInsertion extends Sorter{
	
	private String name ="Quick Sort & Insertion";
	private int cutoff;
	
	
	public QuickInsertion(int cutoff) {
		this.cutoff = cutoff;
	}
	
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
	
	public void sort(Integer[] A,int beginning, int end) {
		if (beginning < end && (end-beginning) >= this.cutoff) {
			int mid = partition(A,beginning,end);
			sort(A,beginning,mid-1);
			sort(A,mid+1,end);
		}
		if(end == A.length-1 && beginning == 0 ) {
			insertionSort(A);
		}
	}
	

	
	
	public void insertionSort(Integer[] A){
		int n = A.length;
		
		for (int j=0;j<=n-1;j++) {
			
			int key = A[j];
			int i = j-1;
			
			while (i>= 0 && A[i]>key) {
				
				A[i+1] = A[i];
				i = i-1;
			}
			
			A[i+1] = key;
		}
	}
	
//////////////////////////////////////////////////////HELPER FUNCTIONS///////////////////////////////////////////////////////	
	
	public String getName() {
		return this.name;
	}
	





	
	
}
