package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;

public class PredicateDemo {

	public static void main(String[] args) {

		// boolean test(T t)   functional chaining can be done using and or  ->  p1.and(p2).test(input)   ,  p1.or(p2).test(input)  // checks both the
		//                                                                                                                conditions r satisfied or not.
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		list1.stream().filter(t -> t % 2 == 0)
		
		
		
		.forEach(t -> System.out.println("print  Even: " + t));
	}
}
