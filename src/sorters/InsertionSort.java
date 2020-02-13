package sorters;

public class InsertionSort extends Sorter{
	
	String name = "Insertion sort";
	
	@Override
	public void sort(Integer[] A, int a2, int b) {
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



	public String getName() {
		return this.name;
	}

}
