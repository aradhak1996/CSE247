package rabinkarp;

import java.util.LinkedList;

public class RK {
	
	private int windowLength = 0;
	private LinkedList<Character> window;
	private int exp = 1;
	private int hash = 0;
	
	
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		
		this.windowLength = m;
		this.window = new LinkedList<Character>();
		Character charZero = (char)0;
		for(int i=0; i<m; i++) {
			exp = (exp * 31) % 511;
			window.add(charZero);
		}

	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		
		Character deletedCh = (char)0;
		window.addLast(d);
		if(window.size() > windowLength) {
			deletedCh = window.removeFirst();
		}
		
		hash = (hash * 31 - exp * (int)deletedCh + d) % 511;
		
		if(hash < 0) {
			hash += 511;
		}
		
		return hash;
	}

}
