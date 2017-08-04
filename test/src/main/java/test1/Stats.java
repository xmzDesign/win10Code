package test1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;

public class Stats { 
	public static void main(String[] args) {
		Bag<Double> numbers=new Bag<Double>();
		while(StdIn.isEmpty()){
			numbers.add(StdIn.readDouble());
		}
	}

}
