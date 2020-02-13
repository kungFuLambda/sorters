package sorters;

public class WorstCaseGenerator {
	
	public Integer[] generate(int size) {
		Integer[] A = new Integer[size];
		int mid = size/2;
		A[mid] = 0;
		A[mid-1] = 1;
		for(int i=mid+1;i<=size-1;i++) {
			A[i] = A[i-1] +2;
		}
		for (int i=mid-2;i>=0;i--) {
			A[i] = A[i+1] +2;
		}
		return A;
	}
}