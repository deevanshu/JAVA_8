package com.javatechie.stream.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachDemo {
	
	
	// T apply(T t); method 

	// filter----> conditional check

	public static void main(String[] args) {

		 Function<Integer, Double> half = a -> a / 2.0;  // 5 as output
		 
	        // Now treble the output of half function
	        half = half.andThen(a -> 3 * a);  // 15 answer
	 
	        // Applying the function to get the result
	        // and printing on console
	        System.out.println(half.apply(10));
        
		

	}
}
