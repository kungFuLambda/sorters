package sorters;

public class MainRunner {
	public static void main(String[] args) {
		String fileRead = "int20k.txt";
		FileReader readA = new FileReader();
		
		Integer[] array = readA.readFile("C:\\Users\\Leont\\OneDrive\\Documents\\UNI\\CS\\year2\\ADS\\labs\\Files\\"+fileRead);
		long quickSort = System.currentTimeMillis();
		QuickSort(array,0,array.length-1);
		long quickSort2 = System.currentTimeMillis();
		System.out.println(quickSort2-quickSort);
		
		Integer[] array2 = readA.readFile("C:\\Users\\Leont\\OneDrive\\Documents\\UNI\\CS\\year2\\ADS\\labs\\Files\\"+fileRead);
		long insertSort = System.currentTimeMillis();
		Insertionsort(array2,0,array2.length-1);
		long insertSort2 = System.currentTimeMillis();
		System.out.println(insertSort2-insertSort);
		
		Integer[] array3 = readA.readFile("C:\\Users\\Leont\\OneDrive\\Documents\\UNI\\CS\\year2\\ADS\\labs\\Files\\"+fileRead);
		long medSort = System.currentTimeMillis();
		Threesort(array3,0,array3.length-1);
		long medSort2 = System.currentTimeMillis();
		System.out.println(medSort2-medSort);
		
		
		Integer[] array4 = readA.readFile("C:\\Users\\Leont\\OneDrive\\Documents\\UNI\\CS\\year2\\ADS\\labs\\Files\\"+fileRead);
		long tsort = System.currentTimeMillis();
		Twaysort(array4,0,array4.length-1);
		long tSort2 = System.currentTimeMillis();
		System.out.println(tSort2-tsort);
		
		

	}
////////////////////////////////////////UNIVERSAL//////////////////////////////////////////////////////////
	private static void swap(Integer[] A,int a,int b){
		int buffer = A[a];
		A[a] = A[b];
		A[b] = buffer;
	}
	protected static boolean test(Integer[] a) {
		for (int i=0 ; i <a.length-1 ; i++) {
			if (a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////QUICK SORT//////////////////////////////////////////////////////////
	private static int QuickSortPartition(Integer[] A,int beginning, int end) {
			
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
		
		protected static void QuickSort(Integer[] A,int start, int end) {
			if (start < end) {
				
				int mid = QuickSortPartition(A,start,end);
				QuickSort(A,start,mid-1);
				QuickSort(A,mid+1,end);
			}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////INSERTION//////////////////////////////////////////////////////////
	protected static void Insertionsort(Integer[] A,int beginning, int end) {
		if (beginning < end && (end-beginning) >= 20) {
			int mid = QuickSortPartition(A,beginning,end);
			Insertionsort(A,beginning,mid-1);
			Insertionsort(A,mid+1,end);
		}
		if(end == A.length-1 && beginning == 0 ) {
			insertion(A);
		}
	}
	
	public static void insertion(Integer[] A){
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////UNIVERSAL//////////////////////////////////////////////////////////
	private static int findMedian(Integer[] A,int left,int right) {
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
		
		swap(A,center,right);
		return A[right];
	}
	
	
	
	
	private static int Threepartition(Integer[] A,int left, int right) {
		
		
		int pivot = findMedian(A,left,right); //choose pivot
		int  leftPointer= left-1; //start index outside
		for (int rightPointer = left ; rightPointer <= right-1 ; rightPointer++) {
			if (A[rightPointer] <= pivot) {
				leftPointer++;
				swap(A,leftPointer,rightPointer);
			}
		}
		swap(A,leftPointer+1,right);
		return leftPointer +1;
		
	}
	
	
	

	protected static void Threesort(Integer[] A,int left, int right) {
		
		

		if (left < right && right-left + 1 >2) {

		    int partition = Threepartition(A,left, right);
		    Threesort(A,left, partition - 1);
		    Threesort(A,partition + 1, right);
		}
		
		else if (right-left + 1 == 2) {
			sortTwo(A,left,right);
		}
	}
	private static void sortTwo(Integer[] A,int left,int right) {
		if (A[left]>A[right]) {
			swap(A,left,right);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////UNIVERSAL//////////////////////////////////////////////////////////
	private static int[] Twaypartition(Integer[] A,int left,int right) {
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
			//System.out.print(i+ " ");
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
	protected static void Twaysort(Integer[] A,int start,int end) {
		
		if (start < end && end-start + 1 > 2) {
			int[] pivots = Twaypartition(A,start,end);
	
			Twaysort(A,start,pivots[0]-1);
			Twaysort(A,pivots[1]+1,end);
		}
		else if (end-start + 1 == 2) {
			sortTwo(A,start,end);
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
