package sorters;


public class ThreeWayQuick extends Sorter{
	
	private String name ="Quick Sort & dutch flag";

//////////////////////////////////////////////////////MAIN///////////////////////////////////////////////////////
	private int[] partition(Integer[] A,int left,int right) {
		
		int[] pivots = new int[2];
		int amount = 0;
		//one forward pass anything smaller than one to the right 
		//swap(A,centre,right);
		int pivot = A[right];
		int p = left -1;
		for (int i=left;i<=right-1;i++) {
			if (A[i] < pivot) {
				p++;
				swap(A,p,i);
			}
		}
		int r = right+1;
		
		//one backward pass anything bigger than one to the right 
		for (int i=right-1;i >= left;i--) {
			if(A[i] == pivot) {amount++;}
			if (i==left) {
				pivots[0] = left;
				pivots[1] = i+amount;
			}
		
			if (A[i]<pivot) {
				pivots[0] = i+1;
				pivots[1] = r-1;
				break;
			}
			else if(A[i] > pivot) {
				r--;
				swap(A,r,i);
			}
		}
		return pivots;
		
		
	}
	
	public void sort(Integer[] A,int start,int end) {
		
		if (start < end && end-start + 1 > 2) {
			int[] pivots = partition(A,start,end);

			sort(A,start,pivots[0]-1);
			sort(A,pivots[1]+1,end);
		}
		else if (end-start + 1 == 2) {
			sortTwo(A,start,end);
		}
	}
	
	
//////////////////////////////////////////////////////HELPER FUNCTIONS///////////////////////////////////////////////////////
	
	public String getName() {
		return this.name;
	}
}
