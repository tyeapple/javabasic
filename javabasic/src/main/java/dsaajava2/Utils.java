package dsaajava2;

public class Utils {

	public static void main(String[] args) {
		//GenericMemoryCell<String>[] arr1 = new GenericMemoryCell<String>[10];
	}
	
//	public static void printOut(int n) {
//		if(n>=10)
//			printOut(n/10);
//		printDigit(n % 10);
//	}
	
	public static <T extends Comparable<? super T>>
	T findMax(T[] arr) {
		int maxIndex = 0;
		for(int i = 1; i< arr.length; i++)
			if(arr[i].compareTo(arr[maxIndex]) > 0)
				maxIndex = i;
		return arr[maxIndex];
	}
	
	public static <T extends Comparable<? super T>>
	int binarySearch(T[] a, T x) {
		
		int low = 0, high = a.length -1;
		while(low <= high) {
			
			int mid = (low+high)/2;
			if(a[mid].compareTo(x) < 0)
				low = mid + 1;
			else if(a[mid].compareTo(x) > 0)
				high = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
