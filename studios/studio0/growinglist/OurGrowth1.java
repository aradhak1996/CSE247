package studio0.growinglist;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class OurGrowth1 extends Rarrays {

	/**
	 * Try some function you think will work here.
	 */
	
	public int getNewSize() {
		if(array.length >= 10) {
			int newSize = (int)(array.length / 10);
			
		}
		return newSize;
	}
	
	public String toString() { return "Grow by our own function (1)"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"growth1", 
				"studio0.growinglist.OurGrowth1", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
