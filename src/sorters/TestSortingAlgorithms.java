package sorters;



public class TestSortingAlgorithms {

	public static void main(String[] args) throws InterruptedException {
		
		//initialise sorters and generator, quickInsert takes cutoff value k in constructor
		Sorter quick = new QuickSort();
		Sorter quickInsert = new QuickInsertion(20);
		Sorter quickMedian = new QuickOfThree();
		Sorter quickDutch = new ThreeWayQuick();
		//Sorter insertion = new InsertionSort();
		Sorter merge = new MergeSort();
		WorstCaseGenerator generator = new WorstCaseGenerator();		

		

		//initialise arrays for sorts and files
		Sorter[] runners = {quick,quickInsert,quickMedian,quickDutch,merge};
		String[] files = {"int10.txt","int50.txt","int100.txt","int1000.txt","int20k.txt","int500k.txt","intBig.txt","dutch.txt"};
		
		
		//for every sample size run all sorters in runners
		for(String file:files) {
			
			//print and read file
			printBigLine();
			FileReader readA = new FileReader();
			Integer[] a = readA.readFile(System.getProperty("user.dir")+"/Files/"+file);
			System.out.println("sorting on set:" + file);
			printBigLine();
			
			//go over every sorter, flag array to test if sorted
			boolean flag = true;
			
			for (Sorter s:runners) {
				Integer[] copied = new Integer[a.length];
				System.arraycopy(a,0,copied,0, a.length);
				
				timesort(s,copied);
				if(!(s.test(copied))) {
					flag = s.test(copied);
				};
			}
			printBigLine();
			System.out.println("all the lists were sorted: "+flag);
			printBigLine();
			System.out.println("\n");
		}
		
		
		
		//worst case scenario targeting.
		
		printBigLine();
		System.out.println("Worst case array targeting median of three:");
		String compareFile = "int500k.txt";
		FileReader readA = new FileReader();
		printBigLine();
		
		//generate arrays
		Integer[] comparison = readA.readFile("C:\\Users\\Leont\\OneDrive\\Documents\\UNI\\CS\\year2\\ADS\\labs\\Files\\"+compareFile);
		Integer[] worstArray = generator.generate(30000);
		
		//print and run sorts.
		System.out.print("base case: ");
		long timegood = timesort(quickMedian,comparison);
		System.out.print("worst case array: ");
		long timebad = timesort(quickMedian,worstArray);
		printBigLine();
		System.out.println("worst case scenario performed aprroximately : " + ((float)(timebad/timegood))*100 +"% worst");
		

		
		
	}
	
	
	/*
	Helper functions
	*/
	
	//runs sorting algorithm, and times it. Calls other helper f to print
	public static long timesort(Sorter sorterino,Integer[] A) {
		long start = System.nanoTime();
		sorterino.sort(A,0,A.length-1);
		long end = System.nanoTime();
		printTime(end-start,sorterino.getName());
		return end-start;
	}
	
	
	//print time, if bigger than one millisecond print in milliseconds.
	public static void printTime(long time,String name) {
		if (time > 1000000) {
			System.out.println("|"+name + "| : [" + time/1000000 + " milli-seconds]");
		}
		else {
			System.out.println("|"+name + "| : [" +time+" nano-seconds]");
		}
	}
	
	// print a big line
	public static void printBigLine() {
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
}
	
	
	


	

