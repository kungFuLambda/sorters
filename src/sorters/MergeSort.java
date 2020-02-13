package sorters;

public class MergeSort extends Sorter{
	String name = "Merge Sort";

	public void merge(Integer[] input,int p,int q,int r) {

		//calculate size of arrays
		int sizeLeft = q-p +1;
		int sizeRight = r-q;
		
		//initialize arrays L and R
		Integer[] L = new Integer[sizeLeft]; // [...]
		Integer[] R = new Integer[sizeRight]; // [...]
		
		//copy arrays to new arrays L and R
		System.arraycopy(input, p,L, 0,sizeLeft);
		System.arraycopy(input, q+1, R, 0, sizeRight);
		
		//initialize pointers
		int leftPointer = 0;
		int rightPointer = 0;
		int index = p;

		//start looping over the right and left array at the same time
		while (leftPointer <= sizeLeft-1 && rightPointer <= sizeRight-1) {
			//choose between the right and the left array to put into the input array at the index
			if (L[leftPointer]<=R[rightPointer]) {
				input[index] = L[leftPointer];
				leftPointer++;
			} else {
				input[index] = R[rightPointer];
				rightPointer++;
			}
			index++;
		}
		
		//fill out the remaining of the input array with the remaining items from either L or R
		if (leftPointer < sizeLeft ) {
			for (int i = leftPointer ; i <= sizeLeft-1 ;i++) {
				input[index] = L[leftPointer];
				index++;
			}
			
		} else {
			for (int i = rightPointer ; i <= sizeRight-1 ;i++) {
				input[index] = R[rightPointer];
				index++;
			}
			
		}
	}
	
	
	//mergesort main function
	public void sort(Integer[] input,int p,int r) {
		
		//until size is 2
		if(p < r) {
			int q = (p+r)/2; //midpoint
			sort(input,p,q); //left recursion
			sort(input,q+1,r); //right recursion
			merge(input,p,q,r); //merge starting at size 2
			
		}
		
	}

	@Override
	public String getName() {
		return this.name;
	}

}
