package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */

	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		////////..
		
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		Integer[] ans = new Integer[n];
		
		if(n == 0 || n == 1) {
			ticker.tick();
			return input;
		}
		else {
			Integer[][] KArray = new Integer[K][n/K];
			ticker.tick();
			int count = 0;
			for(int i=0; i<K; i++) {
				Integer[] partition = new Integer[n/K];
				ticker.tick();
				for(int j=0; j<n/K; j++) {
					partition[j] = input[count];
					ticker.tick();
					count += 1;
				}
				
				KArray[i] = kwaymergesort(K, partition, ticker);
				ticker.tick();
				
			}
			
			
			
			
			return merge(KArray,K,ticker);
		}
			
	}
	
	public static Integer[] merge(Integer[][] KArray, int K, Ticker ticker) {
		
		int counter = 0;
		int sortedLength = KArray[0].length * K;
		Integer[] ans = new Integer[sortedLength];
		ticker.tick();
		int[] pointers = new int[K];
		ticker.tick();
		while(counter < sortedLength) {
			int min = Integer.MAX_VALUE;
			int position = 0;
			for(int i=0; i<K; i++) {
				if(pointers[i] < KArray[0].length && KArray[i][pointers[i]] < min) {
					min = KArray[i][pointers[i]];
					ticker.tick();
					position = i;
				}
			}
			pointers[position] += 1;
			ans[counter] = min;
			counter += 1;
			
		}
		
		
		return ans;
		
		
		
	}
	

	
}


