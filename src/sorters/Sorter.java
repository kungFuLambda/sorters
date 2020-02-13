package sorters;

public abstract class Sorter {
	public abstract void sort(Integer[] A,int a,int b);
	
	protected  boolean test(Integer[] a) {
		for (int i=0 ; i <a.length-1 ; i++) {
			if (a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public abstract String getName();

	protected void swap(Integer[] A,int a,int b){
		int buffer = A[a];
		A[a] = A[b];
		A[b] = buffer;
	}
	
	protected void sortTwo(Integer[] A,int left,int right) {
		if (A[left]>A[right]) {
			swap(A,left,right);
		}
	}

}
